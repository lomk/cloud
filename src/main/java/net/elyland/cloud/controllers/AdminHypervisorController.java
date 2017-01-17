package net.elyland.cloud.controllers;

import net.elyland.cloud.domain.Hypervisor;
import net.elyland.cloud.services.HypervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admin/hypervisor")
public class AdminHypervisorController {
    @Autowired
    HypervisorService hypervisorService;

    @RequestMapping(value = "all")
    public String hypervisorList(Model model){
        model.addAttribute("hypervisors", hypervisorService.listAllHypervisors());
        return "admin/hypervisor/all";
    }

    @RequestMapping(value = "new")
    public String newHypervisor(Model model){
        model.addAttribute("hypervisor", new Hypervisor());
        return "admin/hypervisor/new";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String saveHypervisor(@ModelAttribute("hypervisor") Hypervisor hypervisor, Model model){


        hypervisorService.saveHypervisor(hypervisor);
        return "redirect:/admin/hypervisor/all/";
    }

    @RequestMapping(value = "edit/{id}")
    public String editHypervisor(@PathVariable Integer id, Model model) {
        model.addAttribute("hypervisor", hypervisorService.getHypervisorById(id));
        return "admin/newhypervisor";
    }

    @RequestMapping(value = "{id}")
    public String showHypervisor(@PathVariable Integer id, Model model){
        return "admin/hypervisor/show";
    }

    @RequestMapping(value = "delete/{id}")
    public String deleteHypervisor(@PathVariable Integer id, Model model){
        return "redirect:/admin/hypervisor/all";
    }
}
