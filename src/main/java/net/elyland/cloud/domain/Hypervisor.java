package net.elyland.cloud.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by imaterynko on 12.01.17.
 */
@Entity
@Table(name = "hypervisor")
public class Hypervisor {

    @Id
    @Column(name = "hypervisor_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "hostname", nullable = false, length = 30)
    private String hostname;

    @Column(name = "state", nullable = true, length = 30)
    private String state;

    @Column(name = "externalIP", nullable = false, length = 20)
    private String externalIPAdress;

    @Column(name = "cloudIP", nullable = false, length = 20)
    private String cloudIPAdress;

    @Column(name = "hvIP", nullable = false, length = 20)
    private String hvIPAdress;

//    @OneToMany(mappedBy = "hypervisor", targetEntity = VirtualMachine.class)
    @OneToMany(mappedBy = "hypervisor")
    private Set<VirtualMachine> virtualMachines;

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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getExternalIPAdress() {
        return externalIPAdress;
    }

    public void setExternalIPAdress(String externalIPAdress) {
        this.externalIPAdress = externalIPAdress;
    }

    public String getCloudIPAdress() {
        return cloudIPAdress;
    }

    public void setCloudIPAdress(String cloudIPAdress) {
        this.cloudIPAdress = cloudIPAdress;
    }

    public String getHvIPAdress() {
        return hvIPAdress;
    }

    public void setHvIPAdress(String hvIPAdress) {
        this.hvIPAdress = hvIPAdress;
    }

    public Set<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(Set<VirtualMachine> virtualMachines) {
        this.virtualMachines = virtualMachines;
    }
}
