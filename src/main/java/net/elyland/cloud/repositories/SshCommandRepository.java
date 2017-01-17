package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.SshCommand;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface SshCommandRepository extends JpaRepository<SshCommand, Integer> {

}
