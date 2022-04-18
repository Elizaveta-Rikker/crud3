package org.rikker.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.rikker.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDAO {

    private static int PEOPLE_COUNT;
    private List<User> userList;

    {
        userList = new ArrayList<>();

        userList.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        userList.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        userList.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
        userList.add(new User(++PEOPLE_COUNT, "Tom", "Cruise", "tom@mail.ru"));
    }
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from User", User.class).list();
    }

    @Transactional
    public User show(int id) {
        return userList.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    @Transactional
    public void save(User user) {
        user.setId(++PEOPLE_COUNT);
        userList.add(user);
    }

    @Transactional
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);

        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setLastName(updatedUser.getLastName());
        userToBeUpdated.setEmail(updatedUser.getEmail());
    }

    @Transactional
    public void delete(int id) {
        userList.removeIf(u -> u.getId() == id);
    }


}

