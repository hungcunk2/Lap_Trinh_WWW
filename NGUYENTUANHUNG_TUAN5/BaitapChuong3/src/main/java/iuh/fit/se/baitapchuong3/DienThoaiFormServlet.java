package iuh.fit.se.baitapchuong3;

import iuh.fit.se.baitapchuong3.dao.DienthoaiDAO;
import iuh.fit.se.baitapchuong3.dao.DienthoaiDAOImpl;
import iuh.fit.se.baitapchuong3.dao.NhacungcapDAO;
import iuh.fit.se.baitapchuong3.dao.NhacungcapDAOImpl;
import iuh.fit.se.baitapchuong3.model.Dienthoai;
import iuh.fit.se.baitapchuong3.model.Nhacungcap;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.util.Set;

/**
 * @author DAILOC
 */

@WebServlet("/DienThoaiFormServlet")
@MultipartConfig(fileSizeThreshold=1024*1024*2, maxFileSize=1024*1024*10, maxRequestSize=1024*1024*50)
public class DienThoaiFormServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhacungcapDAO nccDAO = new NhacungcapDAOImpl();
        List<Nhacungcap> nccList = nccDAO.getAll();
        request.setAttribute("nccList", nccList);
        request.getRequestDispatcher("product_add.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String maDT = request.getParameter("maDT");
        String tenDT = request.getParameter("tenDT");
        String namSX = request.getParameter("namSanXuat");
        String cauHinh = request.getParameter("cauHinh");
        String maNCC = request.getParameter("maNCC");
        Part filePart = request.getPart("hinhAnh");
        String fileName = null;
        if (filePart != null && filePart.getSize() > 0) {
            fileName = new File(filePart.getSubmittedFileName()).getName();
            String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) uploadDir.mkdir();
            filePart.write(uploadPath + File.separator + fileName);
        }
        int year = 0;
        try { year = Integer.parseInt(namSX); } catch (Exception e) {}
        NhacungcapDAO nccDAO = new NhacungcapDAOImpl();
        Nhacungcap ncc = nccDAO.getById(maNCC);
        Dienthoai dt = new Dienthoai(maDT, tenDT, year, cauHinh, ncc, fileName);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Dienthoai>> violations = validator.validate(dt);
        if (!violations.isEmpty()) {
            request.setAttribute("violations", violations);
            NhacungcapDAO nccDAO2 = new NhacungcapDAOImpl();
            List<Nhacungcap> nccList = nccDAO2.getAll();
            request.setAttribute("nccList", nccList);
            request.setAttribute("dt", dt);
            request.getRequestDispatcher("product_add.jsp").forward(request, response);
            return;
        }
        DienthoaiDAO dtDAO = new DienthoaiDAOImpl();
        boolean success = dtDAO.addDienthoai(dt);
        request.setAttribute("success", success);
        request.getRequestDispatcher("KetQua.jsp").forward(request, response);
    }
}
