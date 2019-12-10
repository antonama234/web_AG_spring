package ru.simpleCRUD.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.simpleCRUD.dao.UserDAO;
import ru.simpleCRUD.models.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO dao;

    @Autowired
    public void setRepository(UserDAO dao) {
        this.dao = dao;
    }

    @Override
    public List<User> allUsers() {
        return dao.allUsers();
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        dao.deleteUser(user);
    }

    @Override
    public void editUser(User user) {
        dao.editUser(user);
    }

    @Override
    public User findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public User findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public boolean isExist(String login) {
        return dao.findByLogin(login) != null;
    }
}
