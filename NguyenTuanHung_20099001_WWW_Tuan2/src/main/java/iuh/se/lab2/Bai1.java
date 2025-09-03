package iuh.se.lab2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "bai1", value = "/bai1")
public class Bai1 extends HttpServlet {
    private String username;
    private String password;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        username = config.getServletContext().getInitParameter("username");
        password = config.getServletContext().getInitParameter("password");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Xin chào " + username + "</h1>");
        out.println("</body></html>");
    }

}
