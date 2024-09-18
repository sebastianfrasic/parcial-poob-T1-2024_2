import lombok.Data;

import java.util.TreeMap;

@Data
public class ECISanitas {

    private TreeMap<String, Patient> patients;
    private TreeMap<String, Illness> illnesses;
    private TreeMap<String, Hospital> hospitals;

    public ECISanitas() {
        this.patients = new TreeMap<>();
        this.hospitals = new TreeMap<>();
    }
}
