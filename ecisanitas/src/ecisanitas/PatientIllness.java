package ecisanitas;

import lombok.Data;

import java.util.List;

@Data
public class PatientIllness {

    private int riskLevel;
    private Appointment appointment;
    private Illness illness;
    private List<Treatment> treatments;

}
