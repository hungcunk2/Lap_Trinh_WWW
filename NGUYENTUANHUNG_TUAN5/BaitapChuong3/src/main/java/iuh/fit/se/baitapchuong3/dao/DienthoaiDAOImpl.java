package iuh.fit.se.baitapchuong3.dao;

import iuh.fit.se.baitapchuong3.model.Dienthoai;
import jakarta.persistence.*;
import java.util.*;

/**
 * @author DAILOC
 */

public class DienthoaiDAOImpl implements DienthoaiDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("quanlydienthoaiPU");

    @Override
    public List<Dienthoai> getAll() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT d FROM Dienthoai d", Dienthoai.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public boolean addDienthoai(Dienthoai dt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(dt);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public boolean deleteDienthoai(String maDT) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Dienthoai dt = em.find(Dienthoai.class, maDT);
            if (dt != null) {
                em.remove(dt);
                tx.commit();
                return true;
            }
            tx.rollback();
            return false;
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Dienthoai> getBySupplier(String maNCC) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT d FROM Dienthoai d WHERE d.nhaCungCap.maNCC = :maNCC", Dienthoai.class)
                    .setParameter("maNCC", maNCC)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
