package dao;

import entity.Users;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import context.DBContext;

public class UsersDao {

    private Connection conn;

    public UsersDao() {
        try {
            conn = new DBContext().getConnection();
        } catch (Exception e) {
            System.err.println("❌ Lỗi kết nối cơ sở dữ liệu trong UsersDao:");
            e.printStackTrace();
        }
    }

    public void insert(Users user) {
        String sql = "INSERT INTO Users (username, email, password, role, fullname) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getFullname());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi thêm người dùng:");
            e.printStackTrace();
        }
    }

    public boolean register(Users user) {
        String sql = "INSERT INTO Users (username, email, password, role, fullname) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getFullname());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi đăng ký người dùng:");
            e.printStackTrace();
        }
        return false;
    }

    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(extractUser(rs));
            }
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi truy vấn tất cả người dùng:");
            e.printStackTrace();
        }
        return users;
    }

    public Users getUserById(int id) {
        String sql = "SELECT * FROM Users WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return extractUser(rs);
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi lấy người dùng theo ID:");
            e.printStackTrace();
        }
        return null;
    }

    public Users login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username = ? AND password = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return extractUser(rs);
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi đăng nhập:");
            e.printStackTrace();
        }
        return null;
    }

    public void updateUser(Users user) {
        String sql = "UPDATE Users SET username = ?, email = ?, password = ?, role = ?, fullname = ? WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getRole());
            ps.setString(5, user.getFullname());
            ps.setInt(6, user.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi cập nhật người dùng:");
            e.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi xóa người dùng:");
            e.printStackTrace();
        }
    }

    public boolean checkUserExists(String username) {
        String sql = "SELECT id FROM Users WHERE username = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("❌ Lỗi khi kiểm tra người dùng tồn tại:");
            e.printStackTrace();
        }
        return false;
    }

    private Users extractUser(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String username = rs.getString("username");
        String email = rs.getString("email");
        String password = rs.getString("password");
        String role = rs.getString("role");
        String fullname = rs.getString("fullname");

        return new Users(id, username, email, password, role, fullname);
    }
}
