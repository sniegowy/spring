package pl.snowball.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.snowball.model.User;
import pl.snowball.service.UserService;

@Controller
@RequestMapping("/user")
public class UserTableController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/usersTable", method=RequestMethod.GET)
	public String findUsersTable(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("users", users);
		return "user/usersTable";
	}

    @RequestMapping(value="/add-user", method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        return "user/registration";
    }
 
    @RequestMapping(value="/add-user", method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "user/registration";
        }
        userService.saveUser(user);
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
        return "user/registrationSuccess";
    }
 
    @RequestMapping(value="/edit-user-{id}", method = RequestMethod.GET)
    public String editUser(@PathVariable Long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "user/registration";
    }
     
    @RequestMapping(value="/edit-user-{id}", method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result, ModelMap model, @PathVariable String id) {

        if (result.hasErrors()) {
            return "user/registration";
        }
 
        userService.updateUser(user);
 
        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        return "user/registrationSuccess";
    }

    @RequestMapping(value="/delete-user-{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "redirect:usersTable";
    }
}
