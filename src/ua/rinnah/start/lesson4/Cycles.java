package ua.rinnah.start.lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Cycles {

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
    //task1();
    //task2();
    //task3();
    //task4();
    //task6();
    //task7();
    //task9();
    //task10();
    }

    /**
     * Вывести на экран числа от 10 до 20 с помощью
     * всех известных циклов.
     */
    private static void task1(){
        System.out.println("===== FOR =====");
        for (int i = 10; i <= 20; i++)
            System.out.println(i);
        System.out.println("===== WHILE =====");
        int i = 9;
        while(i++ < 20)
            System.out.println(i);
        System.out.println("===== DO-WHILE =====");
        i = 10;
        do {
            System.out.println(i);
        }while(i++ < 20);
    }

    /**
     * Вывести на экран все числа от 1 до 100, которые
     * делятся на 3 без остатка.
     */
    private static void task2(){
        for (int i = 3; i < 100; i += 3)
                System.out.println(i);
    }

    /**
     * Заполнить массив числами от 100 до 0.
     */
    private static void task3(){
        int size = 101;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 100 - i;
            System.out.println(arr[i]);
        }
    }

    /**
     * Дано массив из 10 целых чисел. Вывести на экран
     * сумму всех его элементов кроме первого и
     * последнего.
     */
    private static void task4(){
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt() % 100;
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sum of array: " + sumOfArray(arr));
    }

    private static int sumOfArray(int[] arr){
        int sum = 0;
        for (int i = 1; i < arr.length - 1; i++)
            sum += arr[i];
        return sum;
    }

    /**
     * Найти в массиве чисел элементы с наибольшим и
     * наименьшим значениями.
     */
    private static void task6(){
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt() % 100;
        System.out.println("Array: " + Arrays.toString(arr));
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
            if (min > arr[i])
                min = arr[i];
        }
        System.out.println("Max element of array: " + max);
        System.out.println("Min element of array: " + min);
    }

    /**
     *  Найти в массиве число, которое повторяется
     * наибольшее количество раз. Не использовать
     * коллекции
     */
    private  static void task7(){
        int size = 10;
        int[] arr = new int[size];
        System.out.print("Enter array of 10 elements: ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();
        int count = reiteration(arr, arr[0]);
        int element = 0;
        int iter;
        for (int i = 1; i < arr.length; i++) {
            iter = reiteration(arr, arr[i]);
            if (iter > count) {
                count = iter;
                element = arr[i];
            }
        }
        System.out.println(String.format("The element %d is repeated %d times.", element, count));
    }

    private static int reiteration(int[] arr, int n){
        int count = 0;
        for (int element:arr){
            if (element == n)
                count++;
        }
        return count;
    }

    /**
     *  Написать метод для зеркального переворота
     * в массиве ([1, 2, 3, 4] -> [4, 3, 2, 1])
     */
    private static void task9(){
        int size = 10;
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = random.nextInt() % 100;
        System.out.println("Array: " + Arrays.toString(arr));
        reverse(arr);
        System.out.println("Inverted array: " + Arrays.toString(arr));
    }

    private static void reverse(int[] arr) {
        int temp;
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    /**
     *  Написать метод, который заполнит массив
     * произвольного размера числами по возрастанию,
     * начиная с центра массива, например,
     * [5,4,3,2,1,0,1,2,3,4,5]
     */
    private static void task10(){
        System.out.print("Enter size of array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        fillOfArray(arr);
        System.out.println("Array: " + Arrays.toString(arr));
    }

    private static void fillOfArray(int[] arr){
        int n = (int) Math.ceil(arr.length / 2.0) - 1;
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
            arr[arr.length - i - 1] = arr[i];
        }
    }

}
