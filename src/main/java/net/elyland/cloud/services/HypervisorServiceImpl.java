package net.elyland.cloud.services;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.repositories.HypervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Igor on 07-Jul-16.
 */
@Service
public class HypervisorServiceImpl implements HypervisorService {

    @Autowired
    private HypervisorRepository HypervisorRepository;

    @Override
    public Iterable<Hypervisor> listAllHypervisors() {
        return HypervisorRepository.findAll();
    }

    @Override
    public Hypervisor getHypervisorById(Integer id) {
        return HypervisorRepository.findOne(id);
    }

    @Override
    public void saveHypervisor(Hypervisor hypervisor) {
        HypervisorRepository.save(hypervisor) ;
    }

    @Override
    public void deleteHypervisor(Integer id) {
        HypervisorRepository.delete(id);
    }
}
