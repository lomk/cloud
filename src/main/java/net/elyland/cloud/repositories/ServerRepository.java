package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.Server;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface ServerRepository extends JpaRepository<Server, Integer> {
    Server findByHostname(String hostname);
    Server findByIpAddress(String ipAddress);
}
