package org.rikker.dao;

import org.rikker.models.User;

import java.util.List;

public interface UserDAO {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(User updatedUser);

    void delete(int id);
}
