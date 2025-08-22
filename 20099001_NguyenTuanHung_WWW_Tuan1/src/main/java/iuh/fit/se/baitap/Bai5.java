package iuh.fit.se.baitap;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.baitap.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai5", value = "/bai5")
public class Bai5 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");

        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setBio(req.getParameter("bio"));
        user.setPassword(req.getParameter("facebook"));
        user.setEmail(req.getParameter("email"));

        ObjectMapper objectMapper = new ObjectMapper();

        String userJson = objectMapper.writeValueAsString(user);

        PrintWriter out = resp.getWriter();
        out.println(userJson);
    }
}
