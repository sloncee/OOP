package ru.vsu.cs.dorofeyeva_s_v.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class FoodProductOnStack extends ProductOnStack {
    public FoodProductOnStack(Product food, Stack stack) {
        super(food, stack);
    }

    @Override
    public boolean isSuitable() {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = getProduct().getExpirationDate();
        return expirationDate.isAfter(currentDate);
    }

    @Override
    public long getDaysRemaining() {
        LocalDate today = LocalDate.now();
        return ChronoUnit.DAYS.between(today, getProduct().getExpirationDate());
    }
}