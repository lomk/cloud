package net.elyland.cloud.controllers;

import net.elyland.cloud.domain.VirtualMachine;
import net.elyland.cloud.domain.VirtualMachineAction;
import net.elyland.cloud.libvirt.LibvirtService;
import net.elyland.cloud.libvirt.VMservice;
import net.elyland.cloud.services.HypervisorService;
import net.elyland.cloud.services.VirtualMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin/vm")
public class AdminVirtualMachineController {

    @Autowired
    VirtualMachineService virtualMachineService;
    @Autowired
    HypervisorService hypervisorService;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String VirtualMachineList(Model model) {
        LibvirtService libvirtService = new LibvirtService();
        libvirtService.setHypervisor(hypervisorService.getHypervisorById(1));
        libvirtService.setDomains(virtualMachineService);
        model.addAttribute("virtualMachines", virtualMachineService.listAllVirtualMachines());
        return "admin/vm/all";
    }

    @RequestMapping("edit/{id}")
    public String VirtualMachineEdit(@PathVariable Integer id, Model model){
        model.addAttribute("VirtualMachine", virtualMachineService.getVirtualMachineById(id));
        return "admin/VirtualMachineform";
    }

    @RequestMapping("new")
    public String newVirtualMachine(Model model){
        model.addAttribute("VirtualMachine", new VirtualMachine());
        return "admin/newVirtualMachine";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String showVirtualMachine(@PathVariable Integer id, Model model){
        VirtualMachine vm = virtualMachineService.getVirtualMachineById(id);
        VMservice vMservice = new VMservice();
        String vmstatus = vMservice.getVmStatus(vm);
        if (vMservice.getVmStatus(vm) != vm.getState()){
            vm.setState(vmstatus);
            virtualMachineService.save(vm);
        }
        String[] actions = new String[] {"create", "shutdown", "reboot"};
        model.addAttribute("virtualmachine", vm);
        model.addAttribute("hypervisor", vm.getHypervisor());
        model.addAttribute("actions", actions);
        model.addAttribute("action", new VirtualMachineAction());
        //model.addAttribute("uniqueattribute", new UniqueAttribute());
        return "admin/vm/show";
    }
    @RequestMapping(value = "act/{id}", method = RequestMethod.POST)
    public String actVirtualMachine(@PathVariable Integer id,
                                    @ModelAttribute("action") VirtualMachineAction virtualMachineAction,
                                    Model model){
        VirtualMachine virtualMachine = virtualMachineService.getVirtualMachineById(id);
        try {

            virtualMachineAction.getName();
            VMservice vMservice = new VMservice();
            vMservice.setVirtualMachine(virtualMachine);
            vMservice.setVirtualMachineAction(virtualMachineAction);
            vMservice.act();
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect:/admin/vm/" + virtualMachine.getId();
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveVirtualMachine(VirtualMachine virtualMachine){
        virtualMachineService.save(virtualMachine);
        return "redirect:/admin/VirtualMachine/" + virtualMachine.getId();
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable Integer id){
        virtualMachineService.deleteVirtualMachine(id);
        return "redirect:/admin/VirtualMachine/all";
    }
}
