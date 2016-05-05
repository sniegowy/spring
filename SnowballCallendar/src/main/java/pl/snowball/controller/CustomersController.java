package pl.snowball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@RequestMapping(value = "/customersTable", method=RequestMethod.GET)
    public String adminPage(Model model) {
        return "customers/customersTable";
    }
}
