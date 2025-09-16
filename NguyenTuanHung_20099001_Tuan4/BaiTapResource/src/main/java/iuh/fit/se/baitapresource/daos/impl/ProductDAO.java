package iuh.fit.se.baitapresource.daos.impl;

import iuh.fit.se.baitapresource.entities.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    public List<Product> findAll();
    public Product getById(int id);
    public void addProduct(Product p) throws SQLException;
}
