package ua.rinnah.oop.lesson7;

public class Main {

    public static void main(String[] args) {
        Action action = new Action();
        PrintMessage ship1 = new PrintMessage(action, "1 ship", 0);
        PrintMessage ship2 = new PrintMessage(action, "2 ship", 1);
        PrintMessage ship3 = new PrintMessage(action, "3 ship", 2);
        Thread th1 = new Thread(ship1);
        Thread th2 = new Thread(ship2);
        Thread th3 = new Thread(ship3);
        th1.start();
        th2.start();
        th3.start();

    }

}
