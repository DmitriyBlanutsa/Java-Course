package ua.rinnah.oop.lesson3;

import java.util.Arrays;

public class Group {

    final private int SIZE = 10;
    private Student[] group = new Student[SIZE];

    public void Group(){

    }

    public void add(Student student){
        boolean flag = true;
        for (int i = 0; i < SIZE; i++){
            if (group[i] == null) {
                group[i] = student;
                flag = false;
                break;
            }
        }

        try{
            if (flag)
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
                group[number] = null;
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public void deleteAll(){
        for (int i = 0; i < SIZE; i++)
            if (group[i] != null) {
                group[i] = null;
            }
    }

    public Student search(String lastname){
        try{
            if (lastname == null) {
                throw new IllegalArgumentException("lastname is empty");
            }else{
                for (int i = 0; i < SIZE; i++)
                        if (group[i] != null && group[i].getLastname() != null && group[i].getLastname().equals(lastname)) {
                            return group[i];
                        }
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        Arrays.sort(group,(a, b)-> {
            if (a == null && b == null)
                return 0;
            else if (a == null)
                return 1;
            else if (b == null)
                return -1;
            else if (a.getLastname() == null && b.getLastname() == null)
                return 0;
            else if (a.getLastname() == null)
                return 1;
            else if (b.getLastname() == null)
                return -1;
            return a.getLastname().compareTo(b.getLastname());
        });
        StringBuilder str = new StringBuilder("Group{\r\n\r\n");
        for (int i = 0; i < SIZE; i++)
            if (group[i] != null)
                str.append(group[i].toString()).append("\r\n\r\n");
        return str.append("}\r\n").toString();
    }
}

