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

import pl.snowball.model.EventType;
import pl.snowball.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;

	@RequestMapping(value = "/eventTypes", method=RequestMethod.GET)
    public String findEventTypes(Model model) {
		Set<EventType> eventTypes = adminService.findAllEventTypes();
		model.addAttribute("eventTypes", eventTypes);
        return "admin/eventTypes";
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
