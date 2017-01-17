package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.SshUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface SshUserRepository extends JpaRepository<SshUser, Integer> {
    SshUser findByUsername(String username);
}
