package ecisanitas;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Notification {

    private String message;
    private Appointment appointment;

    public Notification(String message, Appointment appointment) {
        this.message = message;
        this.appointment = appointment;
    }

    public Notification(Appointment appointment) {
        this.appointment = appointment;
    }
}

