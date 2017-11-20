package ua.rinnah.oop.lesson1.triangle;

import ua.rinnah.oop.lesson1.triangle.Triangle;

public class TriangleMain {

    public static void main(String[] args) {
        //rectangular
        Triangle triangle1 = new Triangle(4, 3, 5);
        System.out.println(triangle1);

        System.out.println();
        //nonexistent
        Triangle triangle2 = new Triangle(7, 3, 2);
        System.out.println(triangle2);

        System.out.println();
        //equilateral
        Triangle triangle3 = new Triangle(6, 6, 6);
        System.out.println(triangle3);

        System.out.println();
        //tentacular
        Triangle triangle4 = new Triangle(24, 12, 15);
        System.out.println(triangle4);

    }

}
