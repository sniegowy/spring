package pl.snowball.controller;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@RequestMapping(value="/user/scheduleResult", method=RequestMethod.GET)
	public String findUsersTable(ModelMap model) {
		return "user/scheduleResult";
	}
	
	@RequestMapping(value="/user/scheduleResult", method={RequestMethod.POST})
	public @ResponseBody String getScheduleResult(@RequestBody String scheduleCell, HttpServletRequest request) {
		JSONObject json = new JSONObject(scheduleCell);
		String cellName = json.getString("cellName");
		boolean isHighlighted = json.getBoolean("isHighlighted");
		return "user/scheduleResult";
	}
}
