package ua.rinnah.oop.lesson1.cat;

public class Cat{

    private String name;
    private double weight;
    private int age;
    private String color;

    public Cat(String name, double weight, int age, String color) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = color;
    }

    public Cat() {
    }

    public void toileting(double waste){
        System.out.println("The cat goes to the toilet...");
        this.weight -= waste;
    }

    public void eating(double meal){
        System.out.println("The cat is eating...");
        this.weight += meal;
    }

    public void play(){
        System.out.println("The cat is playing with a ball...");
    }

    public void voice(){
        System.out.println("MEOW!!!");
        System.out.println("MEOW!!!");
        System.out.println("MEOW!!!");
    }

    @Override
    public String toString(){
        return String.format("Cat{Name: \"%s\", Weight: %.2f Age: %d, Color: \"%s\"}",
                                name, weight, age, color);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}