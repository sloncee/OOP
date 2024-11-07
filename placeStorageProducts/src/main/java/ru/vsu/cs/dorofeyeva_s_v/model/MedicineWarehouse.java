package ru.vsu.cs.dorofeyeva_s_v.model;

import java.util.ArrayList;

public class MedicineWarehouse extends Warehouse {
    public MedicineWarehouse(int number, double square, ArrayList<Product> medicines) {
        super(number, square, medicines);
    }

    @Override
    public  int getQuantityProducts() {
        return getProducts().size();
    }
}