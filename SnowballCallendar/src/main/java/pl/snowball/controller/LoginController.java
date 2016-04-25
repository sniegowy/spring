package pl.snowball.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.snowball.model.LoginCredentials;
import pl.snowball.model.User;
import pl.snowball.service.UserService;

@Controller
@SessionAttributes("loginCredentials")
public class LoginController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		LoginCredentials loginCredentials = new LoginCredentials();
		model.addAttribute("loginCredentials", loginCredentials);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String afterLogin(@Valid @ModelAttribute("loginCredentials") LoginCredentials loginCredentials,
			BindingResult result) {
		if (result.hasErrors()) {
			return "login";
		}
		User user = userService.login(loginCredentials);
		if (user == null) {
			return "login";
		}
		return "redirect:/user/usersTable.html";
	}
}
