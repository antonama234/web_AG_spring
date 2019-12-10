package ru.simpleCRUD.dao;

import ru.simpleCRUD.models.User;

import java.util.List;

public interface UserDAO extends DAO<User> {
    List<User> allUsers();
    void addUser(User user);
    void deleteUser(User user);
    void editUser(User user);
    User findByLogin(String login);
    User findById(Long id);
}
