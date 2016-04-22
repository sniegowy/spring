package pl.snowball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pl.snowball.model.LoginCredentials;

@Controller
@SessionAttributes("loginCredentials")
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(Model model) {
		LoginCredentials loginCredentials = new LoginCredentials();
		model.addAttribute("loginCredentials", loginCredentials);
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String afterLogin(@ModelAttribute("loginCredentials") LoginCredentials loginCredentials) {
		System.out.println("Login: " + loginCredentials.getLogin() + " Haslo: " + loginCredentials.getPassword());
		return "redirect:greeting.html";
	}
}
