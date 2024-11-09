package ru.vsu.cs.dorofeyeva_s_v;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ru.vsu.cs.dorofeyeva_s_v.model.BookWarehouse;
import ru.vsu.cs.dorofeyeva_s_v.model.FoodProductOnStack;
import ru.vsu.cs.dorofeyeva_s_v.model.Product;
import ru.vsu.cs.dorofeyeva_s_v.model.Stack;
import ru.vsu.cs.dorofeyeva_s_v.services.ServiceWithCatch;

import java.time.LocalDate;
import java.util.ArrayList;

class ServiceWithCatchTest {
    @Test
    void testProcessWarehouseAddProduct_Positive() {
        // склад с допустимым индексом
        Product product1 = new Product("Test Product", 10.0, 5, null, null);
        ArrayList<Product> books1 = new ArrayList<>();
        books1.add(new Product("Война и мир", 120, 35,
                LocalDate.of(2000, 1, 1), LocalDate.of(2045, 1, 1)));
        BookWarehouse bookWarehouse1 = new BookWarehouse(2, 120.6, books1);

        ServiceWithCatch service1 = new ServiceWithCatch();
        service1.processWarehouseAddProduct(bookWarehouse1, product1, 0);
    }

    @Test
    void testProcessWarehouseAddProduct_Negative() {
        // склад с неверным индексом
        Product product2 = new Product("Test Product", 10.0, 5, null, null);
        ArrayList<Product> books2 = new ArrayList<>();
        books2.add(new Product("Война и мир", 120, 35,
                LocalDate.of(2000, 1, 1), LocalDate.of(2045, 1, 1)));
        BookWarehouse bookWarehouse2 = new BookWarehouse(2, 120.6, books2);

        ServiceWithCatch service2 = new ServiceWithCatch();
        assertDoesNotThrow(() -> service2.processWarehouseAddProduct(bookWarehouse2, product2, 5));
    }


    @Test
    void testProcessProductOnStackPrice_Positive() {
        // продукт с положительной ценой
        Product product1 = new Product("Test Product Positive", 10.0, 5, null, null);
        Stack stack1 = new Stack(1, 120);
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(product1, stack1, null);

        ServiceWithCatch service1 = new ServiceWithCatch();
        service1.processProductOnStackPrice(foodProductOnStack1);
    }

    @Test
    void testProcessProductOnStackPrice_Negative() {
        //1 продукт с неположительной ценой
        Product product2 = new Product("Test Product Negative", -10.0, 5, null, null);
        Stack stack2 = new Stack(1, 120);
        FoodProductOnStack productOnStack = new FoodProductOnStack(product2, stack2, null);

        ServiceWithCatch service2 = new ServiceWithCatch();
        assertDoesNotThrow(() -> service2.processProductOnStackPrice(productOnStack));
    }
}
