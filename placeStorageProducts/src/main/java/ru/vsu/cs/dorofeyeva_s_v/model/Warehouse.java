package ru.vsu.cs.dorofeyeva_s_v.model;

import java.util.ArrayList;

public abstract class Warehouse implements Interface {
    private int number;
    private double square;
    private ArrayList<Product> products;

    public Warehouse(int number, double square, ArrayList<Product> products) {
        this.number = number;
        this.square = square;
        this.products = products;
    }

    public int getNumber () {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getSquare () {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }

    public ArrayList<Product> getProducts () {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product, int index) {
        this.products.set(index, product);
    }

    public abstract int getQuantityProducts();

    @Override
    public void print(){
        System.out.println("number - " + Integer.toString(number) + ", square - " + Double.toString(square));
        for (Product p : products) {
            p.print();
        }
        System.out.println();
    }
}