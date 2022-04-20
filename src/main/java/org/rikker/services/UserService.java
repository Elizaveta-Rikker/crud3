package org.rikker.services;

import org.rikker.models.User;

import java.util.List;

public interface UserService {
    List<User> index();

    User show(int id);

    void save(User user);

    void update(User updatedUser);

    void delete(int id);
}
