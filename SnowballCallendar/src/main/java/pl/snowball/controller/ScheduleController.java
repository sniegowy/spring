package pl.snowball.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.snowball.enums.DayOfWeek;
import pl.snowball.model.ScheduleTile;
import pl.snowball.model.User;
import pl.snowball.service.ScheduleTileService;
import pl.snowball.service.UserService;

@Controller
@RequestMapping("/user")
public class ScheduleController {
	
	@Autowired
	ScheduleTileService scheduleTileService;
	
	@Autowired
	UserService userService;
	
	ScheduleTile tile;
	
    @RequestMapping(value="/{userId}-schedule", method = RequestMethod.GET)
    public String loadSchedule(@PathVariable Long userId, ModelMap model) {
    	return reloadSchedule(userId, model);
    }

	private String reloadSchedule(Long userId, ModelMap model) {
		User user = userService.findById(userId);
    	model.addAttribute("user", user);
    	model.addAttribute("startHour", 6);
    	model.addAttribute("endHour", 18);
    	model.addAttribute("selectedCells", scheduleTileService.findSelectedCells(userId, true));
        return "user/schedule";
	}
	
	@RequestMapping(value="/{userId}-{startCellId}-{endCellId}-scheduleAddTile", method=RequestMethod.GET)
	public String prepareAddNewScheduleData(ModelMap model, @PathVariable Long userId, @PathVariable("startCellId") String startCellId, @PathVariable("endCellId") String endCellId) {
		tile = new ScheduleTile(userId, startCellId, endCellId);
		model.addAttribute("scheduleTime", tile);
		model.addAttribute("daysOfWeek", DayOfWeek.values());
		model.addAttribute("userId", userId);
		return "user/scheduleAddTile";
	}
	
	@RequestMapping(value="/{userId}-{startCellId}-{endCellId}-scheduleAddTile", method = RequestMethod.POST)
    public String saveScheduleTime(@Valid ScheduleTile scheduleTime, BindingResult result, ModelMap model) {
        return saveScheduleTile(scheduleTime, result, model);
    }
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleEdit", method=RequestMethod.GET)
	public String prepareScheduleTimeEdit(ModelMap model, @PathVariable("userId") Long userId, @PathVariable("cellName") String cellName) {
		tile = scheduleTileService.findScheduleTile(userId, cellName);
		if (tile != null) {
			model.addAttribute("scheduleTime", tile);
			model.addAttribute("daysOfWeek", DayOfWeek.values());
			model.addAttribute("userId", userId);
		}
		return "user/scheduleAddTile";
	}
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleEdit", method={RequestMethod.POST})
	public String saveScheduleTileAfterEdit(@Valid ScheduleTile scheduleTime, BindingResult result, ModelMap model) {
		return saveScheduleTile(scheduleTime, result, model);
	}

	private String saveScheduleTile(ScheduleTile scheduleTime, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "user/scheduleAddTile";
        }
        scheduleTileService.saveScheduleTime(scheduleTime);    
        model.addAttribute("success", "Updated successfully");
        return "user/registrationSuccess";
	}
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleDelete", method = RequestMethod.GET)
    public String prepareScheduleTileDelete(@PathVariable("userId") Long userId, @PathVariable("cellName") String cellName, ModelMap model) {
		tile = scheduleTileService.findScheduleTile(userId, cellName);
		scheduleTileService.deleteScheduleTime(tile);
		return reloadSchedule(userId, model);
    }
     
    @RequestMapping(value="/{userId}-{cellName}-scheduleDelete", method = RequestMethod.POST)
    public String deleteScheduleTile(@Valid User user, BindingResult result, ModelMap model, @PathVariable("userId") Long userId) {
    	return reloadSchedule(userId, model);
    }
}
