package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Igor on 29-Jun-16.
 */

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
