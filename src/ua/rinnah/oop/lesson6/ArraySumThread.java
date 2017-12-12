package ua.rinnah.oop.lesson6;

import javax.sound.midi.Soundbank;

public class ArraySumThread implements Runnable{

    private int[] array;
    private long sum;

    public ArraySumThread(int[] array) {
        this.array = array;
    }

    public ArraySumThread() {
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public long getSum() {
        return sum;
    }

    private void calculate(){
        for (int element : array){
            sum += element;
        }
    }

    @Override
    public void run() {
        calculate();
    }
}
