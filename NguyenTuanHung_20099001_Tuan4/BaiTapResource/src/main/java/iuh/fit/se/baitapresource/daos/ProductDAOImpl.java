package iuh.fit.se.baitapresource.daos;

import iuh.fit.se.baitapresource.daos.impl.ProductDAO;
import iuh.fit.se.baitapresource.entities.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private final DataSource dataSource;

    public ProductDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public List<Product> findAll() {
        String sql = "SELECT id, name, price, image FROM product";

        List<Product> products = new ArrayList<>();

        try (
                Connection con = (Connection) this.dataSource.getConnection();


                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();


        ) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                products.add(new Product(id, name, price, image));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Product getById(int id) {
        String sql = "SELECT id, name, price, image FROM product WHERE id = ?";
        Product p = null;

        try (
                Connection con = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
        ) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    String name = rs.getString("name");
                    double price = rs.getDouble("price");
                    String image = rs.getString("image");
                    p = new Product(id, name, price, image);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void addProduct(Product p) throws SQLException {
        String sql = "INSERT INTO product (name, price, image) VALUES (?, ?, ?)";
        try (
                Connection connection = (Connection) this.dataSource.getConnection();
                PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
        ) {
            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getImage());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
