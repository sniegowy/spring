package pl.snowball.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
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
import pl.snowball.model.User;
import pl.snowball.service.ScheduleTimeService;
import pl.snowball.service.UserService;

@Controller
@RequestMapping("/")
public class ScheduleController {
	
	@Autowired
	ScheduleTimeService scheduleTimeService;
	
	@Autowired
	UserService userService;
	
	ScheduleTime time;
	
    @RequestMapping(value="/user/{id}-schedule", method = RequestMethod.GET)
    public String loadSchedule(@PathVariable Long id, ModelMap model) {
    	User user = userService.findById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("startHour", 5);
    	model.addAttribute("endHour", 22);
    	model.addAttribute("selectedCells", findSelectedCells(id));
        return "user/schedule";
    }
    
    private String findSelectedCells(Long userId) {
    	List<ScheduleTime> list = scheduleTimeService.findUsersScheduleTime(userId);
    	StringBuilder result = new StringBuilder();
    	result.append("0_0");
    	for (ScheduleTime time : list) {
    		for (int i = time.getStartHour(); i < time.getEndHour(); i++) {
    			result.append(";");
    			result.append(i);
    			result.append("_");
    			result.append(time.getWeekDay().ordinal() + 1);
    		}
    	}
    	return result.toString();
    }
	
	@RequestMapping(value="/user/{id}-scheduleResult", method=RequestMethod.GET)
	public String getScheduleData(ModelMap model, @PathVariable Long id) {
		return "user/scheduleResult";
	}
	
	@RequestMapping(value="/user/{id}-scheduleResult", method={RequestMethod.POST})
	public @ResponseBody String getScheduleResult(@RequestBody String scheduleCell, HttpServletRequest request, @PathVariable Long id) {
		JSONObject json = new JSONObject(scheduleCell);
		String startCellId = json.getString("startCell");
		String endCellId = json.getString("stopCell");
		String[] startCellStrings = startCellId.split("_");
		String[] endCellStrings = endCellId.split("_");
		time = new ScheduleTime();
		time.setWeekDay(WeekDay.values()[Integer.parseInt(startCellStrings[2])-1]);
		time.setStartHour(Integer.parseInt(startCellStrings[1]));
		time.setEndHour(Integer.parseInt(endCellStrings[1])+1);
		if (time.getStartHour() > time.getEndHour()) {
			int hour = time.getStartHour();
			time.setStartHour(time.getEndHour());
			time.setEndHour(hour);
		}
		time.setUserId(id);
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
 
        scheduleTimeService.saveScheduleTime(scheduleTime);
        
        model.addAttribute("success", "Updated successfully");
        return "user/registrationSuccess";
    }
}
