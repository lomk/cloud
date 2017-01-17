package net.elyland.cloud.services;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.domain.VirtualMachineState;

import java.util.List;

/**
 * Created by Igor on 20-Jul-16.
 */
public interface VirtualMachineService {
    Iterable<VirtualMachine> listAllVirtualMachines();

    VirtualMachine getVirtualMachineById(Integer id);

    VirtualMachine getVirtualMachineByHostname(String hostname);

    void save(VirtualMachine virtualMachine);

    void deleteVirtualMachine(Integer id);

    Iterable<VirtualMachine> findByHypervisor(Hypervisor hypervisor);

//    List<VirtualMachine> findByVirtualMachineState(VirtualMachineState virtualMachineState);

}
