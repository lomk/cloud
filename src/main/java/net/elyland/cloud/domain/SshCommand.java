package net.elyland.cloud.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by imaterynko on 16.01.17.
 */
@Entity
@Table(name = "ssh_command")
public class SshCommand {

    private static final long serialVersionUID = -1000199078147252958L;

    @Id
    @Column(name = "ssh_command_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "command")
    private String command;

    @Column(name = "with_sudo", nullable = true)
    private boolean withSudo;

    private SshUser sshUser;

    private Set<Server> servers;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean isWithSudo() {
        return withSudo;
    }

    public void setWithSudo(boolean withSudo) {
        this.withSudo = withSudo;
    }

    public SshUser getSshUser() {
        return sshUser;
    }

    public void setSshUser(SshUser sshUser) {
        this.sshUser = sshUser;
    }

    public Set<Server> getServers() {
        return servers;
    }

    public void setServers(Set<Server> servers) {
        this.servers = servers;
    }
}