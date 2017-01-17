package net.elyland.cloud.libvirt;

import org.libvirt.Domain;

/**
 * Created by imaterynko on 13.01.17.
 */
public class HVService {
    Domain domain;


    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }
}
