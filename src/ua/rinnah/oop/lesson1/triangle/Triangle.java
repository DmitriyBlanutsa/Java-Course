package ua.rinnah.oop.lesson1.triangle;

public class Triangle {

    private double firstSide;
    private double secondSide;
    private double thirdSide;
    private double area;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        setTriangle(firstSide, secondSide, thirdSide);
    }

    final void setTriangle(double firstSide, double secondSide, double thirdSide){
        if(isTriangle(firstSide, secondSide, thirdSide)) {
            this.firstSide = firstSide;
            this.secondSide = secondSide;
            this.thirdSide = thirdSide;
            calcArea();
        }else
            System.out.println("Triangle does not exist!!!");
    }

    public Triangle() {
    }

    final private boolean isTriangle(double firstSide, double secondSide, double thirdSide){
        if (firstSide < secondSide+thirdSide && secondSide < firstSide+thirdSide && thirdSide < firstSide+secondSide)
            return true;
        else
            return false;
    }


    private void calcArea(){
        double halfPer = (firstSide + secondSide + thirdSide)/2;
        area = Math.sqrt(halfPer*(halfPer-firstSide)*(halfPer-secondSide)*(halfPer-thirdSide));
    }

    @Override
    public String toString(){
        return String.format("Triangle{First side: %.2f, Second side: %.2f, Third side: %.2f, Area: %.2f}",
                firstSide, secondSide, thirdSide, area);
    }

    public double getFirstSide() {
        return firstSide;
    }

    public void setFirstSide(double firstSide) {
        this.firstSide = firstSide;
    }

    public double getSecondSide() {
        return secondSide;
    }

    public void setSecondSide(double secondSide) {
        this.secondSide = secondSide;
    }

    public double getThirdSide() {
        return thirdSide;
    }

    public void setThirdSide(double thirdSide) {
        this.thirdSide = thirdSide;
    }

    public double getArea() {
        return area;
    }

}
