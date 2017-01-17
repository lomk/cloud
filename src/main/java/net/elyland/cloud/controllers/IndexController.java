package net.elyland.cloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Igor on 09-Jun-16.
 */
@Controller
public class IndexController {
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public ModelAndView welcomePage() {
        return new ModelAndView("redirect:/admin");
    }
}
