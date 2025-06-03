package entity;

public class Users {
    private int id;
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String role;

    // Constructor đầy đủ (có id)
    public Users(int id, String username, String email, String password, String role, String fullname) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    // Constructor không có id (dùng cho đăng ký chẳng hạn)
    public Users(String username, String email, String password, String role, String fullname) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
    }

    // Constructor mặc định
    public Users() {
        // Không cần làm gì thêm
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
