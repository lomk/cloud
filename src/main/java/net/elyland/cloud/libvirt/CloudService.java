package net.elyland.cloud.libvirt;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.services.HypervisorService;
import net.elyland.cloud.services.VirtualMachineService;
import org.libvirt.Domain;
import org.libvirt.LibvirtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by imaterynko on 13.01.17.
 */
//@Component
public class CloudService {
    @Autowired
    private LibvirtService libvirtService;
    @Autowired
    VirtualMachineService virtualMachineService;
    @Autowired
    HypervisorService hypervisorService;

    Set<Hypervisor> hypervisors = (Set<Hypervisor>) hypervisorService.listAllHypervisors();
    Set<VirtualMachine> virtualMachines = (Set<VirtualMachine>) virtualMachineService.listAllVirtualMachines();
    Set<Domain> domains;
    //LibvirtService libvirtService = new LibvirtService();

    CloudService(){
        this.setDomains();
    }

    public Set<Hypervisor> getHypervisors() {
        return hypervisors;
    }

    public void setHypervisors(Set<Hypervisor> hypervisors) {
        this.hypervisors = hypervisors;
    }

    public Set<Domain> getDomains() {
        return this.domains;
    }

    public void setDomains() {
        for (Hypervisor hypervisor : hypervisors){
            libvirtService.setHypervisor(hypervisor);
//            libvirtService.setDomains();
        }
        this.domains = libvirtService.getDomains();

    }

    public Set<VirtualMachine> getVirtualMachines() {
        return virtualMachines;
    }

    public void setVirtualMachines(Set<VirtualMachine> virtualMachines) {
        this.virtualMachines = virtualMachines;
    }

    public void checkvms(){
        for (Domain domain : domains){
            try {
                String domainName = domain.getName();
            } catch (LibvirtException e) {
                e.printStackTrace();
            }
        }
    }
}
