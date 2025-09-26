package iuh.fit.se.baitapchuong3.dao;

import iuh.fit.se.baitapchuong3.model.Nhacungcap;
import jakarta.persistence.*;
import java.util.*;


/**
 * @author DAILOC
 */

public class NhacungcapDAOImpl implements NhacungcapDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("quanlydienthoaiPU");

    @Override
    public List<Nhacungcap> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT n FROM Nhacungcap n", Nhacungcap.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Nhacungcap> search(String keyword) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery(
                "SELECT n FROM Nhacungcap n WHERE n.maNCC LIKE :kw OR n.tenNhaCC LIKE :kw OR n.diaChi LIKE :kw OR n.soDienThoai LIKE :kw",
                Nhacungcap.class)
                .setParameter("kw", "%" + keyword + "%")
                .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Nhacungcap getById(String maNCC) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Nhacungcap.class, maNCC);
        } finally {
            em.close();
        }
    }
}
