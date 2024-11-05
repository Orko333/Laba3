package droids;

import structure.*;
import java.util.*;

import utils.*;

public class DroidManager {
    private List<Droid> droids;
    private Scanner scanner;

    public DroidManager(List<Droid> droids, Scanner scanner) {
        this.droids = droids;
        this.scanner = scanner;
    }

    public void createDroid() {
        Weapon[] weapons = {new Laser(), new Rocket(), new PlasmaCannon(), new Flamethrower()};
        System.out.println("Оберіть зброю для дроїда:");
        for (int i = 0; i < weapons.length; i++) {
            System.out.printf("%d. %s (Шкода: %d)%n", i + 1, weapons[i].getName(), weapons[i].getDamage());
        }
        int weaponChoice = scanner.nextInt() - 1;

        if (weaponChoice >= 0 && weaponChoice < weapons.length) {
            Weapon selectedWeapon = weapons[weaponChoice];
            System.out.print("Введіть ім'я дроїда: ");
            scanner.nextLine();
            String name = scanner.nextLine();

            System.out.println("Оберіть тип дроїда:");
            System.out.println("1. Штурмовик");
            System.out.println("2. Медик");
            System.out.println("3. Танк");
            System.out.println("4. Інженер");
            int typeChoice = scanner.nextInt();

            Droid newDroid = null;
            switch (typeChoice) {
                case 1:
                    newDroid = new AssaultDroid(name, selectedWeapon);
                    break;
                case 2:
                    newDroid = new MedicDroid(name, selectedWeapon);
                    break;
                case 3:
                    newDroid = new TankDroid(name, selectedWeapon);
                    break;
                case 4:
                    newDroid = new EngineerDroid(name, selectedWeapon);
                    break;
                default:
                    System.out.println("Невірний вибір.");
                    return;
            }
            droids.add(newDroid);
            System.out.println("Дроїд створений успішно.");
        } else {
            System.out.println("Невірний вибір зброї.");
        }
    }

    public void listDroids() {
        if (droids.isEmpty()) {
            System.out.println("Немає доступних дроїдів.");
        } else {
            System.out.println("Доступні дроїди:");
            for (int i = 0; i < droids.size(); i++) {
                Droid droid = droids.get(i);
                System.out.printf("🦾 Характеристики дроїда: %s" + ConsoleColors.RESET + "%n", droid.getName());
                System.out.printf(ConsoleColors.CYAN + "❤️ Здоров'я: %d/%d%n", droid.getHealth(), 100); // Припустимо, максимальне здоров'я 100
                System.out.printf(ConsoleColors.CYAN + "⚔️ Шкода: %d%n", droid.getDamage());
                System.out.printf(ConsoleColors.CYAN + "🛡️ Броня: %d%n", droid.getArmor());
                System.out.printf(ConsoleColors.CYAN + "🎯 Точність: %.2f%%%n", droid.getAccuracy()); // Відображення у відсотках
                System.out.printf(ConsoleColors.CYAN + "🔋 Енергія: %.2f%n" + ConsoleColors.RESET, droid.getEnergy());
                System.out.println();
            }
        }
    }
}
