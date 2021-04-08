package manager;



import entities.Category;
import entities.Purchase;
import store.IPurchaseStore;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class PurchaseManager implements IPurchaseManager {

    private IPurchaseStore purchaseStore;

    public PurchaseManager(IPurchaseStore purchaseStore) {
        this.purchaseStore = purchaseStore;
    }

    @Override
    public float sumOfMonth(int year, int month) {
        LocalDate firstDay = LocalDate.of(year, month, 1);
        LocalDate lastDay = firstDay.plusMonths(1);
        Purchase[] purchases = this.purchaseStore.getPurchases(firstDay, lastDay);
        return Arrays.stream(purchases)
                .map(Purchase::getAmount)
                .reduce(0F, Float::sum);
    }

    // I tried doing it with fancy streams
    // but float is evil
    @Override
    public float[] monthlyAverage(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        Purchase[] purchases = purchaseStore.getPurchases(date, date.plusYears(1));
        Month[] months = Month.values();
        float[] sum = new float[12];
        int[] elements = new int[12];
        for (Purchase purchase : purchases) {
            for (int j = 0; j <= 11; j++) {
                if (purchase.getDate().getMonth() == months[j]) {
                    sum[j] += purchase.getAmount();
                    elements[j]++;
                }
            }
        }
        return average(sum, elements);
    }

    @Override
    public float[] yearlyAveragePerCategory(int year) {
        LocalDate date = LocalDate.of(year, 1, 1);
        Purchase[] purchases = purchaseStore.getPurchases(date, date.plusYears(1));
        Category[] categories = purchaseStore.getAllCategories();
        float[] sum = new float[categories.length];
        int[] elements = new int[categories.length];
        for (Purchase purchase : purchases) {
            for (int j = 0; j < categories.length; j++) {
                if (purchase.getCategoryId() == categories[j].getCategoryId()) {
                    sum[j] += purchase.getAmount();
                    elements[j]++;
                }
            }
        }
        return average(sum, elements);
    }

    private float[] average(float[] sum, int[] elements) {
        float[] average = new float[sum.length];
        for (int i = 0; i < sum.length; i++) {
            if (elements[i] != 0) {
                average[i] = sum[i] / elements[i];
            }
        }
        return  average;
    }

}
