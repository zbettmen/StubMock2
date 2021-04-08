package org.example;


import entities.Category;
import entities.Purchase;
import manager.PurchaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.PurchaseStoreStub;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseManagerTest_stub {

    private PurchaseManager purchaseManager;
    private PurchaseStoreStub purchaseStoreStub;

    @BeforeEach
    void setUp() {
        purchaseStoreStub = new PurchaseStoreStub();
        purchaseManager = new PurchaseManager(purchaseStoreStub);

        Purchase house = new Purchase(1, LocalDate.of(2021, 3, 17), 1000,
                "house", 1);
        purchaseStoreStub.addPurchase(house);
        Purchase car = new Purchase(2, LocalDate.of(2021, 3, 17), 200,
                "car", 2);
        purchaseStoreStub.addPurchase(car);

        Category big = new Category(1, "big");
        purchaseStoreStub.addCategory(big);
        Category small = new Category(2, "small");
        purchaseStoreStub.addCategory(small);

    }

    @Test
    public void testException() {
        purchaseManager = new PurchaseManager(new PurchaseStoreStub());
        assertThrows(IllegalArgumentException.class, () -> purchaseManager.sumOfMonth(2021, 1));
    }

    @Test
    public void testSumOfMonth() {
        assertEquals(1200, purchaseManager.sumOfMonth(2021, 3));
    }

    @Test
    public void testMonthlyAverage() {
        float[] expected = {0F, 0F, 600F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F};
        assertArrayEquals(expected, purchaseManager.monthlyAverage(2021));
    }

    @Test
    public void testYearlyAverageByCategory() {
        float[] expected = {1000F, 200F};
        assertArrayEquals(expected, purchaseManager.yearlyAveragePerCategory(2021));
    }
}