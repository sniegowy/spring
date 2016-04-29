package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.ScheduleTimeDao;
import pl.snowball.model.ScheduleTime;

@Service("scheduleTimeService")
@Transactional
public class ScheduleTimeServiceImpl implements ScheduleTimeService {
	
	@Autowired
	private ScheduleTimeDao dao;

	public void saveScheduleTime(ScheduleTime scheduleTime) {
		dao.saveScheduleTime(scheduleTime);
	}

	public List<ScheduleTime> findUsersScheduleTime(Long userId) {
		return dao.findUsersScheduleTime(userId);
	}

}
