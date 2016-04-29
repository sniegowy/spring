package pl.snowball.service;

import java.util.List;

import pl.snowball.model.ScheduleTime;

public interface ScheduleTimeService {
	
	void saveScheduleTime(ScheduleTime scheduleTime);
	
	List<ScheduleTime> findUsersScheduleTime(Long userId);
	
}
