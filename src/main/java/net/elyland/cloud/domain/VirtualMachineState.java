package net.elyland.cloud.domain;

import javax.persistence.*;

/**
 * Created by imaterynko on 12.01.17.
 */
@Entity
@Table(name = "virtual_machine_state")
public class VirtualMachineState {
    @Id
    @Column(name = "virtual_machine_state_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "state", nullable = false, length = 30)
    private String state;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
