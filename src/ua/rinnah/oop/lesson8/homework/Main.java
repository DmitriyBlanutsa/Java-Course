package ua.rinnah.oop.lesson8.homework;

/**
 * 2)    Создайте класс контейнер - стек (класс в который можно добавлять и
 удалять  объекты  других  классов,  только  в  вершину  стека)  в  который
 можно  сохранять  объекты  произвольного  типа.  Должен  быть  метод
 добавления элемента в стек,получение с удалением элемента из стека, и
 просто  получение  элемента  из  вершины  из  стека.    Должна  быть
 реализована  работа  с  «черным  списком»  классов  (смотри  ниже).  Если
 объект  который  добавляется  в  стек  принадлежит  классу  из  черного
 списка, то добавление такого объекта запрещено
 3)     Для описанного выше стека создайте класс «Черный список» в котором
 будут  описаны      классы  объектов  которые  нельзя  добавлять  в  стек.
 Должна быть возможность добавления классов в черный список, проверка
 объекта — на то что класс к которому он принадлежит принадлежит или
 не принадлежит к классам в черном списке.
 */

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
