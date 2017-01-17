package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;

/**
 * Created by Igor on 17-Jun-16.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}