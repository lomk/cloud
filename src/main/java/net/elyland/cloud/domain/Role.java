package net.elyland.cloud.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Igor on 29-Jun-16.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
    private static final long serialVersionUID = -1200119078147252957L;

    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
