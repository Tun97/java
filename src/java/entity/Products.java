package entity;

public class Products {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private String image;

    public Products() {
        // Constructor mặc định để servlet có thể khởi tạo object trống
    }

    public Products(int id, String name, String description, double price, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
    }

    // Nếu bạn cần constructor khác, hãy để lại nhưng không nên throw lỗi
    public Products(int id, String name, String description, float price, int stock, String image) {
        this(id, name, description, (double) price, image); // Bạn có thể bổ sung `stock` nếu cần lưu trữ
    }

    // Getter và Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
