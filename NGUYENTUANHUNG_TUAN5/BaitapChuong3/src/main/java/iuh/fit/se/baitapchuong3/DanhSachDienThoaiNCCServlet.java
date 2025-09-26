package iuh.fit.se.baitapchuong3;

import iuh.fit.se.baitapchuong3.dao.DienthoaiDAO;
import iuh.fit.se.baitapchuong3.dao.DienthoaiDAOImpl;
import iuh.fit.se.baitapchuong3.dao.NhacungcapDAO;
import iuh.fit.se.baitapchuong3.dao.NhacungcapDAOImpl;
import iuh.fit.se.baitapchuong3.model.Dienthoai;
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

@WebServlet("/DanhSachDienThoaiNCCServlet")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNCC = request.getParameter("mancc");
        DienthoaiDAO dtDAO = new DienthoaiDAOImpl();
        NhacungcapDAO nccDAO = new NhacungcapDAOImpl();
        List<Nhacungcap> nccList = nccDAO.getAll();
        List<Dienthoai> dtList;
        if (maNCC != null && !maNCC.isEmpty()) {
            dtList = dtDAO.getBySupplier(maNCC);
        } else {
            dtList = dtDAO.getAll();
        }
        request.setAttribute("nccList", nccList);
        request.setAttribute("dtList", dtList);
        request.setAttribute("selectedNCC", maNCC);
        request.getRequestDispatcher("product_list.jsp").forward(request, response);
    }
}
