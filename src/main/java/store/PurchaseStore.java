package store;


import entities.Category;
import entities.Purchase;

import java.time.LocalDate;

public class PurchaseStore implements IPurchaseStore {
    @Override
    public Purchase[] getPurchases(LocalDate startDate, LocalDate endDate) {
        return new Purchase[0];
    }

    @Override
    public Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int catId) {
        return new Purchase[0];
    }

    @Override
    public Category[] getAllCategories() {
        return new Category[0];
    }
}
