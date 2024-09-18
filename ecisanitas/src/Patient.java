import lombok.Data;

import java.time.LocalDate;
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

}
