package ecisanitas;

public class EciSanitasException extends Exception {

    public static final String INVALID_TIME_SLOT = "Franja horaria fuera de rango";
    public static final String PATIENT_NOT_FOUND = "Paciente no encontrado";
    public static final String HOSPITAL_NOT_FOUND = "Hospital no encontrado";
    public static final String UNAVAILABLE_DOCTORS = "No hay doctores disponibles para la fecha y hora solicitada";

    public EciSanitasException(String message) {
        super(message);
    }

}
