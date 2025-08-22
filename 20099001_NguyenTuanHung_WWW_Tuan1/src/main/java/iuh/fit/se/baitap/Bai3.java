package iuh.fit.se.baitap;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.baitap.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "bai3", value = "/bai3")
public class Bai3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setPassword("29092004");
        user.setUsername("hng209");

        String value = objectMapper.writeValueAsString(user);
        resp.getWriter().print(value);
    }
}
