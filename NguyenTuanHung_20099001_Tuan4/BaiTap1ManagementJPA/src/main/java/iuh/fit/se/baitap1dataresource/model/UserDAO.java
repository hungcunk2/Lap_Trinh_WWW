package iuh.fit.se.baitap1dataresource.model;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public interface UserDAO {
    public User insert(User user);
    public List<User> getAll();

}
