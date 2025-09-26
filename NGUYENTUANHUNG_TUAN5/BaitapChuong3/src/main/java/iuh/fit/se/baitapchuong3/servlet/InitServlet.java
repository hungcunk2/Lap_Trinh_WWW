package iuh.fit.se.baitapchuong3.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;

@WebServlet(name = "InitServlet", urlPatterns = "/init", loadOnStartup = 1)
public class InitServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("quanlydienthoaiPU");
            EntityManager em = emf.createEntityManager();
            // Thực hiện một truy vấn đơn giản để kích hoạt Hibernate
            em.getTransaction().begin();
            em.createQuery("select 1").getSingleResult();
            em.getTransaction().commit();
            em.close();
            emf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

