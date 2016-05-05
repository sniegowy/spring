package pl.snowball.service;

import java.util.List;

import pl.snowball.model.ScheduleTile;

public interface ScheduleTileService {
	
	void saveScheduleTime(ScheduleTile scheduleTime);
	
	void deleteScheduleTime(ScheduleTile scheduleTile);
	
	List<ScheduleTile> findUsersScheduleTime(Long userId);
	
	String findSelectedCells(Long userId, boolean highlightFirstCell);
	
	ScheduleTile findScheduleTile(Long userId, String cellName);
	
}
