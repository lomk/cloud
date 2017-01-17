package net.elyland.cloud.services;

import net.elyland.cloud.domain.SshCommand;

/**
 * Created by imaterynko on 17.01.17.
 */
public interface SshCommandService {
    Iterable<SshCommand> listAllSshCommands();

    SshCommand getSshCommandById(Integer id);

    void deleteSshCommand(Integer id);

    void save(SshCommand sshCommand);
}
