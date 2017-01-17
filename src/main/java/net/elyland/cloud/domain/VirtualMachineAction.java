package net.elyland.cloud.domain;

import javax.persistence.*;

/**
 * Created by imaterynko on 13.01.17.
 */

public class VirtualMachineAction {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
