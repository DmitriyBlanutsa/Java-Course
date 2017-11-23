package ua.rinnah.oop.lesson3;

import java.util.Arrays;

public class Main {

    /**
     * 1)Создайте  класс  описывающий  человека  (создайте  метод
     выводящий информацию о человеке)
     2)На  его  основе  создайте  класс  студент  (переопределите
     метод вывода информации)
     3)Создайте  класс  группа  —  который  содержит  массив  из  10
     объектов  класса  студент.  Реализуйте  методы  добавления,
     удаления студента и метод  поиска студента по фамилии. В
     случае    попытки  добавления  11  студента  создайте
     собственное  исключение  и  обработайте  его.  Определите
     метод  toString()  для  группы  так,  что  бы  он  выводил  список
     студентов в алфавитном порядке.
     4) * Нарисуйте UML диаграмму проекта
     *
     */
    public static void main(String[] args) {

        Person person1 = new Person("Dmitriy", "A",  19, Gender.MAN);
        Person person2 = new Person("Dmitriy", "F",  19, Gender.MAN);
        Person person3 = new Person("Dmitriy", "D",  19, Gender.MAN);
        Person person4 = new Person("Dmitriy", "B",  19, Gender.MAN);
        Person person5 = new Person("Dmitriy", "E",  19, Gender.MAN);
        Person person6 = new Person("Dmitriy", "Q",  19, Gender.MAN);
        Person person7 = new Person("Max", "F",  19, Gender.MAN);
        Person person8 = new Person("Dmitriy", "G",  19, Gender.MAN);
        Person person9 = new Person("Dmitriy", "H",  19, Gender.MAN);
        Person person10 = new Person("Dmitriy", "Y",  19, Gender.MAN);

        Student student1 = new Student(person1, "KPI", "FICT", "software engineering", 4.0);
        Student student2 = new Student(person2, "KPI", "FICT", "software engineering", 4.0);
        Student student3 = new Student(person3, "KPI", "FICT", "software engineering", 4.0);
        Student student4 = new Student(person4, "KPI", "FICT", "software engineering", 4.0);
        Student student5 = new Student(person5, "KPI", "FICT", "software engineering", 4.0);
        Student student6 = new Student(person6, "KPI", "FICT", "software engineering", 4.0);
        Student student7 = new Student(person7, "KPI", "FICT", "software engineering", 4.0);
        Student student8 = new Student(person8, "KPI", "FICT", "software engineering", 4.0);
        Student student9 = new Student(person9, "KPI", "FICT", "software engineering", 4.0);
        Student student10 = new Student(person10, "KPI", "FICT", "software engineering", 4.0);


        Group group = new Group();
        group.add(student1);
        group.add(student2);
        group.add(student3);
        group.add(student4);
        group.add(student5);
        group.add(student6);
        group.add(student7);
        group.add(student8);
        group.add(student9);
        group.add(student10);
        System.out.println(group);

        group.delete(5);
        System.out.println(group);

        System.out.println(group.search("Blanutsa"));

        System.out.println(group.search("B"));

        group.deleteAll();
        System.out.println(group);
    }

}

