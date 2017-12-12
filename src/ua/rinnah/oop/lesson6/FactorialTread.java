package ua.rinnah.oop.lesson6;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import sun.awt.TracedEventQueue;

import java.math.BigInteger;

public class FactorialTread implements Runnable {

    private int number;

    public FactorialTread(int number) {
        this.number = number;
    }

    public FactorialTread() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigInteger getRactorial(int n){
       BigInteger factorial = new BigInteger("1");
       for (int i = 1; i <= n; i++) {
           factorial = factorial.multiply(new BigInteger("" + i));
       }
       return factorial;
    }

    @Override
    public void run() {
        Thread th = Thread.currentThread();
            System.out.println(th.getName() + " -> " + this.number + " " + getRactorial(this.number));
            if (th.isInterrupted()){
                System.out.println(th.getName() + " is interapted");
            }
    }

}
