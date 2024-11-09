package ru.vsu.cs.dorofeyeva_s_v;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.dorofeyeva_s_v.comparator.ProviderProductOnStackComparator;
import ru.vsu.cs.dorofeyeva_s_v.model.*;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class ProviderWarehouseComparatorTest {
    private static List<ProductOnStack> sortingByProvider;
    private static List<ProductOnStack> sortingByProviderAndProduct;

    @BeforeAll
    static void setUp() {
        sortingByProvider = getSortingByProvider();
        sortingByProviderAndProduct = getSortingByProviderAndProduct();
    }

    @Test
    @DisplayName("Сортировка по поставщику")
    void testSortProductOnStackByProvider() {
        ArrayList<ProductOnStack> listProductsOnStack1 = new ArrayList<>();

        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Творог", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1, "Эконива");

        Stack stack2 = new Stack(3, 70);
        Product clothes2 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack2 = new ClothingProductOnStack(clothes2, stack2, "Глория джинс");

        Stack stack3 = new Stack(1, 120);
        Product food3 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack3 = new FoodProductOnStack(food3, stack3, "Эконива");

        listProductsOnStack1.add(foodProductOnStack1);
        listProductsOnStack1.add(clothingProductOnStack2);
        listProductsOnStack1.add(foodProductOnStack3);

        listProductsOnStack1.sort(new ProviderProductOnStackComparator());

        for (int i = 0; i < listProductsOnStack1.size(); i++) {
            assertThat(listProductsOnStack1.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("product", "stack")
                    .isEqualTo(sortingByProvider.get(i));
        }

    }

    @Test
    @DisplayName("Сортировка по поставщику и товару")
    void testSortProductOnStackByProviderAndProduct(){
        ArrayList<ProductOnStack> listProductsOnStack2 = new ArrayList<>();

        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Творог", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1, "Эконива");

        Stack stack2 = new Stack(3, 70);
        Product clothes2 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack2 = new ClothingProductOnStack(clothes2, stack2, "Глория джинс");

        Stack stack3 = new Stack(1, 120);
        Product food3 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack3 = new FoodProductOnStack(food3, stack3, "Эконива");

        listProductsOnStack2.add(foodProductOnStack1);
        listProductsOnStack2.add(clothingProductOnStack2);
        listProductsOnStack2.add(foodProductOnStack3);

        listProductsOnStack2.sort(Comparator.comparing(ProductOnStack::getProvider).thenComparing(ProductOnStack::getProduct));

        for (int i = 0; i < listProductsOnStack2.size(); i++) {
            assertThat(listProductsOnStack2.get(i))
                    .usingRecursiveComparison()
                    .ignoringFields("stack", "product.price", "product.quantity", "product.manufacturingDate", "product.expirationDate")
                    .isEqualTo(sortingByProviderAndProduct.get(i));
        }
    }


    private static List<ProductOnStack> getSortingByProvider(){
        ArrayList<ProductOnStack> listProductsOnStack1 = new ArrayList<>();

        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Творог", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1, "Эконива");

        Stack stack2 = new Stack(3, 70);
        Product clothes2 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack2 = new ClothingProductOnStack(clothes2, stack2, "Глория джинс");

        Stack stack3 = new Stack(1, 120);
        Product food3 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack3 = new FoodProductOnStack(food3, stack3, "Эконива");

        listProductsOnStack1.add(clothingProductOnStack2);
        listProductsOnStack1.add(foodProductOnStack1);
        listProductsOnStack1.add(foodProductOnStack3);

        return listProductsOnStack1;
    }

    private static List<ProductOnStack> getSortingByProviderAndProduct(){
        ArrayList<ProductOnStack> listProductsOnStack2 = new ArrayList<>();

        Stack stack2 = new Stack(3, 70);
        Product clothes2 = new Product("Рубашка", 2500, 4,
                LocalDate.of(2022, 9, 26), LocalDate.of(2023, 11, 10));
        ClothingProductOnStack clothingProductOnStack2 = new ClothingProductOnStack(clothes2, stack2, "Глория джинс");

        Stack stack3 = new Stack(1, 120);
        Product food3 = new Product("Молоко", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack3 = new FoodProductOnStack(food3, stack3, "Эконива");

        Stack stack1 = new Stack(1, 120);
        Product food1 = new Product("Творог", 60, 10,
                LocalDate.of(2023, 10, 20), LocalDate.of(2024, 11, 10));
        FoodProductOnStack foodProductOnStack1 = new FoodProductOnStack(food1, stack1, "Эконива");

        listProductsOnStack2.add(clothingProductOnStack2);
        listProductsOnStack2.add(foodProductOnStack3);
        listProductsOnStack2.add(foodProductOnStack1);

        return listProductsOnStack2;
    }
}
