package ua.rinnah.oop.lesson5;

import ua.rinnah.oop.lesson3_4.Gender;
import ua.rinnah.oop.lesson3_4.Group;
import ua.rinnah.oop.lesson3_4.Person;
import ua.rinnah.oop.lesson3_4.Student;

import java.io.*;
import java.util.Arrays;

/**
 * 1. Напишите программу которая скопирует файлы (с заранее
 определенным  расширением  —  например  только  doc)  из
 каталога источника в каталог приемник.
 2. Напишите программу которая примет на вход 2 текстовых
 файла,  а  вернет  один.  Содержимым  этого  файла  должны
 быть слова которые есть и в первом и во втором файле.
 3.  Усовершенствуйте  класс  описывающий  группу  студентов
 добавив возможность сохранения группы в файл.
 4.  Реализовать  обратный  процесс  —  т.е.  считать  данные  о
 группе из файла и на их основе создать объект типа группа.
 */

public class Main {

    public static void main(String[] args) {
        //3-4
        Person person1 = new Person("Dmitriy", "A",  19, Gender.MAN);
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

        Group group = new Group(new Student[10]);
        group.add(student1);
        group.add(student2);
        group.add(student3);
        group.add(student4);
        group.add(student5);
        group.add(student6);
        group.add(student7);
        group.add(student8);
        group.add(student9);
        System.out.println(group);

        try {
            FileInputOutputGroup.write(group, new File("group.csv"));
            System.out.println(FileInputOutputGroup.read(new File("group.csv")));
        }catch (IOException e){
            e.printStackTrace();

        }
        //2
        File f1 = new File("D:\\Java Projects\\Intelij IDEA Projects\\prog.kiev.org\\text1.txt");
        File f2 = new File("D:\\Java Projects\\Intelij IDEA Projects\\prog.kiev.org\\text2.txt");
        File common = new File("D:\\Java Projects\\Intelij IDEA Projects\\prog.kiev.org\\text.txt");
        FileCopy.commonWords(f1, f2, common);
        //1
        String[] arr = {"exe", "jpg", "avi"};
        File source = new File("fout");
        File reseiver = new File("fin");
        FileCopy.fileFilterCopy(arr, source, reseiver);
    }


}
