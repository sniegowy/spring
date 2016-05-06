package pl.snowball.controller;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.snowball.model.Customer;
import pl.snowball.model.EventType;
import pl.snowball.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomersController {

	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value = "/customersTable", method=RequestMethod.GET)
    public String adminPage(Model model) {
		Set<Customer> customers = customerService.findAllCustomers();
		model.addAttribute("customers", customers);
        return "customers/customersTable";
    }
	
	@RequestMapping(value="/addEventType", method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        EventType eventType = new EventType();
        model.addAttribute("eventType", eventType);
        return "admin/addEventType";
    }
 
    @RequestMapping(value="/addEventType", method = RequestMethod.POST)
    public String saveUser(@Valid EventType eventType, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "admin/addEventType";
        }
        adminService.addEventType(eventType);
 
        model.addAttribute("success", "Event type " + eventType.getName() + " registered successfully");
        return "admin/addEventTypeSuccess";
    }
}
