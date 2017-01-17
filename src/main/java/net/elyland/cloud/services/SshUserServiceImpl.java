package net.elyland.cloud.services;

import net.elyland.cloud.domain.SshUser;
import net.elyland.cloud.repositories.SshUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by imaterynko on 17.01.17.
 */
public class SshUserServiceImpl implements SshUserService {
    @Autowired
    SshUserRepository sshUserRepository;
    
    @Override
    public Iterable<SshUser> listAllSshUsers() {
        return sshUserRepository.findAll();
    }

    @Override
    public SshUser getSshUserById(Integer id) {
        return sshUserRepository.getOne(id);
    }

    @Override
    public void deleteSshUser(Integer id) {
        sshUserRepository.delete(id);
    }

    @Override
    public void save(SshUser sshUser) {
        sshUserRepository.save(sshUser);
    }

    @Override
    public SshUser findByUsername(String username){
        return sshUserRepository.findByUsername(username);
    }
}
