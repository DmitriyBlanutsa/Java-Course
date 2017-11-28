package ua.rinnah.oop.lesson3_4;

import java.util.Arrays;
import java.util.Scanner;

public class Group implements MilitaryRegistration{

    final private int SIZE = 10;
    private Student[] students = new Student[SIZE];

    public void Group(){
    }

    public void add(Student student){
        for (int i = 0; i < SIZE; i++){
            if (students[i] == null) {
                students[i] = student;
                return;
            }
        }
        try{
            throw new SizeGroupExeption();
        }catch (SizeGroupExeption e){
            System.err.print(e.getMessage());
        }
    }


    public void interactiveAdd(){
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < SIZE; i++){
            if (students[i] == null) {
                System.out.print("Enter firstname: ");
                String firstname = sc.next();

                System.out.print("Enter lastname: ");
                String lastname = sc.next();

                int age = 0;
                System.out.print("Enter age: ");
                if (sc.hasNextInt()){
                    age = sc.nextInt();
                } else
                    System.out.println("You did not enter an integer!!!");

                String str;
                while(true) {
                    System.out.print("Enter gender(m\\w): ");
                    str = sc.next();
                    if (str.equals("m") || str.equals("w"))
                        break;
                }
                Gender gender;
                if (str.equals("m"))
                    gender = Gender.MAN;
                else
                    gender = Gender.WOMAN;

                System.out.print("Enter university: ");
                String university = sc.next();

                System.out.print("Enter faculty: ");
                String faculty = sc.next();

                System.out.print("Enter specialty: ");
                String specialty = sc.next();

                double averegeScore = 0;
                System.out.print("Enter age: ");
                if (sc.hasNextDouble()){
                    averegeScore = sc.nextDouble();
                } else
                    System.out.println("You did not enter an double!!!");
                students[i] = new Student(firstname, lastname, age, gender, university, faculty, specialty, averegeScore);
                return;
            }
        }
        try{
            throw new SizeGroupExeption();
        }catch (SizeGroupExeption e){
            System.err.print(e.getMessage());
        }
    }

    public void delete(int number){
        try{
            if (number < 0 || number > SIZE - 1) {
                throw new IllegalArgumentException("invalid number");
            } else{
                students[number] = null;
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void deleteAll(){
        for (int i = 0; i < SIZE; i++)
            if (students[i] != null) {
                students[i] = null;
            }
    }

    public Student search(String lastname){
        try{
            if (lastname == null) {
                throw new IllegalArgumentException("lastname is empty");
            }else{
                for (int i = 0; i < SIZE; i++)
                        if (students[i] != null && students[i].getLastname() != null && students[i].getLastname().equals(lastname)) {
                            return students[i];
                        }
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }

    public void sort(ParametrSort parametr){
        Arrays.sort(students, (a, b) -> {
            if (isNull(a, b) != 100)
                return isNull(a, b);
            else {
                switch (parametr) {
                    case LASTNAME:
                        if (a.getLastname() == null && b.getLastname() == null)
                            return 0;
                        else if (a.getLastname() == null)
                            return 1;
                        else if (b.getLastname() == null)
                            return -1;
                        else
                            return a.getLastname().compareTo(b.getLastname());
                    case FIRSTNAME:
                        if (a.getFirstname() == null && b.getFirstname() == null)
                            return 0;
                        else if (a.getFirstname() == null)
                            return 1;
                        else if (b.getFirstname() == null)
                            return -1;
                        else
                            return a.getFirstname().compareTo(b.getFirstname());
                    case AGE:
                            return a.getAge() - b.getAge();
                    case GENDER:
                        if (a.getGender() == null && b.getGender() == null)
                            return 0;
                        else if (a.getGender() == null)
                            return 1;
                        else if (b.getGender() == null)
                            return -1;
                        else if (a.getGender().isSex() == b.getGender().isSex())
                            return 0;
                        else if (a.getGender().isSex())
                            return -1;
                        else
                            return 1;
                    case UNIVERSITY:
                        if (a.getUniversity() == null && b.getUniversity() == null)
                            return 0;
                        else if (a.getUniversity() == null)
                            return 1;
                        else if (b.getUniversity() == null)
                            return -1;
                        else
                            return a.getUniversity().compareTo(b.getUniversity());
                    case FACULTY:
                        if (a.getFaculty() == null && b.getFaculty() == null)
                            return 0;
                        else if (a.getFaculty() == null)
                            return 1;
                        else if (b.getFaculty() == null)
                            return -1;
                        else
                            return a.getFaculty().compareTo(b.getFaculty());
                    case SPECIALZTY:
                        if (a.getSpecialty() == null && b.getSpecialty() == null)
                            return 0;
                        else if (a.getSpecialty() == null)
                            return 1;
                        else if (b.getSpecialty() == null)
                            return -1;
                        else
                            return a.getSpecialty().compareTo(b.getSpecialty());
                    case AVEREGE_SCORE:
                        if (a.getAveregeScore() == b.getAveregeScore())
                            return 0;
                        else if (a.getAveregeScore() < b.getAveregeScore())
                            return -1;
                        return 1;
                    default:
                        return 0;
                }
            }
        });
    }

    private int isNull(Student a, Student b){
        if (a == null && b == null)
            return 0;
        else if (a == null)
            return 1;
        else if (b == null)
            return -1;
        return 100;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Group{\r\n\r\n");
        for (int i = 0; i < SIZE; i++)
            if (students[i] != null)
                str.append(students[i].toString()).append("\r\n\r\n");
        return str.append("}\r\n").toString();
    }

    @Override
    public Student[] registrarion() {
        Student[] military = new Student[SIZE];
        int n =  0;
        for (Student student : students){
            if (student != null && student.getAge() >= 18) {
                military[n] = student;
                n++;
            }
        }
        if (n != SIZE) {
            Student[] newMilitary = new Student[n];
            System.arraycopy(military, 0, newMilitary, 0, n);
            return newMilitary;
        }
        return military;
    }
}



