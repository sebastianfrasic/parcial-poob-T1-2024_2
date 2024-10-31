package ecisanitas;

import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Patient implements AppointmentProcessable {

    private String idCard;
    private String name;
    private String address;
    private LocalDate birthDate;
    private LocalDate registrationDate;

    private MedicalHistory medicalHistory;
    private List<Appointment> appointments;

    /**
     * Añade una cita médica al paciente.
     *
     * @param appointment La cita que se va a añadir.
     */
    public void addAppointment(Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }
        appointments.add(appointment);
    }

    public void addPatientIllness(Illness illness, Treatment treatment) {
        // Crear una nueva instancia de ecisanitas.PatientIllness
        PatientIllness newIllness = new PatientIllness();
        newIllness.setIllness(illness);

        List<Treatment> treatments = new ArrayList<>();
        treatments.add(treatment);
        newIllness.setTreatments(treatments);

        // Agregar a la historia clínica
        medicalHistory.getPatientIllnesses().add(newIllness);
        System.out.println("Historia clínica actualizada con éxito");
    }

    public void talk() {
        System.out.println("Hola");
    }

    @Override
    public void notifyAppointment(Notification notification) {
        System.out.println("Notificación para el paciente " + name + ": " + notification.getMessage() +
                " en la fecha " + notification.getAppointment().getFecha() +
                " en la franja " + notification.getAppointment().getTime() + ".");
    }
}
