package iuh.fit.se.baitap;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai4", value = "/bai4", initParams = {
        @WebInitParam(name = "username", value = "hng209"),
        @WebInitParam(name = "email", value = "22671951.hung@student.iuh.edu.vn")
})
public class Bai4 extends HttpServlet {
    private String user;
    private String username;
    private String email;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.username = config.getInitParameter("username");
        this.email = config.getInitParameter("email");
        this.user = config.getServletContext().getInitParameter("user");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + username + "</h1>");
        out.print("<h1>" + email + "</h1>");
        out.print("<h1>" + user + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // Set response content type
        resp.setContentType("text/html");

        // Display the registration details
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>Student Registration Successful!</h2>");
        out.println("<p>First Name: " + firstName + "</p>");
        out.println("<p>Last Name: " + lastName + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("</body></html>");
    }
}
