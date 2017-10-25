package ua.rinnah.start.lesson2;

/**
 *  Прочитать строку 1
 *  Прочитать строку 2
 *  Прочитать строку 3
 *  Вывести на экран
 *  S1 + S3
 *  S3 + S2 + S1
 *  S1 + S2 + S3
 */

import java.util.Scanner;

public class StringScanner {

            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter string №1: ");
                String s1 = scanner.nextLine();
                System.out.print("Enter string №2: ");
                String s2 = scanner.nextLine();
                System.out.print("Enter string №3: ");
                String s3 = scanner.nextLine();
                System.out.print("S1 + S3: ");
                System.out.println(s1 + s3);
                System.out.print("S3 + S2 + S1: ");
                System.out.println(s2 + s3 + s1);
                System.out.print("S1 + S2 + S3");
                System.out.println(s1 + s2 + s3);
            }

}
