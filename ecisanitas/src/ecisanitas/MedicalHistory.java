package ecisanitas;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class MedicalHistory {

    private LocalDate startDate;
    private Patient patient;
    private List<PatientIllness> patientIllnesses;

}
