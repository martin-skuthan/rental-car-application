package io.database.dao;

import model.User;

import java.util.Collection;

public interface UserDao {

    public void create(User user);

    public User read(String pesel);

    public Collection<User> readAll();

    public void update(User user);

    public void delete(String pesel);
}
