package droids;

import structure.Weapon;

import java.io.Serial;
import java.io.Serializable;

public class AssaultDroid extends Droid implements Serializable {
    private static final long serialVersionUID = 1L;
    public AssaultDroid(String name, Weapon weapon) {
        super(name, 100, 20, weapon, 5, 0.8, 100, 20);
    }
}