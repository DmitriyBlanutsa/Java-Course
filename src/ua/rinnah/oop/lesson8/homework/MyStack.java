package ua.rinnah.oop.lesson8.homework;

import java.util.Arrays;

public class MyStack {

    private int beginSize = 10;
    private Object[] stack;
    private BlackListOfClasses blackList;

    public MyStack() {
        stack = new Object[beginSize];
    }

    public MyStack(int beginSize) {
        this.beginSize = beginSize;
        stack = new Object[beginSize];
    }

    public MyStack(Object[] stack, BlackListOfClasses blackList) {
        this.blackList = blackList;
        checkStack(stack);
    }

    public MyStack(BlackListOfClasses blackList) {
        stack = new Object[beginSize];
        this.blackList = blackList;
    }

    private final void checkStack(Object[] stack){
        try {
            if (stack == null) {
                throw new IllegalArgumentException("Stack is empty!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        int n = 0;
        this.stack = new Object[stack.length];
        for (int i = 0; i < stack.length; i++){
            if (stack[i] != null){
                this.stack[n] = stack[i];
                n++;
            }
        }
    }

    public void push(Object obj){
        try {
            if (obj == null) {
                throw new IllegalArgumentException("Object is empty!!!");
            }
            if (blackList.isInList(obj.getClass())) {
                throw new IllegalArgumentException("This class is in black list!!!");
            }
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return;
        }
        if (stack == null){
            stack = new Object[beginSize];
            stack[0] = obj;
        }else {
            if (stack[stack.length - 1] != null) {
                Object[] newStack = new Object[stack.length * 2];
                System.arraycopy(stack, 0, newStack, 0, stack.length);
                stack = newStack;
            }
            for (int i = stack.length - 2; i >= 0; i--){
                stack[i + 1] = stack[i];
            }
            stack[0] = obj;
        }
    }

    public Object pop() {
        try {
            if (stack == null)
                throw new IllegalArgumentException("This stack is empty!!!");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            return null;
        }
        Object o = stack[0];
        for (int i = 1; i < stack.length; i++){
            stack[i - 1] = stack[i];
        }
        return o;
    }

    public Object[] getList() {
        return stack;
    }

    public void setList(Object[] stack) {
        checkStack(stack);
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + Arrays.toString(stack) +
                ", blackList=" + blackList +
                '}';
    }
}
