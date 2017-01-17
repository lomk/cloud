package net.elyland.cloud.libvirt;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.domain.VirtualMachineAction;
import org.libvirt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by imaterynko on 13.01.17.
 */
@Component()
public class VMservice {
    VirtualMachine virtualMachine;
    private Connect connect;
    private Domain domain;
    private Hypervisor hypervisor;
    private VirtualMachineAction virtualMachineAction;

    public void setConnect(){

        ConnectAuth auth = new ConnectAuthDefault();
        String conntype = String.format("qemu+ssh://imaterynko@%s/system", this.hypervisor.getExternalIPAdress());
        Connect conn = null;
        try {
            conn = new Connect(conntype, auth, 0);
        } catch (LibvirtException e) {
            e.printStackTrace();
        }

        this.connect = conn;
    }

    public VirtualMachine getVirtualMachine() {
        return virtualMachine;
    }

    public void setVirtualMachine(VirtualMachine virtualMachine) {
        this.virtualMachine = virtualMachine;
    }

    public Connect getConnect() {
        return connect;
    }

    public void setConnect(Connect connect) {
        this.connect = connect;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Hypervisor getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(Hypervisor hypervisor) {
        this.hypervisor = hypervisor;
    }

    public void act(){
        if (virtualMachineAction.getName().contains("create")){
            this.create();
        } else if (virtualMachineAction.getName().contains("shutdown")){
            this.shutdown();
        } else if (virtualMachineAction.getName().contains("reboot")){
            this.reboot();
        } else {

        }

    }
    public String getVmStatus(VirtualMachine virtualMachine){
        String status = null;
        this.hypervisor = virtualMachine.getHypervisor();
        this.setConnect();
        try {
            this.setDomain(connect.domainLookupByName(virtualMachine.getHostname()));
            if (domain.isActive() == 0){
                status = "down";
            }
            if (domain.isActive() == 1){
                status = "up";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public void create(){
        this.hypervisor = virtualMachine.getHypervisor();
        this.setConnect();
        try {
            this.setDomain(connect.domainLookupByName(virtualMachine.getHostname()));
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
        try {
            this.domain.create();
        } catch (LibvirtException e) {
            e.printStackTrace();
        }

    }
    public void shutdown(){
        this.hypervisor = virtualMachine.getHypervisor();
        this.setConnect();
        try {
            this.setDomain(connect.domainLookupByName(virtualMachine.getHostname()));
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
        try {
            this.domain.shutdown();
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
    }
    public void reboot(){
        this.hypervisor = virtualMachine.getHypervisor();
        this.setConnect();
        try {
            this.setDomain(connect.domainLookupByName(virtualMachine.getHostname()));
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
        try {
            this.domain.reboot(1);
        } catch (LibvirtException e) {
            e.printStackTrace();
        }
    }

    public VirtualMachineAction getVirtualMachineAction() {
        return virtualMachineAction;
    }

    public void setVirtualMachineAction(VirtualMachineAction virtualMachineAction) {
        this.virtualMachineAction = virtualMachineAction;
    }
}
