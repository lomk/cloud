package net.elyland.cloud.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by imaterynko on 12.01.17.
 */
@Entity
@Table(name = "virtual_machine")
public class VirtualMachine {

    @Id
    @Column(name = "virtual_machine_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hostname", nullable = true, length = 30)
    private String hostname;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    @Column(name = "cloudIP", nullable = true, length = 20)
    private String cloudipAdress;

    @Column(name = "hvIP", nullable = true, length = 20)
    private String ipAdress;

    @ManyToOne
    @JoinColumn(name = "hypervisor_id")
    private Hypervisor hypervisor;


   /* @ManyToOne
    @JoinColumn(name = "virtual_machine_state_id")
    private VirtualMachineState virtualMachineState;*/


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

/*    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }*/

    public String getCloudipAdress() {
        return cloudipAdress;
    }

    public void setCloudipAdress(String cloudipAdress) {
        this.cloudipAdress = cloudipAdress;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    public Hypervisor getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(Hypervisor hypervisor) {
        this.hypervisor = hypervisor;
    }

 /*   public VirtualMachineState getVirtualMachineState() {
        return virtualMachineState;
    }

    public void setVirtualMachineState(VirtualMachineState virtualMachineState) {
        this.virtualMachineState = virtualMachineState;
    }*/

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
