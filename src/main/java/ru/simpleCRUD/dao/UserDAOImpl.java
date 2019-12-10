package ru.simpleCRUD.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.simpleCRUD.models.User;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<User> allUsers() {
        Session session = sessionFactory.openSession();
        List<User> list = session.createQuery("FROM User").list();
        session.close();
        return list;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = sessionFactory.openSession();
        session.save(user);
        session.close();
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        Session session = sessionFactory.openSession();
        session.delete(user);
        session.close();
    }

    @Override
    @Transactional
    public void editUser(User user) {
        Session session = sessionFactory.openSession();
        session.update(user);
        session.close();
    }

    @Override
    @Transactional
    public User findByLogin(String login) {
        Session session = sessionFactory.openSession();
        User user = (User) session.createQuery("FROM User WHERE login=:login")
                .setParameter("login", login)
                .uniqueResult();
        session.close();
        return user;
    }

    @Override
    @Transactional
    public User findById(Long id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.createQuery("FROM User WHERE id=:id")
                .setParameter("id", id)
                .uniqueResult();
        session.close();
        return user;
    }
}
