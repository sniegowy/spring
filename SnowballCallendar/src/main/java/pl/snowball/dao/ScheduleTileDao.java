package pl.snowball.dao;

import java.util.List;

import pl.snowball.model.ScheduleTile;

public interface ScheduleTileDao {

	void saveScheduleTime(ScheduleTile scheduleTime);

	List<ScheduleTile> findUsersScheduleTime(Long userId);

	void deleteScheduleTime(ScheduleTile scheduleTile);

}
