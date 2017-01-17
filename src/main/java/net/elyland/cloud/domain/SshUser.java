package net.elyland.cloud.domain;

import javax.persistence.*;

/**
 * Created by imaterynko on 17.01.17.
 */
@Entity
@Table(name = "ssh_user")
public class SshUser {

    private static final long serialVersionUID = -1000119078147222958L;

    @Id
    @Column(name = "ssh_user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "ssh_key")
    private String sshKey;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSshKey() {
        return sshKey;
    }

    public void setSshKey(String sshKey) {
        this.sshKey = sshKey;
    }

}
