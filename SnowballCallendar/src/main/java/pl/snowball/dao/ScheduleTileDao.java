package pl.snowball.dao;

import java.util.List;

import pl.snowball.enums.DayOfWeek;
import pl.snowball.model.ScheduleTile;

public interface ScheduleTileDao {

	void saveScheduleTime(ScheduleTile scheduleTime);

	List<ScheduleTile> findUsersScheduleTime(Long userId);

	void deleteScheduleTime(ScheduleTile scheduleTile);

	ScheduleTile findScheduleTile(Long userId, int hour, DayOfWeek dayOfWeek);
}
