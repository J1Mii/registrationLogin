package dao;

import entities.User;

public interface IUserDao<T> {
    Object find(String username);

    boolean save(T object);

    boolean delete(T object);

    boolean doExist(String username);

    boolean updatePassword(User user, String hashPassword, String salt);
}
