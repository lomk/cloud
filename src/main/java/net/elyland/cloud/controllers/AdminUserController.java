package net.elyland.cloud.controllers;

import net.elyland.cloud.domain.Role;
import net.elyland.cloud.domain.User;
import net.elyland.cloud.services.RoleService;
import net.elyland.cloud.services.UserService;
import net.elyland.cloud.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 * Created by Igor on 18-Jul-16.
 */
@Controller
@RequestMapping("/admin/user")
public class AdminUserController {

    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    UserValidator userValidator;

    @RequestMapping(value = "all", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "users";
    }

    @RequestMapping(value = "{id}", method=RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model, HttpServletResponse response) {
        model.addAttribute("user", userService.getUserById(id));
        return "usershow";
    }

    @RequestMapping("edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("role", user.getRole());
        return "userform";
    }

    @RequestMapping(value = "new", method=RequestMethod.GET)
    public String newUser(Model model){
        ArrayList<Role> roles = new ArrayList<Role>();
        roles.addAll((ArrayList<Role>)roleService.listAllRoles());
        model.addAttribute("userForm", new User());
        model.addAttribute("roles", roles);
        return "newuser";
    }

    @RequestMapping(value = "new", method=RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "newuser";
        }
        userService.save(userForm);
        return "redirect:/admin/users";
    }

    @RequestMapping("user/delete/{id}")
    public String userDelete(@PathVariable Integer id){
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
