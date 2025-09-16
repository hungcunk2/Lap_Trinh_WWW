package iuh.fit.se.baitap1dataresource.model.impl;


import iuh.fit.se.baitap1dataresource.model.User;
import iuh.fit.se.baitap1dataresource.model.UserDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class UserDaoImpl implements UserDAO {
    private EntityManager em;

    public UserDaoImpl(EntityManager em) {
        this.em = em;
    }

    public User insert(User user) {
        //       String sql = "INSERT INTO users(first_name, last_name, email, password, gender, birthday, reemail) VALUES(?,?,?,?,?,?,?)";
//        try (Connection conn = em.getTransaction();
//             PreparedStatement ps = conn.prepareStatement(sql)) {
//
//            ps.setString(1, user.getFirstName());
//            ps.setString(2, user.getLastName());
//            ps.setString(3, user.getEmail());
//            ps.setString(4, user.getPassword());
//            ps.setString(5, user.getGender());
//            ps.setString(6, user.getBirthday());
//            ps.setString(7, user.getReemail());
//
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        EntityTransaction transaction = em.getTransaction();
        try {
            transaction.begin();

            em.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null && transaction.isActive())
                transaction.rollback();
        }
        return user;
    }

    // Lấy tất cả user (không trả password)
    public List<User> getAll() {
//        List<User> list = new ArrayList<>();
//        String sql = "SELECT first_name, last_name, email, gender, birthday, reemail FROM users";
//
//        try (Connection conn = iuh.fit.se.baitap1dataresource.util.DBConnection.getConnection();
//             PreparedStatement ps = conn.prepareStatement(sql);
//             ResultSet rs = ps.executeQuery()) {
////(String firstName, String lastName, String gender, String email, String password, LocalDate birthday)
//            while (rs.next()) {
//                User u = new User(
//                        rs.getString("first_name"),
//                        rs.getString("last_name"),
//                        rs.getString("gender"),
//                        rs.getString("email"),
//                        null, rs.getString("birthday"),
//                        rs.getString("reemail")// không lấy password
//                );
//                list.add(u);
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return list;


        try {
           return em.createQuery("SELECT u FROM User u", User.class)
                   .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
