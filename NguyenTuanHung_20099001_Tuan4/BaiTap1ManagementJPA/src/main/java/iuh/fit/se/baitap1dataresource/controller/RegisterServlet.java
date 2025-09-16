package iuh.fit.se.baitap1dataresource.controller;


import iuh.fit.se.baitap1dataresource.model.UserDAO;
import iuh.fit.se.baitap1dataresource.model.impl.UserDaoImpl;
import iuh.fit.se.baitap1dataresource.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/registrationForm")
public class RegisterServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        try (EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager()) {

            UserDAO dao = new UserDaoImpl(entityManager);
            String firstName = req.getParameter("txtfname");
            String lastName = req.getParameter("txtlname");
            String email = req.getParameter("txtEmail");
            String reEmail = req.getParameter("txtReEmail");
            String password = req.getParameter("txtPw");

            String gender = req.getParameter("gender");
            String ngay = req.getParameter("day");
            String thang = req.getParameter("month");
            String name = req.getParameter("year");
            String birthday = ngay + "-" + thang + "-" + name;
            iuh.fit.se.baitap1dataresource.model.User user = new iuh.fit.se.baitap1dataresource.model.User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setPassword(password);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setReemail(reEmail);

            dao.insert(user);
            req.setAttribute("users", dao.getAll());
            System.out.println("danh sach"+ dao.getAll());
            req.getRequestDispatcher("/registration-form.jsp").forward(req, resp);
//        req.getRequestDispatcher("list.jsp").forward(req, resp);

            //req.getRequestDispatcher("success.jsp").forward(req, resp);
        }

    }
}
