package ru.simpleCRUD.dao;

import java.util.List;

public interface DAO<T> {
    List<T> allUsers();
    void addUser(T object);
    void deleteUser(T object);
    void editUser(T object);
    T findByLogin(String login);
    T findById(Long id);
}
