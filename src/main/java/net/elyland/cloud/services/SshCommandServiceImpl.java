package net.elyland.cloud.services;

import net.elyland.cloud.domain.SshCommand;
import net.elyland.cloud.repositories.SshCommandRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by imaterynko on 17.01.17.
 */
public class SshCommandServiceImpl implements SshCommandService {
    @Autowired
    SshCommandRepository sshCommandRepository;

    @Override
    public Iterable<SshCommand> listAllSshCommands() {
        return sshCommandRepository.findAll();
    }

    @Override
    public SshCommand getSshCommandById(Integer id) {
        return sshCommandRepository.getOne(id);
    }

    @Override
    public void deleteSshCommand(Integer id) {
        sshCommandRepository.delete(id);
    }

    @Override
    public void save(SshCommand sshCommand) {
        sshCommandRepository.save(sshCommand);
    }
}
