package droids;

import structure.Weapon;

import java.io.Serializable;

public class TankDroid extends Droid implements Serializable {
    private static final long serialVersionUID = 1L;
    public TankDroid(String name, Weapon weapon) {
        super(name, 150, 10, weapon, 10, 0.7, 100, 10);
    }
}