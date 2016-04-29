package pl.snowball.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.snowball.enums.WeekDay;
import pl.snowball.model.ScheduleTime;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	private ScheduleTime time;
	
	@RequestMapping(value="/user/scheduleResult", method=RequestMethod.GET)
	public String getScheduleData(ModelMap model) {
		return "user/scheduleResult";
	}
	
	@RequestMapping(value="/user/scheduleResult", method={RequestMethod.POST})
	public @ResponseBody String getScheduleResult(@RequestBody String scheduleCell, HttpServletRequest request) {
		JSONObject json = new JSONObject(scheduleCell);
		String startCellId = json.getString("startCell");
		String endCellId = json.getString("stopCell");
		String[] startCellStrings = startCellId.split("_");
		String[] endCellStrings = endCellId.split("_");
		time = new ScheduleTime();
		time.setWeekDay(WeekDay.values()[Integer.parseInt(startCellStrings[2])-1]);
		time.setStartHour(Integer.parseInt(startCellStrings[1]));
		time.setStartMinute(0);
		time.setEndHour(Integer.parseInt(endCellStrings[1]));
		time.setEndMinute(0);
		return "redirect:scheduleAddTime";
	}
	
	@RequestMapping(value="/user/{id}-scheduleAddTime", method=RequestMethod.GET)
	public String addScheduleData(@PathVariable Long id, ModelMap model) {
		model.addAttribute("scheduleTime", time);
		model.addAttribute("weekDays", WeekDay.values());
		model.addAttribute("userId", id);
		return "user/scheduleAddTime";
	}
	
	@RequestMapping(value="/user/{id}-scheduleAddTime", method = RequestMethod.POST)
    public String saveScheduleTime(@Valid ScheduleTime scheduleTime, BindingResult result, ModelMap model, @PathVariable Long id) {

        if (result.hasErrors()) {
            return "user/scheduleAddTime";
        }
 
        
        
        model.addAttribute("success", "Updated successfully");
        return "user/registrationSuccess";
    }
}
