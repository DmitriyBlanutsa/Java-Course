package ua.rinnah.oop.lesson2.shapes;

public class Square extends Shape{

    private Point center;
    private double perimetr;
    private Circle inCircle;
    private Circle desCircle;
    private double area;
    private double side;

    public Square(Point center, double side) {
        this.center = center;
        this.side = side;
    }

    public Square(double x, double y, double side) {
        this.center = new Point(x, y);
        this.side = side;
    }

    public Square() {
    }

    @Override
    public double getPerimetr() {
        perimetr = 4*side;
        return perimetr;
    }

    @Override
    public double getArea() {
        area = side*side;
        return area;
    }

    @Override
    public String toString() {
        return String.format("Square{side: %.2f, perimetr: %.2f, area: %.2f}", side, perimetr, area);
    }

    public Circle getInCircle() {
        inCircle = new Circle(center, side/2);
        return inCircle;
    }

    public Circle getDesCircle() {
        desCircle = new Circle(center, Math.sqrt(2)*side/2);
        return desCircle;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
}
