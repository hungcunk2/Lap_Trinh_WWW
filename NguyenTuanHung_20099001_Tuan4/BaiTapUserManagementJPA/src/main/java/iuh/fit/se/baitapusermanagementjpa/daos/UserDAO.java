package iuh.fit.se.baitapusermanagementjpa.daos;

import iuh.fit.se.baitapusermanagementjpa.entities.User;

import java.util.List;

public interface UserDAO {
    public User save(User user);
    public User update(User user);
    public boolean delete(int id);
    public User findById(int id);
    public List<User> finAll();
}
