package database;


public class Category extends Question {
    private int categoryId;
    private String categoryName;

    public Category(int categoryId) {
        super();
    }

    public int getCategoryId()
    {
        return categoryId;
    }
    public String getCategoryName(){
        return categoryName;
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}
