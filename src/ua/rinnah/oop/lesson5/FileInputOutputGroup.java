/*package ua.rinnah.oop.lesson5;

import ua.rinnah.oop.lesson3_4.Group;
import ua.rinnah.oop.lesson3_4.Student;

import java.io.*;

public class FileInputOutputGroup {

    public static void write(Group group, File file) throws IOException{
        try (FileWriter fw = new FileWriter(file)) {
            StringBuilder str = new StringBuilder("Firstname;Lastname;Age;Gender;University;Faculty;Spesialty;Averege Score\r\n");
            fw.write(str.toString());
            for (Student student : group.getStudents()) {
                if (student != null) {
                    str = new StringBuilder();
                    str.append(student.getFirstname()).append(";")
                            .append(student.getLastname()).append(";")
                            .append(student.getAge()).append(";")
                            .append(student.getGender()).append(";")
                            .append(student.getUniversity()).append(";")
                            .append(student.getFaculty()).append(";")
                            .append(student.getSpecialty()).append(";")
                            .append(student.getAveregeScore()).append("\r\n");
                    fw.write(str.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static Group read(File file) throws IOException{
        int n = 0;
        Student[] arr = null;
        Student[] newArr = null;
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            arr = new Student[10];
            String[] arrString = null;
            String str;
            br.readLine();
            do{
                str = br.readLine();
                if (str != null) {
                    arrString = str.split(";");
                    arr[n] = new Student(arrString[0], arrString[1], Integer.parseInt(arrString[2]), arrString[3], arrString[4], arrString[5], arrString[6], Double.parseDouble(arrString[7]));
                }
                n++;
            }while (str != null);
            if (--n < 10) {
                newArr = new Student[10];
                System.arraycopy(arr, 0 , newArr, 0, n);
                return new Group(newArr);
            }
        }catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return new Group(arr);
    }

}*/
