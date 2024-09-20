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
        Patient patient = patients.get(patientId);
        Hospital hospital = hospitals.get(hospitalName);

        if (patient != null && hospital != null) {
            hospital.createAppointment(patient, requestedSpeciality, date, timeSlot);
        }

    }

}
