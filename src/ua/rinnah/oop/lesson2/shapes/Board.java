package ua.rinnah.oop.lesson2.shapes;

public class Board {

    final private int SIZE = 4;
    private int countShapes;
    private Shape[] shapes = new Shape[SIZE];
    private double sumArea;

    public Board(){
    }

    public boolean add(Shape shape){
        if (countShapes != SIZE) {
            int n = 0;
            while (shapes[n] != null)
                n++;
            shapes[n] = shape;
            countShapes++;
            return true;
        }
        System.out.println("The board is full");
        return false;
    }

    public void remove(int nomer){
        if (nomer < SIZE && nomer >= 0) {
            shapes[nomer] = null;
            countShapes--;
        }
    }

    public void removeAll(){
        for (int i = 0; i < SIZE; i++)
            shapes[i] = null;
        countShapes = 0;
    }

    public double getSumArea(){
        sumArea = 0;
        for (int i = 0; i < SIZE; i++)
            if (shapes[i] != null)
                sumArea += shapes[i].getArea();
        return sumArea;
    }

    @Override
    public String toString() {
        StringBuilder board = new StringBuilder("Board{\r\n");
        for (int i = 0; i < SIZE; i++) {
            if (shapes[i] != null)
                board.append(shapes[i].toString()).append("\r\n");
        }
        board.append("sumArea: " + sumArea).append("\r\n}");
        return board.toString();
    }

    public int getSIZE() {
        return SIZE;
    }

    public int getCountShapes() {
        return countShapes;
    }

    public Shape[] getShapes() {
        return shapes;
    }

}
