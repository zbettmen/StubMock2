package entities;

public class Category {

    private int categoryId;
    private String description;

    public Category(int categoryId, String description) {
        this.categoryId = categoryId;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
