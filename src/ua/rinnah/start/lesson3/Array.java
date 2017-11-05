package ua.rinnah.start.lesson3;

import java.util.Arrays;
import java.util.Scanner;

public class Array{

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    /**
     * Задать массив целых чисел длинной 5 эл.
     * Отсортировать числа в массиве
     * Вывести на экран результат.
     * Сделать возможность наполнения массива с клавиатуры*.
     */

    private static void task1(){
        final int size = 5; // size of array
        int[] arr = new int[size]; //array
        System.out.println(String.format("Enter %d elements of the array: ", size));
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        Arrays.sort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    /**
     * Задать массив целых чисел длинной N эл.
     * Поменять 1-й и последний элемент местами.
     * Вывести массив на экран.
     */
    private static void task2(){
        System.out.print("Enter size of array: ");
        final int size = scanner.nextInt(); // size of array
        int[] arr = new int[size]; //array
        System.out.print(String.format("Enter %d elements of the array: ", size));
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int temp;
        temp = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[arr.length - 1] = arr[0];
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Ввести с клавиатуры массив из 10 чисел.
     * Разбить его на 2 массива равной длинны.
     * Отсортировать каждую из половинок и вывести их содержимое на экран.
     */
    private static void task3(){
        final int size = 10; //size of array
        int[] arr = new int[size]; // array
        System.out.print(String.format("Enter %d elements of the array: ", size));
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int sizeFirstHalf = (int) size/2;
        int sizeSecondHalf = size - sizeFirstHalf;
        int[] firstHalf = new int[sizeFirstHalf];
        System.arraycopy(arr, 0, firstHalf, 0, sizeFirstHalf);
        int[] secondHalf = new int[sizeSecondHalf];
        System.arraycopy(arr, sizeFirstHalf, secondHalf,0, size - sizeFirstHalf);
        Arrays.sort(firstHalf);
        Arrays.sort(secondHalf);
        System.out.println("First half of array: " + Arrays.toString(firstHalf));
        System.out.println("Second half of array: " + Arrays.toString(secondHalf));
    }

    /**
     * Опредилить среднее арифметическое елеметов массива
     */
    private static  void task4(){
        final int size;
        System.out.print("Enter size of array: ");
        size = scanner.nextInt(); //size of array
        int[] arr = new int[size];
        System.out.print(String.format("Enter %d elemetls of array: ", size));
        double average = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
            average += arr[i];
        }
        System.out.println("Average of array is " + average/size);
    }

    /**
     * Написать код для зеркального переворота массива (1,2,3,4) -> (4,3,2,1).
     * Написать программу, которая позволит задать длину массива с клавиатуры, наполнить его
     * элементами, а затем выводить нужный элемент по его индексу на консоль.
     */
    private static void task5(){
        final int size;
        System.out.print("Enter size of array: ");
        size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.print(String.format("Enter %d elements of the array: ", size));
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        System.out.println("Inverted array:" + Arrays.toString(arr));
        boolean flag;
        int number;
        String str;
        System.out.println("Element-wise output of elements.");
        do{
            System.out.print("Enter number of elemetn: ");
            System.out.println(arr[scanner.nextInt()]);
            System.out.println("Continue? +/-");
            str = scanner.next();
            if (str.equals("+"))
                flag = true;
            else
                flag = false;
        }while(flag);
    }

}
