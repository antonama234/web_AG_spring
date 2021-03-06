package ru.simpleCRUD.service;

import ru.simpleCRUD.models.Role;

import java.util.List;

public interface Service<T> {
    List<T> allUsers();
    void addUser(T object);
    void deleteUser(T object);
    void editUser(T object);
    T findByLogin(String login);
    T findById(Long id);
    boolean isExist(String login);
    Role getRole(Long id);
}
