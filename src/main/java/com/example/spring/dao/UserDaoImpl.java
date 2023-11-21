package com.example.spring.dao;

import com.example.spring.models.User;
import com.example.spring.service.UserServiceImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User ", User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        try {
            entityManager.persist(user);
            entityManager.flush();
            logger.info("User saved successfully: {}", user);
        } catch (Exception e) {
            logger.error("Error saving user: {}", e.getMessage(), e);
        }
    }

    @Override
    public void updateUser(int id, User user) {
        User updatedUser = entityManager.find(User.class, id);

        updatedUser.setName(user.getName());
        updatedUser.setLastName(user.getLastName());

        entityManager.flush();
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.flush();
    }
}
