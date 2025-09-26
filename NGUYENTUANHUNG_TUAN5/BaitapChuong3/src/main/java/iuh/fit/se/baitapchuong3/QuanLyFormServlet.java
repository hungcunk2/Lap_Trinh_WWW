package iuh.fit.se.baitapchuong3;

import iuh.fit.se.baitapchuong3.dao.DienthoaiDAO;
import iuh.fit.se.baitapchuong3.dao.DienthoaiDAOImpl;
import iuh.fit.se.baitapchuong3.model.Dienthoai;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author DAILOC
 */

@WebServlet("/QuanLyFormServlet")
public class QuanLyFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DienthoaiDAO dtDAO = new DienthoaiDAOImpl();
        List<Dienthoai> dtList = dtDAO.getAll();
        request.setAttribute("dtList", dtList);
        request.getRequestDispatcher("QuanLyForm.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maDT = request.getParameter("maDT");
        DienthoaiDAO dtDAO = new DienthoaiDAOImpl();
        boolean deleted = dtDAO.deleteDienthoai(maDT);
        request.setAttribute("deleted", deleted);
        doGet(request, response);
    }
}
