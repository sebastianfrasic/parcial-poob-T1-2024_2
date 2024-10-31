package herencia;

import ecisanitas.Patient;

public class SickPatient extends Patient {

    public void talkk(){
        super.talk();
    }

    public static void main(String[] args) {
        SickPatient sickPatient = new SickPatient();
        sickPatient.talkk();
    }

}
