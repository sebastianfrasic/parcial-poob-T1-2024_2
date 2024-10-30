package ecisanitas;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Appointment {

    private String id;
    private LocalDate fecha;
    private int time;
    private String reason;

    private Doctor doctor;
    private Office office;
    private List<PatientIllness> patientIllnesses;
    private List<Treatment> patientTreatments;

}
