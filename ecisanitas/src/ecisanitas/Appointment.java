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


    public Appointment(Doctor doctor, Office office, LocalDate fecha, int time) throws EciSanitasException {
        validateTimeSlot(time);
        this.fecha = fecha;
        this.time = time;
        this.doctor = doctor;
        this.office = office;
    }

    private void validateTimeSlot(int time) throws EciSanitasException {
        if (time < 1 || time > 36) {
            throw new EciSanitasException(EciSanitasException.INVALID_TIME_SLOT);
        }
    }
}
