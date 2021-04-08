package store;


import entities.Category;
import entities.Purchase;

import java.time.LocalDate;

public interface IPurchaseStore {
    /**
     * Get purchases from startDate to endDate.
     *
     * @param startDate
     * @param endDate
     * @return Purchases.
     */
    Purchase[] getPurchases(LocalDate startDate, LocalDate endDate);

    /**
     * Get purchases from startDate to endDate for category catId.
     *
     * @param startDate
     * @param endDate
     * @param catId
     * @return Purchases.
     */
    Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int catId);

    /**
     * Get all categories.
     *
     * @returnCategories.
     */
    Category[] getAllCategories();
}
