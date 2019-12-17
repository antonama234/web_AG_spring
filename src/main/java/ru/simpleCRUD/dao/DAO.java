package ru.simpleCRUD.dao;

import ru.simpleCRUD.models.Role;

import java.util.List;

public interface DAO<T> {
    List<T> allUsers();
    void addUser(T object);
    void deleteUser(T object);
    void editUser(T object);
    T findByLogin(String login);
    T findById(Long id);
    Role getRole(Long id);
}
