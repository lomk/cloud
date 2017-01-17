package net.elyland.cloud.services;

import net.elyland.cloud.domain.SshUser;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface SshUserService {
    Iterable<SshUser> listAllSshUsers();

    SshUser getSshUserById(Integer id);

    void deleteSshUser(Integer id);

    void save(SshUser sshUser);

    SshUser findByUsername(String username);
}
