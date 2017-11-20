package ua.rinnah.oop.lesson1.cat;

public class CatMain {

    public static void main(String[] args) {

        Cat myCat = new Cat("Abbie", 4, 2, "white");
        myCat.eating(0.5);
        myCat.toileting(0.3);
        myCat.play();
        myCat.voice();
        System.out.println(myCat);

        System.out.println();

        Cat alienCat = new Cat("Bob", 9, 5, "black");
        alienCat.play();
        alienCat.voice();
        System.out.println(alienCat);

    }
}
