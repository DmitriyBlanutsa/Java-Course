package ua.rinnah.oop.lesson9;

import java.io.File;
import java.util.*;

/**
 * 1) Написать метод, который создаст список, положит в него 10
 элементов, затем удалит первые два и последний, а затем выведет
 результат на экран.
 2) Модифицируйте класс группа для более удобных методов работы
 с динамическими массивами.
 3)  Считайте  из  файла  текст  на  английском  языке,  вычислите
 относительную  частоту  повторения  каждой  буквы  и  выведите  на
 экран  результат  в  порядке  убывания  относительной  частоты
 повторения.
 4) Шелдон, Леонард, Воловиц, Кутрапалли и Пенни стоят в очереди
 за  «двойной  колой».  Как  только  человек  выпьет  такой  колы  он
 раздваивается и оба становятся в конец очереди, что бы выпить еще
 стаканчик.    Напишите  программу  которая  выведет  на  экран
 состояние  очереди    в  зависимости  от  того  сколько  стаканов  колы
 выдал аппарат с чудесным напитком. Например если было выдано
 только два стакана, то очередь выглядит как:
 [Volovitc, Kutrapalli, Penny,Sheldon,Sheldon,Leonard,Leonard]
 */

public class Main {

    public static void main(String[] args) {
        /*CharStatisticFromFile.getStatisticStreamAPI(new File("cat.txt"));
        System.out.println();
        CharStatisticFromFile.getStatisticSimple(new File("cat.txt"));*/

        System.out.println();

        task1();

        System.out.println();

        task2(2);
    }

    static void task1(){
        List<Integer> list = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++){
            list.add(i);
        }
        printCollection(list);
        list.remove(0);
        list.remove(0);
        list.remove(list.size() - 1);

        System.out.println();

        printCollection(list);
    }

    static void printCollection(Collection list){
        for (Object element : list){
            System.out.println(element);
        }
    }

    static void task2(int n){
        Deque<String> deque = new ArrayDeque<>(Arrays.asList("Sheldon", "Leonard", "Volovitc", "Kutrapalli", "Penny"));
        printCollection(deque);
        for (int i = 0; i < n; i++){
            String first = deque.pollFirst();
            deque.addLast(first);
            deque.addLast(first);
        }

        System.out.println();

        printCollection(deque);
    }

}
