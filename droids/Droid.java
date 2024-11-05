package droids;

import structure.Weapon;

public abstract class Droid {
    protected String name;
    protected int health;
    protected int damage;
    protected Weapon weapon;
    protected int armor;
    protected double accuracy;
    protected double energy;
    protected int regeneration;
    protected int attacksMade;
    protected int damageTaken;

    public Droid(String name, int health, int damage, Weapon weapon, int armor, double accuracy, int energy, int regeneration) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.weapon = weapon;
        this.armor = armor;
        this.accuracy = accuracy;
        this.energy = energy;
        this.regeneration = regeneration;
        this.attacksMade = 0;
        this.damageTaken = 0;
    }

    // Перевіряє, чи дроїд ще живий
    public boolean isAlive() {
        return health > 0;
    }

    // Відновлює енергію
    public void regenerateEnergy() {
        energy += regeneration;
        if (energy > 100) {
            energy = 100; // Максимум 100 енергії
        }
    }

    // Показ здоров'я дроїда
    public void displayHealth() {
        System.out.printf("🤖 %s: Здоров'я: %d, Атак: %d, Шкода отримана: %d%n", name, health, attacksMade, damageTaken);
    }

    // Геттери і сеттери
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getArmor() {
        return armor;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(double energy) {
        this.energy = energy;
    }


    public int getAttacksMade() {
        return attacksMade;
    }

    public void setAttacksMade(int attacksMade) {
        this.attacksMade = attacksMade;
    }

    public int getDamageTaken() {
        return damageTaken;
    }

    public void setDamageTaken(int damageTaken) {
        this.damageTaken = damageTaken;
    }

    public boolean isMedic() {
        return false;
    }

    public void setAccuracy(double max) {
        this.accuracy = max;
    }

    public void setArmor(int v) {
        this.armor=v;
    }
}
