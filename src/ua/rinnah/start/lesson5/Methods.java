package ua.rinnah.start.lesson5;
import java.util.Arrays;

public class Methods {


    /**
     *  Написать функцию, которая принимает массив чисел в качестве
     * аргумента, увеличивает его первые 3 элемента на 1 и
     * возвращает их сумму как результат. После изменения массив и
     * сумму надо вывести на экран.
     */
    private static int sumOfArray(int[] arr){
        int n = Math.min(3, arr.length);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i]++;
            sum += arr[i];
        }
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Sum of array: " +sum);
        return sum;
    }

    /**
     *  Написать ф-ю, которая принимает на вход массив чисел и
     * возвращает его длину в байтах как результат
     */
    private static int amountOfBytes(Object object) {
        if (object instanceof int[]) {
            return ((int[]) object).length * 4;
        }else if(object instanceof byte[]) {
            return ((byte[]) object).length;
        }else if(object instanceof short[]) {
            return ((short[]) object).length * 2;
        }else if(object instanceof long[]) {
            return ((long[]) object).length * 8;
        }else if(object instanceof float[]) {
            return ((float[]) object).length * 4;
        }else if(object instanceof double[]) {
            return ((double[]) object).length * 8;
        }else if(object instanceof boolean[]) {
            return ((boolean[]) object).length;
        }
        return 0;
    };

    /**
     *  Написать ф-ю для объединения 2-х массивов в один. Вывести
     * результат на консоль.
     */
    private static int[] combOfArrays(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arr, 0, arr1.length);
        System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
        System.out.println("Array1: " + Arrays.toString(arr1));
        System.out.println("Array2: " + Arrays.toString(arr2));
        System.out.println("Arrays: " + Arrays.toString(arr));
        return arr;
    }


}
