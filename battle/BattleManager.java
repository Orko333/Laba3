package battle;

import droids.*;
import arena.*;
import java.util.*;

public class BattleManager {
    private List<Droid> droids;
    private List<BattleArena> arenas;
    private Scanner scanner;

    public BattleManager(List<Droid> droids, List<BattleArena> arenas, Scanner scanner) {
        this.droids = droids;
        this.arenas = arenas;
        this.scanner = scanner;
    }

    public void oneOnOneBattle() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        System.out.println("Оберіть дроїда для бою:");
        for (int i = 0; i < droids.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, droids.get(i).getName());
        }
        int droid1Index = scanner.nextInt() - 1;
        int droid2Index = scanner.nextInt() - 1;

        if (droid1Index >= 0 && droid1Index < droids.size() && droid2Index >= 0 && droid2Index < droids.size()) {
            Droid droid1 = droids.get(droid1Index);
            Droid droid2 = droids.get(droid2Index);

            System.out.println("Оберіть арену для бою:");
            for (int i = 0; i < arenas.size(); i++) {
                System.out.printf("%d. %s \n", i + 1, arenas.get(i).getName());
            }
            int arenaIndex = scanner.nextInt() - 1;
            if (arenaIndex >= 0 && arenaIndex < arenas.size()) {
                BattleArena selectedArena = arenas.get(arenaIndex);
                List<Droid> teamA = new ArrayList<>();
                teamA.add(droid1);
                List<Droid> teamB = new ArrayList<>();
                teamB.add(droid2);

                Battle battle = new Battle(teamA, teamB, selectedArena);
                battle.start();
            }
        } else {
            System.out.println("Невірний вибір дроїда.");
        }
    }

    public void teamBattle() {
        if (droids.size() < 4) {
            System.out.println("Недостатньо дроїдів для командного бою.");
            return;
        }

        List<Droid> teamA = chooseTeam("A", 2);
        List<Droid> teamB = chooseTeam("B", 2);

        System.out.println("Оберіть арену для бою:");
        for (int i = 0; i < arenas.size(); i++) {
            System.out.printf("%d. %s (Модифікатор: %.2f)%n", i + 1, arenas.get(i).getName());
        }
        int arenaIndex = scanner.nextInt() - 1;
        if (arenaIndex >= 0 && arenaIndex < arenas.size()) {
            BattleArena selectedArena = arenas.get(arenaIndex);

            Battle battle = new Battle(teamA, teamB, selectedArena);
            battle.start();
        }
    }

    private List<Droid> chooseTeam(String teamName, int size) {
        List<Droid> excludedDroids=new ArrayList<>();
        List<Droid> team = new ArrayList<>();
        while (team.size() < size) {
            System.out.printf("Оберіть дроїдів для команди %s:%n", teamName);
            for (int i = 0; i < droids.size(); i++) {
                if (!excludedDroids.contains(droids.get(i))) {
                    System.out.printf("%d. %s%n", i + 1, droids.get(i).getName());
                }
            }
            int choice = scanner.nextInt() - 1;
            if (choice >= 0 && choice < droids.size() && !team.contains(droids.get(choice))) {
                team.add(droids.get(choice));
            } else {
                System.out.println("Невірний вибір або дроїд вже у команді.");
            }
        }
        return team;
    }
}
