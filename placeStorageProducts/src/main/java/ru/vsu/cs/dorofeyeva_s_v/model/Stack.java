package ru.vsu.cs.dorofeyeva_s_v.model;

public class Stack {
    private int number;
    private int capacity;

    public Stack(int number, int capacity) {
        this.number = number;
        this.capacity = capacity;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void print(){
        System.out.println("number - " + Integer.toString(number) + ", capacity - " + Integer.toString(capacity));
    }
}