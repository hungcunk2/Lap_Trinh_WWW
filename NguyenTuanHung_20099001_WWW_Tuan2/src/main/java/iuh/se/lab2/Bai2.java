package iuh.se.lab2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "bai2", value = "/bai2")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class Bai2 extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "uploads"; // Relative to webapp root

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String applicationPath = req.getServletContext().getRealPath("");
        String uploadPath = applicationPath + UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        try {
            Collection<Part> parts= req.getParts();
            for (Part part : parts) {
                String fileName = part.getSubmittedFileName();
                // Bỏ qua các trường form không phải là file
                if (fileName == null || fileName.isEmpty()) {
                    continue;
                }

                String filePath = uploadPath + File.separator + fileName;

                // Sử dụng InputStream để đọc và ghi file
                try (InputStream input = part.getInputStream()) {
                    Files.copy(input, Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
                }
            }
            System.out.println("Tất cả các file đã được upload thành công.");
            resp.getWriter().println("Tất cả các file đã được upload thành công.");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
