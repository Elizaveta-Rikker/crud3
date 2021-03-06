package org.rikker.dao;

import org.rikker.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {
    private static int PEOPLE_COUNT;
    private List<User> users;

    {
        users = new ArrayList<>();

        users.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        users.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
    }


    public List<User> index() {
        return users;
    }


    public User show(int id) {
        return users.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }


    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        users.add(user);
    }


    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }


    public void delete(int id) {
        users.removeIf(u -> u.getId() == id);
    }


}

