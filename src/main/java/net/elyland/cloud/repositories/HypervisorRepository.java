package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.Hypervisor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by imaterynko on 12.01.17.
 */
public interface HypervisorRepository extends JpaRepository<Hypervisor, Integer> {
    Hypervisor findByHostname(String hostname);
}
