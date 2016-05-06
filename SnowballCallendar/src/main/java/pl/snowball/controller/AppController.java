package pl.snowball.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	@RequestMapping(value= {"/"}, method=RequestMethod.GET)
	public String login(Model model) {
		return "index";
	}

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String accessDeniedPage(Model model) {
        return "accessDenied";
    }
    
    @RequestMapping(value = "/common/success-returnUrl-'{returnUrl}", method = RequestMethod.GET)
    public String successPage(Model model, @PathVariable("returnUrl") String returnUrl) {
        return "common/success";
    }
}
