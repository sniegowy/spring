package pl.snowball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.snowball.model.User;
import pl.snowball.service.UserService;

@Controller
public class UserTableController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/usersTable", method=RequestMethod.GET)
	public String findUsersTable(ModelMap model) {
		List<User> users = userService.findAllUsers();
		model.addAttribute("usres", users);
		return "usersTable";
	}
}
