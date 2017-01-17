package net.elyland.cloud.services;

import net.elyland.cloud.domain.Hypervisor;

/**
 * Created by Igor on 07-Jul-16.
 */
public interface HypervisorService {
    Iterable<Hypervisor> listAllHypervisors();

    Hypervisor getHypervisorById(Integer id);

    void saveHypervisor(Hypervisor hypervisor);

    void deleteHypervisor(Integer id);
}
