package ru.vsu.cs.dorofeyeva_s_v.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private LocalDate manufacturingDate;
    private LocalDate expirationDate;

    public Product(String name, double price, int quantity, LocalDate manufacturingDate, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.manufacturingDate = manufacturingDate;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void print(){
        System.out.println("name - " + name + ", price - " + Double.toString(price) + ", quantity - " + Integer.toString(quantity) + ", manufacturing date - " + manufacturingDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy")) + ", expiration date - " + expirationDate.format(DateTimeFormatter.ofPattern("dd LLLL yyyy")));
    }
}