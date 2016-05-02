package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.ScheduleTileDao;
import pl.snowball.model.ScheduleTile;

@Service("scheduleTileService")
@Transactional
public class ScheduleTileServiceImpl implements ScheduleTileService {
	
	@Autowired
	private ScheduleTileDao dao;

	public void saveScheduleTime(ScheduleTile scheduleTime) {
		dao.saveScheduleTime(scheduleTime);
	}

	public List<ScheduleTile> findUsersScheduleTime(Long userId) {
		return dao.findUsersScheduleTime(userId);
	}

	public void deleteScheduleTime(ScheduleTile scheduleTile) {
		dao.deleteScheduleTime(scheduleTile);
	}
}
