package droids;

import structure.Weapon;

import java.io.Serializable;

public class MedicDroid extends Droid implements Serializable {
    private static final long serialVersionUID = 1L;
    public MedicDroid(String name, Weapon weapon) {
        super(name, 80, 10, weapon, 3, 0.9, 100, 15);
    }

    public boolean isMedic() {
        return true;
    }
}