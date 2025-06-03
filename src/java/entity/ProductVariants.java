package entity;

public class ProductVariants {
    private int id;
    private int productId;
    private int categoryId;
    private int stock;
    private double price;
    private String productName;
    private String categoryName;

    // Constructor không đầy đủ (4 trường)
    public ProductVariants(int id, int productId, int categoryId, int stock) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
        this.stock = stock;
    }

    // Constructor đầy đủ tất cả trường
    public ProductVariants(int id, int productId, int categoryId, int stock, double price, String productName, String categoryName) {
        this.id = id;
        this.productId = productId;
        this.categoryId = categoryId;
        this.stock = stock;
        this.price = price;
        this.productName = productName;
        this.categoryName = categoryName;
    }

    public ProductVariants() {
    }

    // Getters và setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductVariants{" +
                "id=" + id +
                ", productId=" + productId +
                ", categoryId=" + categoryId +
                ", stock=" + stock +
                ", price=" + price +
                ", productName='" + productName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
