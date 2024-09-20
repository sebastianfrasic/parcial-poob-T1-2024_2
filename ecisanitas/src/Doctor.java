import lombok.Data;

import java.time.LocalDate;

@Data
public class Doctor {

    private String id;
    private String name;
    private String speciality;
    private String telefono;

    private Office office;
    private boolean isAvailable;

    // Verifica si el doctor está disponible en una franja horaria específica

    /**
     * Verifica si el doctor está disponible en una fecha específica.
     *
     * @param date La fecha para la cual se verifica la disponibilidad.
     * @return true si el doctor está disponible, false si no lo está.
     */
    public boolean isAvailable(LocalDate date, int timeSlot) {
        // Aquí puede ir la lógica para determinar si el doctor está disponible en esa fecha.
        // Por simplicidad, retornamos el valor del atributo isAvailable.
        return this.isAvailable;
    }
}
