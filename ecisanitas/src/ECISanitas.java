import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.TreeMap;

@Data
public class ECISanitas {

    private TreeMap<String, Patient> patients;
    private TreeMap<String, Illness> illnesses;
    private TreeMap<String, Hospital> hospitals;

    // Invariante: Cada paciente debe tener un historial clínico y al menos una cita o enfermedad registrada.
    // El TreeMap de hospitales debe contener al menos un hospital activo para ofrecer servicios.

    public ECISanitas() {
        this.patients = new TreeMap<>();
        this.hospitals = new TreeMap<>();
    }


    /**
     * Agenda una cita médica para un paciente en un hospital específico, con un doctor de la especialidad solicitada.
     * *
     * * Reglas:
     * * 1. La cita solo se programa si hay un doctor disponible en el horario solicitado.
     * * 2. Se debe asignar un consultorio disponible que pertenezca al hospital.
     * * 3. Si no hay doctores disponibles, no se programa la cita.
     * * 4. El método itera sobre los doctores de la especialidad solicitada para verificar su disponibilidad.
     * *
     *
     * @param patientId           Id del paciente que solicita la cita.
     * @param hospitalName        El nombre del hospital donde se quiere programar la cita.
     * @param requestedSpeciality La especialidad del doctor requerido.
     * @param date                La fecha de la cita.
     * @param timeSlot            Franja horaria de la cita (1 = 8:00 a.m., 36 = 8:00 p.m.).
     */
    public void scheduleAppointment(String patientId, String hospitalName, String requestedSpeciality, LocalDate date, int timeSlot) {
        Patient patient = findPatientById(patientId);
        Hospital hospital = findHospitalByName(hospitalName);
        List<Doctor> doctors = hospital.getDoctors();

        // Verificar disponibilidad de doctores en esa especialidad y en ese horario
        for (Doctor doctor : doctors) {
            String doctorSpeciality = doctor.getSpeciality();
            boolean isDoctorAvailable = doctor.isAvailable(timeSlot);
            if (doctorSpeciality.equals(requestedSpeciality) && isDoctorAvailable) {
                Office office = doctor.getOffice();
                Appointment appointment = createAppointment(doctor, office, date, timeSlot);
                patient.addAppointment(appointment);
                break;
            }
        }
    }

    public Hospital findHospitalByName(String hospitalName) {
        return hospitals.get(hospitalName);
    }

    // Método para encontrar un paciente por su ID
    private Patient findPatientById(String patientId) {
        return patients.get(patientId);
    }


    // Método para crear una cita médica
    private Appointment createAppointment(Doctor doctor, Office office, LocalDate date, int timeSlot) {
        Appointment appointment = new Appointment();
        appointment.setDoctor(doctor);
        appointment.setOffice(office);
        appointment.setFecha(date);
        appointment.setTime(timeSlot);
        return appointment;
    }

}
