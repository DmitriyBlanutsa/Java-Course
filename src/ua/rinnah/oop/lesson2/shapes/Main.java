package ua.rinnah.oop.lesson2.shapes;

public class Main {

    public static void main(String[] args) {
        //point create
        Point center = new Point(1, 2);
        System.out.println(center);

        System.out.println();

        //circle create
        Circle circle = new Circle(center, 2);
        circle.getArea();
        circle.getPerimetr();
        System.out.println(circle);

        System.out.println();

        //square create
        Square square = new Square(center, 5);
        square.getArea();
        square.getPerimetr();
        System.out.println(square);

        System.out.println();

        //triangle create
        EquilTriangle equilTriangle = new EquilTriangle(center, 6);
        equilTriangle.getArea();
        equilTriangle.getPerimetr();
        System.out.println(equilTriangle);

        System.out.println();

        //board create
        Board board = new Board();
        board.add(circle);
        board.add(square);
        board.add(equilTriangle);
        board.getSumArea();
        System.out.println(board);

        board.add(circle);
        //board is full
        board.add(circle);

        System.out.println();

        board.getSumArea();
        System.out.println(board);

        //board clear
        board.removeAll();
        board.getSumArea();
        System.out.println(board);

    }
}
