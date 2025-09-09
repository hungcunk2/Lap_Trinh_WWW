package com.example.bai01;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@WebServlet("/registration-form")
public class RegistratiomForm extends HttpServlet {

    private static final long serialVersionUID = 1L;


    public RegistratiomForm() {

        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at : ").append(req.getContextPath());
        String fname = req.getParameter("txtFName");
        String lname = req.getParameter("txtLName");
        String day = req.getParameter("day");
        String month = req.getParameter("month");
        String year = req.getParameter("year");
        String email = req.getParameter("email");
        String mobileNumber = req.getParameter("mobileNumber");
        String gender = req.getParameter("gender");
        String city = req.getParameter("city");
        String pinCode = req.getParameter("txtPinCode");
        String state = req.getParameter("txtState");
        String country = req.getParameter("txtCountry");
        String hobbies = req.getParameter("chkHobbies");
        String course = req.getParameter("txtCourse");
        String birthdate = day + " " + month + " " + year;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse(birthdate, formatter);
        // set data to Student
        Student sv = new Student();

        sv.setFirstName(fname);
        sv.setLastName(lname);
        sv.setEmail(email);
        sv.setGender(gender);
        sv.setBirthday(date);




        // set object student to request object
        req.setAttribute("student", sv);
        RequestDispatcher rd  = req.getRequestDispatcher("result-form.jsp");

        rd.forward(req,resp);
    }
}
