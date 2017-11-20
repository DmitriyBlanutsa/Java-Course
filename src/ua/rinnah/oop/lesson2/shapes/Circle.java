package ua.rinnah.oop.lesson2.shapes;

public class Circle extends Shape{

    private double perimetr;
    private double area;
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Circle(double x,double y, double radius) {
        this.center = new Point(x, y);
        this.radius = radius;
    }

    public Circle() {
    }

    @Override
    public double getPerimetr() {
        perimetr = 2*Math.PI*radius;
        return perimetr;
    }

    @Override
    public double getArea() {
        area = Math.PI*radius*radius;
        return area;
    }

    @Override
    public String toString() {
        return String.format("Circle{x: %.2f, y: %.2f, radius: %.2f, area: %.2f, perimetr: %.2f}", center.getX(), center.getY(), radius, area, perimetr);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
