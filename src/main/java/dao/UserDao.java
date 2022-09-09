package dao;

import entities.User;

import javax.persistence.*;

public class UserDao implements IUserDao<User> {

    static EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("hibernate");

    @Override
    public User find(String username) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.createQuery("SELECT u from User u WHERE u.username = :username", User.class).
                    setParameter("username", username).getSingleResult();
            entityManager.close();
            return user;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    @Override
    public boolean save(User user) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(user);//save bd
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean delete(User user) {
        EntityManager entityManager = null;
        try {
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean doExist(String username) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.createQuery("SELECT u from User u WHERE u.username = :username", User.class).
                    setParameter("username", username).getSingleResult();
            entityManager.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (NoResultException ignored) {
            return false;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean updatePassword(User user, String hashPassword, String salt) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            user.setSalt(salt);
            user.setHashPassword(hashPassword);
            entityManager.persist(user);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
