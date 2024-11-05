package Main;

import droids.*;
import battle.*;
import io.BattleLog;
import arena.*;

import java.util.*;

public class DroidBattleSimulator {
    private List<Droid> droids = new ArrayList<>();
    private List<BattleArena> arenas = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private DroidManager droidManager;
    private BattleManager battleManager;

    public DroidBattleSimulator() {
        droidManager = new DroidManager(droids, scanner);
        battleManager = new BattleManager(droids, arenas, scanner);
        initializeArenas();
    }

    private void initializeArenas() {
        arenas.add(new DesertArena());
        arenas.add(new IceCaveArena());
        arenas.add(new JungleArena());
        arenas.add(new SpaceStationArena());
        arenas.add(new VolcanoArena());
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("🛠️ Меню:");
            System.out.println("1. Створити дроїда");
            System.out.println("2. Переглянути дроїдів");
            System.out.println("3. Бій 1 на 1");
            System.out.println("4. Командний бій");
            System.out.println("5. Завантажити і запустити бій 1 на 1");
            System.out.println("0. Вийти");
            System.out.print("Виберіть опцію: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    droidManager.createDroid();
                    break;
                case 2:
                    droidManager.listDroids();
                    break;
                case 3:
                    battleManager.oneOnOneBattle();
                    break;
                case 4:
                    battleManager.teamBattle();
                    break;
                case 5:
                    BattleLog battleLog = new BattleLog();
                    battleLog.loadLog("battle_log.ser"); // Завантаження журналу
                    battleLog.displayLog(); // Вивід журналу
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Невірний вибір.");
                    break;
            }
        }
    }


    public static void main(String[] args) {
        DroidBattleSimulator simulator = new DroidBattleSimulator();
        simulator.start();
    }
}
