package pl.snowball.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.snowball.model.User;
import pl.snowball.service.ScheduleTileService;
import pl.snowball.service.UserService;

@Controller
@RequestMapping("/calendar")
public class CalendarController {

	@Autowired
	UserService userService;
	
	@Autowired
	ScheduleTileService scheduleTileService;
	
	@RequestMapping(value="/calendar", method = RequestMethod.GET)
    public String prepareUserSelect(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("userSelected", false);
        return "calendar/calendar";
    }
 
    @RequestMapping(value="/calendar", method = RequestMethod.POST)
    public String selectUser(@Valid User user, BindingResult result, ModelMap model) {
        return "redirect:" + user.getId() + "-calendar";
    }
    
    @RequestMapping(value="/{userId}-calendar", method = RequestMethod.GET)
    public String findUserSchedule(ModelMap model,  @PathVariable("userId") Long userId) {
        User user = userService.findById(userId);
        model.addAttribute("userSelected", true);
        model.addAttribute("users", userService.findAllUsers());
        model.addAttribute("user", user);
    	model.addAttribute("startHour", 6);
    	model.addAttribute("endHour", 18);
    	model.addAttribute("selectedCells", scheduleTileService.findSelectedCells(userId, false));
        return "calendar/calendar";
    }
 
    @RequestMapping(value="/{userId}-calendar", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
    	return "redirect:" + user.getId() + "-calendar";
    }
}
