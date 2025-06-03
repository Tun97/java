package dao;

import context.DBContext;
import entity.Category;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    // Lấy tất cả danh mục
    public List<Category> getAllCategories() {
        List<Category> list = new ArrayList<>();
        String sql = "SELECT * FROM Categorys";

        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractCategory(rs));
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi lấy danh sách danh mục:");
            e.printStackTrace();
        }

        return list;
    }

    // Lấy danh mục theo ID
    public Category getCategoryById(int id) {
        String sql = "SELECT * FROM Categorys WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractCategory(rs);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi lấy danh mục theo ID:");
            e.printStackTrace();
        }

        return null;
    }

    // Thêm danh mục mới
    public boolean insertCategory(Category category) {
        String sql = "INSERT INTO Categorys (category_name) VALUES (?)";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm danh mục:");
            e.printStackTrace();
        }
        return false;
    }

    // Cập nhật danh mục
    public boolean updateCategory(Category category) {
        String sql = "UPDATE Categorys SET category_name = ? WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, category.getCategoryName());
            ps.setInt(2, category.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi cập nhật danh mục:");
            e.printStackTrace();
        }
        return false;
    }

    // Xoá danh mục
    public boolean deleteCategory(int id) {
        String sql = "DELETE FROM Categorys WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xoá danh mục:");
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức dùng chung
    private Category extractCategory(ResultSet rs) throws SQLException {
        return new Category(rs.getInt("id"), rs.getString("category_name"));
    }
}
