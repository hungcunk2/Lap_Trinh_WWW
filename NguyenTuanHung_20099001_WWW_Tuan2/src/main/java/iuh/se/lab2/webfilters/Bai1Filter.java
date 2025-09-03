package iuh.se.lab2.webfilters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/bai2")
public class Bai1Filter implements Filter {
    private String username;
    private String password;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        username = filterConfig.getServletContext().getInitParameter("username");
        password = filterConfig.getServletContext().getInitParameter("password");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        PrintWriter out = servletResponse.getWriter();
        servletResponse.setContentType("text/html");

        if (!"hng209".equals(username) || !"29092004".contains(password)){
            out.println("Người dùng không hợp lệ");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
