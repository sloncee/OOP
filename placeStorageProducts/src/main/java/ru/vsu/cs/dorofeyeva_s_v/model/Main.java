package ru.vsu.cs.dorofeyeva_s_v.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1, "Эконива");

        Stack stack2 = new Stack(3, 70);
        Product clothes1 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack1 = new ClothingProductOnStack(clothes1, stack2, "Глория Джинс");

        ArrayList<Product> books1 = new ArrayList<>();
        books1.add(new Product("Война и мир", 120, 35,
                LocalDate.of(2000, 1, 1), LocalDate.of(2045, 1, 1)));
        BookWarehouse bookWarehouse1 = new BookWarehouse(2, 120.6, books1);

        ArrayList<Product> medicines1 = new ArrayList<>();
        medicines1.add(new Product("Парацетамол", 120, 1400,
                LocalDate.of(2021, 6, 19), LocalDate.of(2025, 1, 24)));
        medicines1.add(new Product("Анальгин", 420, 700,
                LocalDate.of(2019, 3, 11), LocalDate.of(2024, 12, 4)));
        medicines1.add(new Product("Пенталгин", 340, 200,
                LocalDate.of(2020, 8, 1), LocalDate.of(2026, 3, 30)));
        MedicineWarehouse medicineWarehouse1 = new MedicineWarehouse(2, 120.6, medicines1);


        ArrayList<Interface> placeStorageProducts = new ArrayList<>();
        placeStorageProducts.add(foodProductOnStack1);
        placeStorageProducts.add(clothingProductOnStack1);
        placeStorageProducts.add(bookWarehouse1);
        placeStorageProducts.add(medicineWarehouse1);

        for (Interface i : placeStorageProducts) {
            i.print();
        }
    }
}