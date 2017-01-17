package net.elyland.cloud.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


/**
 * Created by Igor on 17-Jun-16.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -1000119078147252958L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
//    @Column(name = "password_confirm")
    private String passwordConfirm;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;


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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

}
