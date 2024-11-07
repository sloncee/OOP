package ru.vsu.cs.dorofeyeva_s_v.model;

import java.util.ArrayList;

public class BookWarehouse extends Warehouse {
    public BookWarehouse(int number, double square, ArrayList<Product> books) {
        super(number, square, books);
    }

    @Override
    public int getQuantityProducts() {
        return getProducts().size();
    }
}