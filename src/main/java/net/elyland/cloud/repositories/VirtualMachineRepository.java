package net.elyland.cloud.repositories;

import net.elyland.cloud.domain.VirtualMachine;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by imaterynko on 12.01.17.
 */
public interface VirtualMachineRepository extends JpaRepository<VirtualMachine, Integer> {
    List<VirtualMachine> findByHypervisor(Integer hypervisorId);
//    List<VirtualMachine> findByVirtualMachineState(Integer virtualMachineStateId);
    VirtualMachine findByHostname(String hostname);
}
