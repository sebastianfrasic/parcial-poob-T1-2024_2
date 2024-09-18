import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class Patient {

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

}
