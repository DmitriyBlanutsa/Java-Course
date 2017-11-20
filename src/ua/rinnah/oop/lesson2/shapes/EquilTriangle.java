package ua.rinnah.oop.lesson2.shapes;

public class EquilTriangle extends Shape{

    private Point center;
    private double perimetr;
    private Circle inCircle;
    private Circle desCircle;
    private double area;
    private double side;

    public EquilTriangle(Point center, double side) {
        this.center = center;
        this.side = side;
    }

    public EquilTriangle(double x, double y, double side) {
        this.center = new Point(x, y);
        this.side = side;
    }

    public EquilTriangle() {
    }

    @Override
    public double getPerimetr() {
        perimetr = 3*side;
        return perimetr;
    }

    @Override
    public double getArea() {
        area = side*side*Math.sqrt(3)/4;
        return area;
    }

    @Override
    public String toString() {
        return String.format("EquilTriangle{side: %.2f, perimetr: %.2f, area: %.2f}", side, perimetr, area);
    }

    public Circle getInCircle() {
        inCircle = new Circle(center, side*Math.sqrt(3)/6);
        return inCircle;
    }

    public Circle getDesCircle() {
        desCircle = new Circle(center, side*Math.sqrt(3)/3);
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
