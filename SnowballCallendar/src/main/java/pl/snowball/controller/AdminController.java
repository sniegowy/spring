package pl.snowball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping(value = "/admin", method=RequestMethod.GET)
    public String adminPage(Model model) {
        return "admin/admin";
    }
}
