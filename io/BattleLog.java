package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BattleLog implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<String> logEntries;

    public BattleLog() {
        this.logEntries = new ArrayList<>();
    }

    public void addEntry(String entry) {
        logEntries.add(entry);
    }


    public void saveLog(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(logEntries);
            System.out.println("Журнал бою збережено успішно.");
        } catch (IOException e) {
            System.out.println("Помилка при збереженні журналу бою: " + e.getMessage());
        }
    }
    public void loadLog(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            logEntries = (List<String>) in.readObject();
            System.out.println("Журнал бою завантажено успішно.");
        } catch (IOException e) {
            System.out.println("Помилка при завантаженні журналу бою: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Клас не знайдено: " + e.getMessage());
        }
    }
    public void displayLog() {
        System.out.println("📜 Журнал бою:");
        for (String entry : logEntries) {
            System.out.println(entry);
        }
    }

}
