package ua.rinnah.oop.lesson6;

import ua.rinnah.start.lesson3.Array;

import java.util.Arrays;

public class ArraySumService {

    int[] array;

    public ArraySumService(int[] array) {
        this.array = array;
    }

    public ArraySumService() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long calculateOnMultiThread(){
        int p = Runtime.getRuntime().availableProcessors();
        if (array == null) {
            throw new IllegalArgumentException("array is empty");
        }else if (array.length < p*2) {
            long time = System.currentTimeMillis();
            ArraySumThread myTh = new ArraySumThread(array);
            Thread th = new Thread(myTh);
            th.start();
            try {
                th.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Multi thread calculate method: " + (System.currentTimeMillis() - time)/1000);
            return myTh.getSum();
        }else {
            long time = System.currentTimeMillis();
            ArraySumThread[] myThArr = new ArraySumThread[p];
            Thread[] thArr = new Thread[p];
            int[] arr = null;
            long sum = 0;
            int len = array.length;
            int arraySize = array.length/p;
            for (int i = 0; i < p; i++) {
                if (i == p - 1) {
                    arraySize = array.length - arraySize*i;
                }
                arr = new int[arraySize];
                System.arraycopy(array, i*p,arr,0, arraySize);
                myThArr[i] = new ArraySumThread(arr);
                thArr[i] = new Thread(myThArr[i]);
                thArr[i].start();
                try {
                    thArr[i].join();
                    sum += myThArr[i].getSum();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                len -= arraySize;
            }
            System.out.println("Multi thread calculate method: " + (System.currentTimeMillis() - time)/1000);
            return sum;
        }
    }

    public long calculateSimple(){
        long time = System.currentTimeMillis();
        long sum = 0;
        for (int element : array){
            sum += element;
        }
        System.out.println("Simple calculate method: " + (System.currentTimeMillis() - time)/1000);
        return sum;
    }

}
