import lombok.Data;

import java.time.LocalDate;

@Data
public class Doctor {

    private String id;
    private String name;
    private String speciality;
    private String telefono;

    private Office office;

    private boolean[] availability = new boolean[36]; // Representa 36 franjas horarias


    // Verifica si el doctor está disponible en una franja horaria específica
    public boolean isAvailable(int timeSlot) {
        return availability[timeSlot];
    }
}
