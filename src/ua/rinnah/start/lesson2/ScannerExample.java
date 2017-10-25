package ua.rinnah.start.lesson2;

/**
 *  Прочитать с консоли число 1
 *  Прочитать с консоли число 2
 *  Вывести результат
 *  И так для каждого оператора
 */

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = scanner.nextInt();
        System.out.print("Enter b: ");
        int b = scanner.nextInt();
        System.out.print("a + b:");
        System.out.println(a + b);
        System.out.print("a - b:");
        System.out.println(a - b);
        System.out.print("a * b:");
        System.out.println(a * b);
        System.out.print("a / b:");
        System.out.println(a / b);
    }

}
