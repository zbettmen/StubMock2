package org.example;


import entities.Category;
import entities.Purchase;
import manager.PurchaseManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import store.PurchaseStore;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PurchaseManagerTest_mockito {

    private PurchaseManager purchaseManager;
    private PurchaseStore purchaseStore;

    @BeforeEach
    void setUp() {
        purchaseStore = mock(PurchaseStore.class);
        purchaseManager = new PurchaseManager(purchaseStore);
        LocalDate firstDay = LocalDate.of(2021, 01, 1);
        LocalDate lastDay = firstDay.plusMonths(1);
        when(purchaseStore.getPurchases(firstDay, lastDay)).thenReturn(new Purchase[]{
                new Purchase(1, firstDay, 1000F, "house", 1),
                new Purchase(2, firstDay, 200F, "car", 2)}
        );
        firstDay = LocalDate.of(2021, 1, 1);
        when(purchaseStore.getPurchases(firstDay, firstDay.plusYears(1))).thenReturn(new Purchase[]{
                new Purchase(1, firstDay, 1000F, "house", 1),
                new Purchase(2, firstDay, 200F, "car", 2)}
        );

        when(purchaseStore.getAllCategories()).thenReturn(new Category[]{
                new Category(1, "big"),
                new Category(2, "small")});
    }

    @Test
    public void testException() {
        purchaseManager = mock(PurchaseManager.class);
        when(purchaseManager.sumOfMonth(2021, 1)).thenThrow(IllegalArgumentException.class);
        assertThrows(IllegalArgumentException.class, () -> purchaseManager.sumOfMonth(2021, 1));
    }

    @Test
    public void testMonthlyAverage() {
        float[] expected = {600F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F, 0F};
        assertArrayEquals(expected, purchaseManager.monthlyAverage(2021));
    }

    @Test
    public void testSumOfMonth() {
        assertEquals(1200, purchaseManager.sumOfMonth(2021, 1));
    }


    @Test
    public void testYearlyAverageByCategory() {
        float[] expected = {1000F, 200F};
        assertArrayEquals(expected, purchaseManager.yearlyAveragePerCategory(2021));
    }

}