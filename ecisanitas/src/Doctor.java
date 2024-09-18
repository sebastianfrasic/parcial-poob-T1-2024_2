import lombok.Data;

@Data
public class Doctor {

    private String id;
    private String name;
    private String speciality;
    private String telefono;

    private Office office;


}
