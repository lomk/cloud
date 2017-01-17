package net.elyland.cloud.libvirt;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.domain.VirtualMachineState;
import net.elyland.cloud.services.VirtualMachineService;
import net.elyland.cloud.services.VirtualMachineServiceImpl;
import org.libvirt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by imaterynko on 12.01.17.
 */
@Component()
public class LibvirtService {
//    @Autowired
    //VirtualMachineService virtualMachineService


    private Connect connect;
    private Domain domain;
    private NodeInfo nodeInfo;
    private Set<Domain> domains;
    private Hypervisor hypervisor;
//    private Set<VirtualMachine> virtualMachines;

    public void setConnect(){

        ConnectAuth auth = new ConnectAuthDefault();
        String conntype = String.format("qemu+ssh://imaterynko@%s/system", hypervisor.getExternalIPAdress());
        Connect conn = null;
        try {
            conn = new Connect(conntype, auth, 0);
        } catch (LibvirtException e) {
            e.printStackTrace();
        }

        this.connect = conn;
    }

    public Connect getConnect(){
            return this.connect;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public NodeInfo getNodeInfo() {
        return nodeInfo;
    }

    public void setNodeInfo(NodeInfo nodeInfo) {
        this.nodeInfo = nodeInfo;
    }

    public Set<Domain> getDomains() {
        return domains;
    }


    public void setDomains(VirtualMachineService virtualMachineService) {
        try {
            this.setConnect();
            String[] defdomains = this.connect.listDefinedDomains();
            int[] actdomains = this.connect.listDomains();
            for (int domain : actdomains){
                Domain dm = this.connect.domainLookupByID(domain);
                System.out.println(domain);
                String name = dm.getName();
                System.out.println(name);
                VirtualMachine vm  = virtualMachineService.getVirtualMachineByHostname(name);
                if ( vm != null){
                    if (vm.getState().contains("down")) {
                        vm.setState("up");
                    }
                } else {
                    vm = new VirtualMachine();
                    vm.setHostname(name);
                    vm.setHypervisor(hypervisor);
                    vm.setState("up");
                }
                virtualMachineService.save(vm);
            }
            for (String domain : defdomains) {
                Domain dm = this.connect.domainLookupByName(domain);
                VirtualMachine vm = virtualMachineService.getVirtualMachineByHostname(domain);
                if ( vm != null){
                    if (vm.getState().contains("up")) {
                        vm.setState("down");
                    }
                } else {
                    vm = new VirtualMachine();
                    vm.setHostname(domain);
                    vm.setHypervisor(hypervisor);
                    vm.setState("down");
                }
                virtualMachineService.save(vm);
//                this.domains.add(dm);
            }
            this.connect.close();
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
    }

    public Hypervisor getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(Hypervisor hypervisor) {
        this.hypervisor = hypervisor;
    }
}
