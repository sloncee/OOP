package ru.vsu.cs.dorofeyeva_s_v.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.vsu.cs.dorofeyeva_s_v.model.Product;
import ru.vsu.cs.dorofeyeva_s_v.model.ProductOnStack;
import ru.vsu.cs.dorofeyeva_s_v.model.Warehouse;
import ru.vsu.cs.dorofeyeva_s_v.exceptions.CheckedWarehouseAddProductException;
import ru.vsu.cs.dorofeyeva_s_v.exceptions.UncheckedProductOnStackPriceException;

public class ServiceWithCatch {
    private static final Logger logger = LogManager.getLogger(ServiceWithCatch.class);

    public void processProductOnStackPrice(ProductOnStack productOnStack) {
        try {
            logger.info("Проверка цены продукта: " + productOnStack.getProduct().getName());
            logger.info("Цена: " + productOnStack.getProduct().getPrice());

            if (productOnStack.getProduct().getPrice() > 0) {
                logger.info("Проверка цены продукта прошла успешно");
            } else {
                logger.error("Ошибка: Цена продукта на полке не может быть неположительной!");
                throw new UncheckedProductOnStackPriceException("Цена продукта на полке не может быть неположительной!");
            }
        } catch (UncheckedProductOnStackPriceException e) {
            logger.error("Обработка исключения: " + e.getMessage());
        } finally {
            logger.info("Завершение проверки продукта\n");
        }
    }

    public void processWarehouseAddProduct(Warehouse warehouse, Product product, int index) {
        try {
            logger.info("Проверка добавления продукта на склад вместимостью: " + warehouse.getProducts().size());
            logger.info("Номер места: " + index);

            if (index >= 0 && index < warehouse.getProducts().size()) {
                warehouse.addProduct(product, index);
                logger.info("Продукт добавлен на склад успешно");
            } else {
                logger.error("Ошибка: Товар не может быть добавлен на склад!");
                throw new CheckedWarehouseAddProductException("Товар не может быть добавлен на склад!");
            }
        } catch (CheckedWarehouseAddProductException e) {
            logger.error("Обработка исключения: " + e.getMessage());
        } finally {
            logger.info("Завершение добавления продукта на склад\n");
        }
    }
}
