package iuh.fit.se.baitapusermanagementjpa.controllers;

import iuh.fit.se.baitapusermanagementjpa.daos.UserDAO;
import iuh.fit.se.baitapusermanagementjpa.daos.impl.UserDAOImpl;
import iuh.fit.se.baitapusermanagementjpa.entities.User;
import iuh.fit.se.baitapusermanagementjpa.utils.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.io.IOException;
import java.util.List;
import java.util.Set;


@WebServlet(name = "userController", urlPatterns = {"/users", "/users*"})
public class UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            // Phuong thuc new chi la show mot cai form len thoi, chua co lam gi het
            case "new":
                handleShowRegisterForm(req, resp);
                break;
            case "delete":
                handleDeleteUser(req, resp);
                break;
            case "edit":
                handleShowEditForm(req, resp);
                break;
            default:
                handleShowUser(req, resp);
                break;
        }


    }

    private void handleShowUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (EntityManager entityManager = EntityManagerFactory.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);
            List<User> listUser = userDao.finAll();
            req.setAttribute("listUser", listUser);

            RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/list.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handleShowEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try (EntityManager entityManager = EntityManagerFactory.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);
            // Lay thuoc tinh cua id thong qua views/user/list.jsp
            int id = Integer.parseInt(req.getParameter("id"));
            User user = userDao.findById(id);
            // Set user : user
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/edit.jsp");
            dispatcher.forward(req, resp);
        }
    }

    private void handleDeleteUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (EntityManager entityManager = EntityManagerFactory.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);
            // tim id cuA USER
            int id = Integer.parseInt(req.getParameter("id"));
            userDao.delete(id);
            resp.sendRedirect("users");
        }
    }

    private void handleShowRegisterForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Thuc hien ban new chuyen sang giao dien them user
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/add.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "insert":
                handleAddUser(req, resp);
                break;
            case "update":
                handleUpdate(req, resp);
                break;

            default:
                handleShowUser(req, resp);
        }
    }

    private void handleUpdate(HttpServletRequest req, HttpServletResponse resp) {

        try (EntityManager entityManager = EntityManagerFactory.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);


            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("country");
            User newUser = new User(id, name, email, password);


            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> violations = validator.validate(newUser);

            if (violations.isEmpty()) {
                userDao.update(newUser);
                resp.sendRedirect("users");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/edit.jsp");

                StringBuilder stringBuilder = new StringBuilder();
                violations.forEach(violation -> {
                    stringBuilder.append(violation.getPropertyPath() + ": " + violation.getMessage());
                    stringBuilder.append("<br />");
                });

                req.setAttribute("user", newUser);
                req.setAttribute("errors", stringBuilder);
                dispatcher.forward(req, resp);
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }

    }

    private void handleAddUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        try (EntityManager entityManager = EntityManagerFactory.getEntityManager()) {
            UserDAO userDao = new UserDAOImpl(entityManager);
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String country = req.getParameter("country");
            User newUser = new User(name, email, country);

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> violations = validator.validate(newUser);
            if (violations.isEmpty()) {
                userDao.save(newUser);
                resp.sendRedirect("users");
            } else {
                RequestDispatcher dispatcher = req.getRequestDispatcher("views/user/add.jsp");
                StringBuilder builder = new StringBuilder();
                for (ConstraintViolation<User> violation : violations) {
                    builder.append(violation.getPropertyPath() + ": " + violation.getMessage());
                    builder.append("\n");
                }


                req.setAttribute("user", newUser);
                req.setAttribute("errors", builder.toString());
                dispatcher.forward(req, resp);
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
