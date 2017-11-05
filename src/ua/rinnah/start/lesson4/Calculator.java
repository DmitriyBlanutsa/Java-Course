package ua.rinnah.start.lesson4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  С помощью консоли пользователь вводит
 * математическое выражение типа “1+33-4*7”. Написать
 * программу для подсчета его значения. Приоритет
 * операций не учитывается
 * kjk
 */
public class Calculator {

    private static String exp;
    private static Scanner scanner;
    private static Pattern p;
    private static Matcher m;

    public static void main(String[] args) {
        getExpression();
        calculate();
    }

    private static void getExpression() {
        scanner = new Scanner(System.in);
        System.out.print("Enter mathecatical expression: ");
        exp = scanner.nextLine();
    }

    private static double getDouble() {
        double res = 0;
        String regex = "[-]?((([0]|([1-9]\\d*))(\\.|[,])\\d+)|([1-9]\\d*))";
        p = Pattern.compile(regex);
        m = p.matcher(exp);
        if (m.find()) {
            res = Double.parseDouble(exp.substring(0, m.end()));
            exp = exp.substring(m.end(), exp.length());
        }
        return res;
    }

    private static boolean isError() {
        String regex = "^([-]?((([0]|([1-9]\\d*))(\\.|[,])\\d+)|([1-9]\\d*))" + "[+\\-*/%^])*" + "[-]?((([0]|([1-9]\\d*))(\\.|[,])\\d+)|([1-9]\\d*))$";
        p = Pattern.compile(regex);
        m = p.matcher(exp);
        if (m.matches()) {
            return false;
        } else {
            System.out.println("The mathematical expression contains errors.");
            return true;
        }
    }

    private static void calculate() {
        double res = 0;
        if (isError()) {
            return;
        } else {
            res = getDouble();
            while(exp.length() != 0) {
                switch (exp.charAt(0)) {
                    case '+':
                        exp = exp.substring(1, exp.length());
                        res += getDouble();
                        break;
                    case '-':
                        exp = exp.substring(1, exp.length());
                        res -= getDouble();
                        break;
                    case '*':
                        exp = exp.substring(1, exp.length());
                        res *= getDouble();
                        break;
                    case '/':
                        exp = exp.substring(1, exp.length());
                        res /= getDouble();
                        break;
                    case '%':
                        exp = exp.substring(1, exp.length());
                        res %= getDouble();
                        break;
                    case '^':
                        exp = exp.substring(1, exp.length());
                        res = Math.pow(res, getDouble());
                        break;
                }
            }
        }
            System.out.println("Result: " + res);
    }

}

