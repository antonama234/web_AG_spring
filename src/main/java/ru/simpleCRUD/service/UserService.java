package ru.simpleCRUD.service;

import ru.simpleCRUD.models.Role;
import ru.simpleCRUD.models.User;

import java.util.List;

public interface UserService extends Service<User> {
    List<User> allUsers();
    void addUser(User object);
    void deleteUser(User object);
    void editUser(User object);
    User findByLogin(String login);
    User findById(Long id);
    boolean isExist(String login);
    Role getRole(Long id);

}
