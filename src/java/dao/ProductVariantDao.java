package dao;

import context.DBContext;
import entity.ProductVariants;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductVariantDao {

    // ✅ Lấy tất cả biến thể sản phẩm
    public List<ProductVariants> getAllVariants() {
        List<ProductVariants> list = new ArrayList<>();
        String sql = "SELECT pv.id, pv.product_id, pv.category_id, pv.stock, " +
                     "p.name AS productName, p.price AS price, c.category_name AS categoryName " +
                     "FROM ProductVariants pv " +
                     "JOIN Products p ON pv.product_id = p.id " +
                     "JOIN Categorys c ON pv.category_id = c.id";

        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(extractVariant(rs));
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi lấy danh sách biến thể:");
            e.printStackTrace();
        }

        return list;
    }

    // ✅ Lấy biến thể theo ID
    public ProductVariants findById(int id) {
        String sql = "SELECT pv.id, pv.product_id, pv.category_id, pv.stock, " +
                     "p.name AS productName, p.price AS price, c.category_name AS categoryName " +
                     "FROM ProductVariants pv " +
                     "JOIN Products p ON pv.product_id = p.id " +
                     "JOIN Categorys c ON pv.category_id = c.id " +
                     "WHERE pv.id = ?";

        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractVariant(rs);
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi tìm biến thể theo ID:");
            e.printStackTrace();
        }

        return null;
    }

    // ✅ Lấy biến thể theo product_id
    public List<ProductVariants> findByProductId(int productId) {
        List<ProductVariants> list = new ArrayList<>();
        String sql = "SELECT pv.id, pv.product_id, pv.category_id, pv.stock, " +
                     "p.name AS productName, p.price AS price, c.category_name AS categoryName " +
                     "FROM ProductVariants pv " +
                     "JOIN Products p ON pv.product_id = p.id " +
                     "JOIN Categorys c ON pv.category_id = c.id " +
                     "WHERE pv.product_id = ?";

        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(extractVariant(rs));
                }
            }
        } catch (Exception e) {
            System.out.println("❌ Lỗi khi tìm theo product_id:");
            e.printStackTrace();
        }

        return list;
    }

    // ✅ Thêm biến thể
    public boolean insertVariant(ProductVariants variant) {
        String sql = "INSERT INTO ProductVariants (product_id, category_id, stock) VALUES (?, ?, ?)";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, variant.getProductId());
            ps.setInt(2, variant.getCategoryId());
            ps.setInt(3, variant.getStock());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi thêm biến thể:");
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Cập nhật biến thể
    public boolean updateVariant(ProductVariants variant) {
        String sql = "UPDATE ProductVariants SET product_id = ?, category_id = ?, stock = ? WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, variant.getProductId());
            ps.setInt(2, variant.getCategoryId());
            ps.setInt(3, variant.getStock());
            ps.setInt(4, variant.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi cập nhật biến thể:");
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Xóa biến thể
    public boolean deleteVariant(int id) {
        String sql = "DELETE FROM ProductVariants WHERE id = ?";
        try (Connection conn = new DBContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("❌ Lỗi khi xoá biến thể:");
            e.printStackTrace();
        }
        return false;
    }

    // ✅ Tách xử lý kết quả
    private ProductVariants extractVariant(ResultSet rs) throws SQLException {
        ProductVariants v = new ProductVariants();
        v.setId(rs.getInt("id"));
        v.setProductId(rs.getInt("product_id"));
        v.setCategoryId(rs.getInt("category_id"));
        v.setStock(rs.getInt("stock"));
        v.setProductName(rs.getString("productName"));
        v.setCategoryName(rs.getString("categoryName"));
        v.setPrice(rs.getDouble("price")); // ⭐️ Thêm dòng này
        return v;
    }
}
