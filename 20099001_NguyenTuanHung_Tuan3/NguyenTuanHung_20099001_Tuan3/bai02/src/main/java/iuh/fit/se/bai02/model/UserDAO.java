package iuh.fit.se.bai02.model;

import iuh.fit.se.bai02.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    public void insert(User user) {
        String sql = "INSERT INTO users(first_name, last_name, email, password, gender, birthday, reemail) VALUES(?,?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getGender());
            ps.setString(6, user.getBirthday());
            ps.setString(7, user.getReemail());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Lấy tất cả user (không trả password)
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT first_name, last_name, email, gender, birthday, reemail FROM users";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
//(String firstName, String lastName, String gender, String email, String password, LocalDate birthday)
            while (rs.next()) {
                User u = new User(
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("gender"),
                        rs.getString("email"),
                        null, rs.getString("birthday"),
                        rs.getString("reemail")// không lấy password
                );
                list.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
