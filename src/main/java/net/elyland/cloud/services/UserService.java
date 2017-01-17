package net.elyland.cloud.services;

import net.elyland.cloud.domain.User;

/**
 * Created by Igor on 17-Jun-16.
 */
public interface UserService {
    Iterable<User> listAllUsers();
    User getUserById(Integer id);
    void deleteUser(Integer id);
    void save(User user);
    public User findByUsername(String username);
}
