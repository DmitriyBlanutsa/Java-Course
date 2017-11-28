package ua.rinnah.oop.lesson4;

import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Baby baby = new Baby("Dima", 2);
        Cat cat = new Cat("Peter", 3, "white");
        baby.playWith(cat);
        Ball ball = new Ball("red");
        baby.playWith(  ball);
    }

}
