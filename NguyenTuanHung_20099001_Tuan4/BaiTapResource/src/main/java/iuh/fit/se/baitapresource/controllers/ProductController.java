package iuh.fit.se.baitapresource.controllers;

import iuh.fit.se.baitapresource.daos.ProductDAOImpl;
import iuh.fit.se.baitapresource.daos.impl.ProductDAO;
import iuh.fit.se.baitapresource.entities.Product;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "productController", urlPatterns = "/products")
public class ProductController extends HttpServlet {
    @Resource(name = "jdbc/shopping")
    private DataSource dataSource;
    private ProductDAOImpl productDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.productDAO = new ProductDAOImpl(this.dataSource);
        System.out.println("dang nhap");
//        createProduct();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("products", this.productDAO.findAll());
        req.getRequestDispatcher("views/product/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    private void createProduct() {
        List<Product> products = List.of(
                new Product("Product 1", 50000, "image1.png"),
                new Product("Product 2", 20000, "image2.png"),
                new Product("Product 3", 40000, "image3.jpeg"),
                new Product("Product 4", 80000, "image4.jpeg"),
                new Product("Product 5", 100000, "image5.png")
        );

        products.forEach(product -> {
            try {
                productDAO.addProduct(product);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }



}
