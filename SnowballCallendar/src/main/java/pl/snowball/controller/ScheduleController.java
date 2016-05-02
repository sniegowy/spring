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

import pl.snowball.enums.DayOfWeek;
import pl.snowball.model.ScheduleTile;
import pl.snowball.model.User;
import pl.snowball.service.ScheduleTileService;
import pl.snowball.service.UserService;

@Controller
@RequestMapping("/user")
public class ScheduleController {
	
	@Autowired
	ScheduleTileService scheduleTimeService;
	
	@Autowired
	UserService userService;
	
	ScheduleTile tile;
	
    @RequestMapping(value="/{id}-schedule", method = RequestMethod.GET)
    public String loadSchedule(@PathVariable Long id, ModelMap model) {
    	return loadScheduleInner(id, model);
    }

	private String loadScheduleInner(Long id, ModelMap model) {
		User user = userService.findById(id);
    	model.addAttribute("user", user);
    	model.addAttribute("startHour", 7);
    	model.addAttribute("endHour", 17);
    	model.addAttribute("selectedCells", findSelectedCells(id));
        return "user/schedule";
	}
    
    private String findSelectedCells(Long userId) {
    	List<ScheduleTile> list = scheduleTimeService.findUsersScheduleTime(userId);
    	StringBuilder result = new StringBuilder();
    	result.append("0_0");
    	for (ScheduleTile tile : list) {
    		result.append(";firstCell,");
    		result.append(tile.getTimeStr());
    		result.append(",");
			result.append(tile.getStartHour());
			result.append("_");
			result.append(tile.getDayOfWeek().ordinal() + 1);
    		for (int i = tile.getStartHour() + 1; i < tile.getEndHour(); i++) {
    			result.append(";");
    			result.append(i);
    			result.append("_");
    			result.append(tile.getDayOfWeek().ordinal() + 1);
    		}
    	}
    	return result.toString();
    }
	
	@RequestMapping(value="/{id}-scheduleResult", method=RequestMethod.GET)
	public String getScheduleData(ModelMap model, @PathVariable Long id) {
		return "user/scheduleResult";
	}
	
	@RequestMapping(value="/{id}-scheduleResult", method={RequestMethod.POST})
	public @ResponseBody String getScheduleResult(@RequestBody String scheduleCell, HttpServletRequest request, @PathVariable Long id) {
		JSONObject json = new JSONObject(scheduleCell);
		String startCellId = json.getString("startCell");
		String endCellId = json.getString("stopCell");
		String[] startCellStrings = startCellId.split("_");
		String[] endCellStrings = endCellId.split("_");
		tile = new ScheduleTile();
		tile.setDayOfWeek(DayOfWeek.values()[Integer.parseInt(startCellStrings[2])-1]);
		tile.setStartHour(Integer.parseInt(startCellStrings[1]));
		tile.setEndHour(Integer.parseInt(endCellStrings[1])+1);
		if (tile.getStartHour() > tile.getEndHour()) {
			int hour = tile.getStartHour();
			tile.setStartHour(tile.getEndHour());
			tile.setEndHour(hour);
		}
		tile.setUserId(id);
		return "redirect:scheduleAddTile";
	}
	
	@RequestMapping(value="/{id}-scheduleAddTile", method=RequestMethod.GET)
	public String addScheduleData(@PathVariable Long id, ModelMap model) {
		model.addAttribute("scheduleTime", tile);
		model.addAttribute("daysOfWeek", DayOfWeek.values());
		model.addAttribute("userId", id);
		return "user/scheduleAddTile";
	}
	
	@RequestMapping(value="/{id}-scheduleAddTile", method = RequestMethod.POST)
    public String saveScheduleTime(@Valid ScheduleTile scheduleTime, BindingResult result, ModelMap model, @PathVariable Long id) {
        return saveScheduleTile(scheduleTime, result, model);
    }
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleEdit", method=RequestMethod.GET)
	public String editScheduleTileGet(ModelMap model, @PathVariable("userId") Long userId, @PathVariable("cellName") String cellName) {
		findScheduleTile(userId, cellName);
		if (tile != null) {
			model.addAttribute("scheduleTime", tile);
			model.addAttribute("daysOfWeek", DayOfWeek.values());
			model.addAttribute("userId", userId);
		}
		return "user/scheduleAddTile";
	}

	private void findScheduleTile(Long userId, String cellName) {
		this.tile = null;
		String[] cellArray = cellName.split("_");
		int hour = Integer.parseInt(cellArray[1]);
		DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(cellArray[2]) - 1];
		List<ScheduleTile> list = scheduleTimeService.findUsersScheduleTime(userId);
		for (ScheduleTile tile : list) {
			if (tile.getDayOfWeek().equals(dayOfWeek)) {
				if (hour >= tile.getStartHour() && hour <= tile.getEndHour()) {
					this.tile = tile;
				}
			}
		}
	}
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleEdit", method={RequestMethod.POST})
	public String saveScheduleTileAfterEdit(@Valid ScheduleTile scheduleTime, BindingResult result, ModelMap model) {
		return saveScheduleTile(scheduleTime, result, model);
	}

	private String saveScheduleTile(ScheduleTile scheduleTime, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            return "user/scheduleAddTile";
        }
        scheduleTimeService.saveScheduleTime(scheduleTime);    
        model.addAttribute("success", "Updated successfully");
        return "user/registrationSuccess";
	}
	
	@RequestMapping(value="/{userId}-{cellName}-scheduleDelete", method = RequestMethod.GET)
    public String deleteScheduleTileGet(@PathVariable("userId") Long userId, @PathVariable("cellName") String cellName, ModelMap model) {
		findScheduleTile(userId, cellName);
		scheduleTimeService.deleteScheduleTime(tile);
		return loadScheduleInner(userId, model);
    }
     
    @RequestMapping(value="/{userId}-{cellName}-scheduleDelete", method = RequestMethod.POST)
    public String deleteScheduleTilePost(@Valid User user, BindingResult result, ModelMap model, @PathVariable("userId") Long userId, @PathVariable("cellName") String cellName) {
    	return loadScheduleInner(userId, model);
    }
}
