package ecisanitas;

import lombok.Data;

import java.util.List;

@Data
public class Illness {

    private String name;
    private String description;
    private List<Treatment> treatments;

}
