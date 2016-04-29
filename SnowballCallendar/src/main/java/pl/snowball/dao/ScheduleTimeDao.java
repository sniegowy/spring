package pl.snowball.dao;

import java.util.List;

import pl.snowball.model.ScheduleTime;

public interface ScheduleTimeDao {

	void saveScheduleTime(ScheduleTime scheduleTime);

	List<ScheduleTime> findUsersScheduleTime(Long userId);

}
