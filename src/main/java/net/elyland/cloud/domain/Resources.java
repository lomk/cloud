package net.elyland.cloud.domain;

import javax.persistence.*;

/**
 * Created by imaterynko on 12.01.17.
 */
@Entity
@Table(name = "resources")
public class Resources {
    @Id
    @Column(name = "resourses_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
