package ua.rinnah.oop.lesson3_4;

import java.util.Arrays;

public class Main {

    /**
     1. Усовершенствуйте класс Group добавив возможность
     интерактивного добавления объекта.
     2. Реализуйте возможность  сортировки списка студентов
     по фамилии.
     3. Реализуйте возможность сортировки по параметру
     (Фамилия, успеваемость и т. д.).
     4. Реализуйте интерфейс Военком которые вернет из группы
     массив студентов юношей которым больше 18 лет.
     5. Протестируйте ее работу.
     *
     */
    public static void main(String[] args) {

        Person person1 = new Person("Dmitriy", "A",  19, null);
        Person person2 = new Person("Katy", "F",  18, Gender.WOMAN);
        Person person3 = new Person("Dmitriy", "D",  19, Gender.MAN);
        Person person4 = new Person(null, "B",  19, Gender.MAN);
        Person person5 = new Person("Dmitriy", "E",  15, Gender.MAN);
        Person person6 = new Person("Dmitriy", "Q",  13, Gender.MAN);
        Person person7 = new Person("Max", "F",  19, Gender.MAN);
        Person person8 = new Person("Dmitriy", null,  15, Gender.MAN);
        Person person9 = new Person("Dmitriy", "H",  10, Gender.MAN);
        Person person10 = new Person("Dmitriy", "Y",  1, Gender.MAN);

        Student student1 = new Student(person1, "KPI", "FICT", "software engineering", 4.0);
        Student student2 = new Student(person2, "KPI", "FICT", "software engineering", 0.0);
        Student student3 = new Student(person3, "AAA", "FICT", "software engineering", 3.0);
        Student student4 = new Student(person4, "KPI", null, "software engineering", 4.0);
        Student student5 = new Student(person5, "KPI", "FICT", null, 1.0);
        Student student6 = new Student(person6, "KPI", "FICT", "software engineering", 4.0);
        Student student7 = new Student(person7, "KPI", "BBB", "software engineering", 4.0);
        Student student8 = new Student(person8, "KPI", "FICT", "AA", 4.0);
        Student student9 = new Student(person9, "KPI", "FICT", "software engineering", 4.0);
        Student student10 = new Student(person10, null, "FICT", "software engineering", 4.0);


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
       group.interactiveAdd();
        System.out.println(group);

        group.sort(ParametrSort.FIRSTNAME);
        System.out.println(group);

        group.sort(ParametrSort.LASTNAME);
        System.out.println(group);

        group.sort(ParametrSort.AGE);
        System.out.println(group);

        group.sort(ParametrSort.GENDER);
        System.out.println(group);

        group.sort(ParametrSort.UNIVERSITY);
        System.out.println(group);

        group.sort(ParametrSort.FACULTY);
        System.out.println(group);

        group.sort(ParametrSort.SPECIALZTY);
        System.out.println(group);

        group.sort(ParametrSort.AVEREGE_SCORE);
        System.out.println(group);

        System.out.println(Arrays.toString(group.registrarion()));
    }

}

