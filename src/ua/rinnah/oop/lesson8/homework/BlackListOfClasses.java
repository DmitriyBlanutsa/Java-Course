package ua.rinnah.oop.lesson8.homework;

import java.util.Arrays;

public class BlackListOfClasses {

    private int beginSize = 10;
    private Class[] list;
    private int count;

    public BlackListOfClasses() {
        list = new Class[beginSize];
    }

    public BlackListOfClasses(int beginSize) {
        this.beginSize = beginSize;
        list = new Class[beginSize];
    }

    public BlackListOfClasses(Class[] list) {
        checkList(list);
    }

    private final void checkList(Class[] list){
        try {
            if (list == null) {
                throw new IllegalArgumentException("List is empty!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        this.list = list;
        count = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                count++;
            }
        }
    }

    public boolean isInList(Class class_){
        try {
            if (list == null || class_ == null) {
                throw new IllegalArgumentException("Argument exception!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return false;
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null && list[i].equals(class_)) {
                return true;
            }
        }
        return false;
    }

    public void add(Class class_){
        try {
            if (class_ == null) {
                throw new IllegalArgumentException("Class is empty!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        if (count == list.length) {
            Class[] newList = new Class[count * 2];
            System.arraycopy(list, 0, newList, 0, count);
            list = newList;
            list[count] = class_;
        } else {
            for (int i = 0; i < list.length; i++) {
                if (list[i] == null) {
                    list[i] = class_;
                }
            }
        }
        count++;
    }

    public void delete(Class class_){
        try {
            if (class_ == null) {
                throw new IllegalArgumentException("Class is empty!!!");
            }
            if (isInList(class_)){
                for (int i = 0; i < list.length; i++) {
                    if (list[i] != null && list[i].equals(class_)) {
                        list[i] = null;
                        count--;
                    }
                }
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    public Class[] getList() {
        return list;
    }

    public void setList(Class[] list) {
        checkList(list);
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "BlackListOfClasses{" +
                "list=" + Arrays.toString(list) +
                ", count=" + count +
                '}';
    }
}
