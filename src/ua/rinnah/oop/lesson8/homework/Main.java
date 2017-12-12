package ua.rinnah.oop.lesson8.homework;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        //BlackListOfClasses test
        BlackListOfClasses list = new BlackListOfClasses(new Class[]{Integer.class, String.class});
        //System.out.println(list);

        list.add(Integer.class);
        //System.out.println(list);

        list.add(Double.class);
        //System.out.println(list);

        list.delete(Integer.class);
       // System.out.println(list);

        //System.out.println(list.isInList(Date.class));

       // System.out.println(list.isInList(String.class));

        //MyStack test
        MyStack stack = new MyStack(list);
        stack.push(new Double(7.8));
        System.out.println(stack);

        stack.push(new Byte((byte) 2));
        stack.push(new Integer(22));
        System.out.println(stack);

        stack.push(new Integer(5));
        System.out.println(stack);

        System.out.println(stack.pop());
        System.out.println(stack);

    }

}
