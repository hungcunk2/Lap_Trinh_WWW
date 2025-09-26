package iuh.fit.se.baitapchuong3;

import iuh.fit.se.baitapchuong3.dao.NhacungcapDAO;
import iuh.fit.se.baitapchuong3.dao.NhacungcapDAOImpl;
import iuh.fit.se.baitapchuong3.model.Nhacungcap;
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

@WebServlet("/NhaCungCapSearchServlet")
public class NhaCungCapSearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        NhacungcapDAO nccDAO = new NhacungcapDAOImpl();
        List<Nhacungcap> nccList;
        if (keyword != null && !keyword.trim().isEmpty()) {
            nccList = nccDAO.search(keyword);
        } else {
            nccList = nccDAO.getAll();
        }
        request.setAttribute("nccList", nccList);
        request.setAttribute("keyword", keyword);
        request.getRequestDispatcher("product_search.jsp").forward(request, response);
    }
}
