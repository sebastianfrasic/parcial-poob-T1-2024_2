import lombok.Data;

import java.util.List;

@Data
public class Hospital {

    private String name;
    private String address;

    private List<Treatment> treatments;
    private List<Doctor> doctors;
    private List<Office> offices;
    private Location location;

}
