package ua.rinnah.start.lesson6;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Other {

     private static Scanner scanner;

     public static void main(String[] args) {
          System.out.println(" ================= Task1 ==================== ");
          System.out.print("Enter date in formatt dd.MM.yyyy:");
          scanner = new Scanner(System.in);
          String str = scanner.nextLine();
          isNow(str);
          System.out.println(" ================= Task2 =================== ");
          System.out.println(equals(new short[]{5, 5}, new short[]{5, 5}));
          System.out.println(equals(new short[]{5, 5}, new short[]{5, 5, 5}));
          System.out.println(equals(new short[]{5, 5}, new short[]{5, 4}));
          System.out.println(" ================= Task3 =================== ");
          System.out.println(toString(new int[]{5, 7, 79, 189}));
          System.out.println(" ================= Task4 =================== ");
          System.out.println(getInt("10"));
          System.out.println(" ================= Task4 =================== ");
          System.out.println(getAmount(11));
     }

     /**
      * Ввести с консоли дату. Сравнить ее с текущей датой в
      * системе. Вывести отличающиеся части (год, месяц) на
      * экран.
      */
     private static void isNow(String str) {
          DateTimeFormatter format = DateTimeFormatter.ofPattern("dd.MM.yyyy");
          LocalDate localDate = LocalDate.now();
          LocalDate date;
          try {
               date = LocalDate.parse(str, format);
          } catch (DateTimeException e) {
               System.out.println("Wrong formatt of date!!!");
               return;
          }
          StringBuilder deff = new StringBuilder("The defference between your and system date is ");
          int day = Math.abs(localDate.getDayOfMonth() - date.getDayOfMonth());
          int month = Math.abs(localDate.getMonthValue() - date.getMonthValue());
          int year = Math.abs(localDate.getYear() - date.getYear());
          StringBuilder res = new StringBuilder();
          if (day != 0)
               res.append(day + " days ");
          if (month != 0)
               res.append(month + " mounth ");
          if (year != 0)
               res.append(year + " years ");
          if (res.length() != 0)
               System.out.println(deff.append(res));
          else
               System.out.println("Dates are identical.");
     }

     /**
      * Написать свой вариант ф-и Arrays.equals для short[]
      */
     private static boolean equals(short[] arr1, short[] arr2) {
          if (arr1.length != arr2.length)
               return false;

          for (int i = 0; i < arr1.length; i++)
               if (arr1[i] != arr2[i])
                    return false;

          return true;
     }

     /**
      * Написать свой вариант ф-и Arrays.toString() для int[].
      */
     private static String toString(int[] arr) {
          StringBuilder str = new StringBuilder("[");
          for (int i = 0; i < arr.length; i++)
               if (i != arr.length - 1)
                    str.append(arr[i]).append(", ");
               else
                    str.append(arr[i]);

          return str.append("]").toString();
     }

     /**
      * Ввести с консоли число в бинарном формате. Перевести
      * его в int и вывести на экран (“10” -> 2).
      */
     private static int getInt(String str){
          int res = 0;
          for (int i = 0; i < str.length(); i++)
               if (str.charAt(i) == '1')
               res += Math.pow(2,str.length() - 1 - i);
          return res;
     }

     /**
      * Ввести с консоли целое число. Посчитать количество
      * единиц в его бинарном представлении (“1011” –> 3).
      */
     private static int getAmount(int n){
          int amount = 0;
          while(n != 0) {
               if (n % 2 != 0)
                    amount++;
               n /= 2;
          }
          return amount;
     }

}