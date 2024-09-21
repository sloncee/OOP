package ru.vsu.cs.dorofeyeva_s_v;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1);

        Stack stack2 = new Stack(3, 70);
        Product clothes1 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack1 = new ClothingProductOnStack(clothes1, stack2);

        ArrayList<ProductOnStack> productsOnStacks = new ArrayList<>();
        productsOnStacks.add(foodProductOnStack1);
        productsOnStacks.add(clothingProductOnStack1);

        for (ProductOnStack p : productsOnStacks) {
            if (p.isSuitable()) {
                System.out.printf("Продукт \"%s\" необходимо удалить с %d полки через %d дней", p.getProduct().getName(), p.getStack().getNumber(), p.getDaysRemaining());
            } else {
                System.out.printf("Продукт \"%s\" необходимо немедленно удалить с %d полки!", p.getProduct().getName(), p.getStack().getNumber());
            }
            System.out.println();
        }
    }
}