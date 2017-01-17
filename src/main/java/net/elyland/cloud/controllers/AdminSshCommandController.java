package net.elyland.cloud.controllers;

import net.elyland.cloud.domain.SshCommand;
import net.elyland.cloud.ssh.SshExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imaterynko on 16.01.17.
 */
@Controller
@RequestMapping("/admin/sshcommand")
public class AdminSshCommandController {
    @RequestMapping(value = "run", method = RequestMethod.GET)
    public String runCommand(Model model){
        SshCommand sshcommand = new SshCommand();

        model.addAttribute("sshcommand", sshcommand);
        return "admin/sshcommand/run";
    }

    @RequestMapping(value = "run", method = RequestMethod.POST)
    public String executeCommand(@ModelAttribute("sshcommand") SshCommand sshCommand, Model model){
        List<String> result = new ArrayList<String>();
        SshExecutor sshExecutor = new SshExecutor();
        result = sshExecutor.executeCommand(sshCommand.getCommand());
        SshCommand sshcommand = new SshCommand();
        model.addAttribute("sshcommand", sshcommand);
        model.addAttribute("result", result);
        return "admin/sshcommand/run";
    }


}
