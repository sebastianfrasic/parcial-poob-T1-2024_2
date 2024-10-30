package ecisanitas;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Hospital {

    private String name;
    private String address;

    private List<Treatment> treatments;
    private List<Doctor> doctors;
    private List<Office> offices;
    private Location location;

    /**
     * Crea una cita médica asignando un doctor disponible al paciente.
     *
     * @param patient    El paciente para quien se crea la cita.
     * @param speciality La especialidad requerida.
     * @param date       La fecha de la cita.
     * @param timeSlot   La franja horaria de la cita.
     */
    public void createAppointment(Patient patient, String speciality, LocalDate date, int timeSlot) throws EciSanitasException {
        Doctor assignedDoctor = null;


        for (Doctor doctor : doctors) {
            if (doctor.getSpeciality().equals(speciality) && doctor.isAvailable(date, timeSlot)) {
                assignedDoctor = doctor;
                break;
            }
        }

        if (assignedDoctor == null) {
            throw new EciSanitasException(EciSanitasException.UNAVAILABLE_DOCTORS);
        }

        generateAppointment(patient, assignedDoctor, date, timeSlot);

    }

    /**
     * Método encapsulado que genera una cita médica.
     * Encapsula la lógica de asignación de consultorio, creación de la cita, y asociación al paciente.
     *
     * @param patient  El paciente para quien se crea la cita.
     * @param doctor   El doctor asignado.
     * @param date     La fecha de la cita.
     * @param timeSlot La franja horaria de la cita.
     */
    private void generateAppointment(Patient patient, Doctor doctor, LocalDate date, int timeSlot) {

        try {
            // Asignar el consultorio
            Office office = doctor.getOffice();

            // Crear la cita
            Appointment appointment = new Appointment(doctor, office, date, timeSlot);
            appointment.setDoctor(doctor);
            appointment.setOffice(office);
            appointment.setFecha(date);
            appointment.setTime(timeSlot);

            // Asociar la cita al paciente
            patient.addAppointment(appointment);
        } catch (EciSanitasException e) {
            e.printStackTrace();
        }

    }
}
