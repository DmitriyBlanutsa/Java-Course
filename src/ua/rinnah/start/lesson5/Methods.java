package ua.rinnah.start.lesson5;

import ua.rinnah.start.lesson3.Array;

import java.util.Arrays;
import java.util.Random;

public class Methods {

    private  static  int x = 1;

    public static void main(String[] args) {
        append("prog", 5, 6.7);
    }

    private static String append(String x, int y, double z) {
        String s = x + y + z;
        System.out.println(s);
        return s;
    }


}
