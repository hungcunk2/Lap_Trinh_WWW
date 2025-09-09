package iuh.fit.se.bai02.controller;

import iuh.fit.se.bai02.model.User;
import iuh.fit.se.bai02.model.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebServlet("/registrationForm")
public class RegisterServlet extends HttpServlet {
    private UserDAO dao = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String firstName = req.getParameter("txtfname");
        String lastName = req.getParameter("txtlname");
        String email = req.getParameter("txtEmail");
        String reEmail = req.getParameter("txtReEmail");
        String password = req.getParameter("txtPw");

        String gender = req.getParameter("gender");
        String ngay = req.getParameter("day");
        String thang  = req.getParameter("month");
        String name = req.getParameter("year");
        String birthday = ngay+"-"+thang +"-"+name;
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);
        user.setGender(gender);
        user.setBirthday(birthday);
        user.setReemail(reEmail);

        dao.insert(user);
        req.setAttribute("users", dao.getAll());
//        req.getRequestDispatcher("list.jsp").forward(req, resp);

        req.getRequestDispatcher("success.jsp").forward(req, resp);
    }
}
