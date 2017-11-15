package ua.rinnah.start.lesson7;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    //лекция тестирования
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*System.out.println("=== Task1 ===");
        System.out.print("Enter 3 words: ");
        String sentence = scanner.nextLine();
        System.out.println(swap(sentence));
        System.out.println("=== Task2 ===");
        System.out.print("Enter a text: ");
        String text = scanner.nextLine();
        System.out.print("Enter a word: ");
        String word = scanner.next();
        System.out.printf("This word is found in the sentence %d times.",wordCount(text, word, 0, 0));
        System.out.println("=== Task3 ===");
        System.out.println(sum1(new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(sum2(new int[]{1, 2, 3}, new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println("=== Task4 ===");
        System.out.println(redacted("I am    very       Issdfs                           sdfsdf T T T sdfsdf. Yes        asdg"));*/
    }


    /**
     *  Дано текст из 3-х слов “word1 word2 word3”. Поменять 1-е
     * и 3-е слова местами и вывести на экран результат.
     */
    private static String swap(String str){
        String[] words =  str.split(" ");
        StringBuilder res = new StringBuilder(words[2]);
        res.append(" ").append(words[1]).append(" ").append(words[0]);
        return  res.toString();
    }

    /**
     *  Дано текст и определенное слово. Посчитать сколько раз
     * заданное слово встречается в тексте.
     */
    private static int wordCount(String text, String word, int pos, int count){
        pos = text.indexOf(word, pos);
        if (pos == -1)
            return count;
        count++;
        pos += word.length();
        return wordCount(text, word, pos, count);
    }

    /**
     * Дано 3 массива чисел. С помощью 1-2-х циклов найти
     сумму элементов во всех массивах.
     */
    private static int sum1(int[] arr1, int[] arr2, int[] arr3){
        int time = (int) System.currentTimeMillis();
        int res = 0;
        for (int i = 0,j = 0, k = 0; i < arr1.length || j < arr2.length || k < arr3.length; i++, j++, k++) {
            if (i < arr1.length)
                res += arr1[i];
            if (j < arr2.length)
                res += arr2[j];
            if (k < arr3.length)
                res += arr3[k];
        }
        System.out.println(System.currentTimeMillis() - time);
        return res;
    }

    private static int sum2(int[] arr1, int[] arr2, int[] arr3){
        int time = (int) System.currentTimeMillis();
        int res = 0;
        int[][] all = {arr1, arr2, arr3};
        for (int i = 0; i < all.length; i++)
            for (int j = 0; j < all[i].length; j++)
                res += all[i][j];
        System.out.println(System.currentTimeMillis() - time);
        return res;
    }

    /**
     *  Дано текст. Убрать лишние пробелы, расставить знаки
     * препинания. Пример: «Я     длинное предложение Я
     * второе     предложение.» -> «Я длинное предложение. Я
     * второе предложение.
     */
    private static String redacted(String text){
        String[] words = text.split(" ");
        StringBuilder res = new StringBuilder(words[0]);
        for (int i = 1; i < words.length; i++)
            if (!words[i].equals("")) {
                if (Character.isUpperCase(words[i].charAt(0)) && !words[i - 1].endsWith("."))
                    res.append(". ");
                else
                    res.append(' ');
                res.append(words[i]);
            }

        res.replace(res.length() - 1, res.length(), ".");
        return res.toString();
    }

}