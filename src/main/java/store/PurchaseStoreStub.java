package store;



import entities.Category;
import entities.Purchase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class PurchaseStoreStub extends PurchaseStore {

    private ArrayList<Purchase> purchaseList;
    private ArrayList<Category> categoryList;

    public PurchaseStoreStub() {
        this.purchaseList = new ArrayList<>();
        this.categoryList = new ArrayList<>();
    }

    public void addPurchase(Purchase purchase) {
        this.purchaseList.add(purchase);
    }

    public void addCategory(Category category) {
        this.categoryList.add(category);
    }

    @Override
    public Purchase[] getPurchases(LocalDate startDate, LocalDate endDate) {
        var purchaseArr = this.purchaseList.stream()
                .filter(purchase -> purchase.getDate().isAfter(startDate) || purchase.getDate().isEqual(startDate))
                .filter(purchase -> purchase.getDate().isBefore(endDate))
                .toArray(Purchase[]::new);
        if (purchaseArr.length == 0) throw new IllegalArgumentException("The purchase array is empty");
        return purchaseArr;
    }

    @Override
    public Purchase[] getPurchasesByCategory(LocalDate startDate, LocalDate endDate, int catId) {
        var purchaseArr = getPurchases(startDate, endDate);
        return Arrays.stream(purchaseArr)
                .filter(purchase -> purchase.getCategoryId() == catId)
                .toArray(Purchase[]::new);
    }

    @Override
    public Category[] getAllCategories() {
        return this.categoryList.toArray(Category[]::new);
    }
}
