package ru.simpleCRUD.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.simpleCRUD.models.Role;
import ru.simpleCRUD.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        Session session = sessionFactory.getCurrentSession();
        return (List<User>) session.createQuery("FROM User").list();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    @Transactional
    public void editUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.update(user);
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createQuery("FROM User WHERE login=:login")
                .setParameter("login", login)
                .uniqueResult();
    }

    @Override
    @Transactional
    public User findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @Transactional
    public Role getRole(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (Role) session.createQuery("FROM  WHERE id=:id")
                .setParameter("id", id)
                .uniqueResult();
    }
}
