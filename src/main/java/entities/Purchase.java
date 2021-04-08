package entities;

import java.time.LocalDate;

public class Purchase {
    private int purchaseId;
    private LocalDate date;
    private float amount;
    private String comment;
    private int categoryId;

    public Purchase(int purchaseId, LocalDate date, float amount, String comment, int categoryId) {
        this.purchaseId = purchaseId;
        this.date = date;
        this.amount = amount;
        this.comment = comment;
        this.categoryId = categoryId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

}
