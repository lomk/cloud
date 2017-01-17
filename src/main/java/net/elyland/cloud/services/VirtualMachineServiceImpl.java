package net.elyland.cloud.services;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.domain.VirtualMachineState;
import net.elyland.cloud.repositories.VirtualMachineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Igor on 20-Jul-16.
 */
@Service
public class VirtualMachineServiceImpl implements VirtualMachineService {

    @Autowired
    private VirtualMachineRepository virtualMachineRepository;

    @Override
    public Iterable<VirtualMachine> listAllVirtualMachines() {
        return virtualMachineRepository.findAll();
    }

    @Override
    public VirtualMachine getVirtualMachineById(Integer id) {
        return virtualMachineRepository.findOne(id);
    }

    @Override
    public VirtualMachine getVirtualMachineByHostname(String hostname) {
        return virtualMachineRepository.findByHostname(hostname);

    }

    @Override
    public void save(VirtualMachine virtualMachine) {
        virtualMachineRepository.save(virtualMachine);

    }

    @Override
    public void deleteVirtualMachine(Integer id) {
        virtualMachineRepository.delete(id);
    }

    @Override
    public Iterable<VirtualMachine> findByHypervisor(Hypervisor hypervisor) {
        return virtualMachineRepository.findByHypervisor(hypervisor.getId());
    }

    /*@Override
    public List<VirtualMachine> findByVirtualMachineState(VirtualMachineState virtualMachineState) {
        return virtualMachineRepository.findByVirtualMachineState(virtualMachineState.getId());
    }*/

}
