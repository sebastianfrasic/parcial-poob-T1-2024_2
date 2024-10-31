package ecisanitas;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Hospital implements AppointmentProcessable {

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
    public Appointment createAppointment(Patient patient, String speciality, LocalDate date, int timeSlot) throws EciSanitasException {
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

        return generateAppointment(patient, assignedDoctor, date, timeSlot);

    }

    /**
     * Método encapsulado que genera una cita médica.
     * Encapsula la lógica de asignación de consultorio, creación de la cita, y asociación al paciente.
     *
     * @param patient  El paciente para quien se crea la cita.
     * @param doctor   El doctor asignado.
     * @param date     La fecha de la cita.
     * @param timeSlot La franja horaria de la cita.
     * @return
     */
    private Appointment generateAppointment(Patient patient, Doctor doctor, LocalDate date, int timeSlot) {

        try {
            // Asignar el consultorio
            Office office = doctor.getOffice();

            // Crear la cita
            Appointment appointment = new Appointment(doctor, office, date, timeSlot);

            // Asociar la cita al paciente
            patient.addAppointment(appointment);
            return appointment;
        } catch (EciSanitasException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void notifyAppointment(Notification notification) {
        System.out.println("Notificación para el hospital " + name + ": " + notification.getMessage() +
                " para el paciente " + notification.getAppointment().getDoctor().getName() +
                " con el doctor " + notification.getAppointment().getDoctor().getName() +
                " en la fecha " + notification.getAppointment().getFecha() +
                " en la franja " + notification.getAppointment().getTime() + ".");
    }
}
