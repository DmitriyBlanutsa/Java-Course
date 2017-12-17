package ua.rinnah.oop.lesson3_4;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Group implements MilitaryRegistration{

    private List<Student> students;

    public Group(List<Student> students) {
        this.students = students;
    }

    public Group(){
        students = new ArrayList<>();
    }

    public void add(Student student){
        try {
            if (student == null) {
                throw new IllegalArgumentException("Student is NULL!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void delete(int number){
        try{
            if (number < 0 || number > students.size() - 1) {
                throw new IllegalArgumentException("invalid number");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        students.remove(number);
    }

    public void deleteAll(){
        students.clear();
    }

    public Student search(String lastname) {
        try {
            if (lastname == null) {
                throw new IllegalArgumentException("lastname is empty");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null;
        }
        for (Student student : students)
            if (student.getLastname() != null && student.getLastname().equals(lastname)) {
                return student;
            }
        return null;
    }

    public void sort(ParametrSort parametr){
        students.sort((a, b) -> {
            if (isNull(a, b) != 100)
                return isNull(a, b);
            else {
                switch (parametr) {
                    case LASTNAME:
                        getSortValue(a, b, "lastname");
                    case FIRSTNAME:
                        getSortValue(a, b, "firstname");
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
                        getSortValue(a, b, "university");
                    case FACULTY:
                        getSortValue(a, b, "faculty");
                    case SPECIALTY:
                        getSortValue(a, b, "specialty");
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

    private int getSortValue(Student a, Student b, String str){
        try {
            Field field = Student.class.getDeclaredField(str);
            field.setAccessible(true);
            String value1 = (String) field.get(a);
            String value2 = (String) field.get(b);
            if (value1 == null && value2 == null)
                return 0;
            else if (value1 == null)
                return -1;
            else if (value2 == null)
                return 1;
            else
                return value1.compareTo(value2);
        }catch (IllegalAccessException e){
            e.printStackTrace();
            return 0;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return 0;
        }
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
        for (int i = 0; i < students.size(); i++)
            if (students.get(i) != null)
                str.append(students.get(i).toString()).append("\r\n\r\n");
        return str.append("}\r\n").toString();
    }

    @Override
    public List<Student> registrarion() {
        List<Student> milStudents = new ArrayList<>();
        for (Student student : students){
            if (student.getAge() >= 18) {
                milStudents.add(student);
            }
        }
        return milStudents;
    }

    public static void saveObject(Group group, File file){
        try(ObjectOutput os = new ObjectOutputStream(new FileOutputStream(file))){
            os.writeObject(group);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void saveObject(File file){
        try(ObjectOutput os = new ObjectOutputStream(new FileOutputStream(file))){
            os.writeObject(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Group loadObject(File file) {
        try (ObjectInput oi = new ObjectInputStream(new FileInputStream(file))) {
            return (Group) oi.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}



