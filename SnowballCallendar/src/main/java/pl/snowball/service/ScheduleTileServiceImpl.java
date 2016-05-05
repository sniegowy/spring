package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.ScheduleTileDao;
import pl.snowball.enums.DayOfWeek;
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

	public String findSelectedCells(Long userId, boolean highlightFirstCell) {
		List<ScheduleTile> list = this.findUsersScheduleTime(userId);
    	String result = "0_0";
    	for (ScheduleTile tile : list) {
    		result += appendFirstCell(tile, highlightFirstCell);
    		for (int i = tile.getStartHour() + 1; i <tile.getEndHour(); i++) {
    			result += ";" + tile.getCellId(i);
    		}
    	}
    	return result;
	}
	
	private String appendFirstCell(ScheduleTile tile, boolean highlightFirstCell) {
		if (highlightFirstCell) {
			return ";firstCell," + tile.getDisplayTime() + "," + tile.getStartCellId();
		} else {
			return ";" + tile.getCellId(tile.getStartHour());
		}
	}
	
	public ScheduleTile findScheduleTile(Long userId, String cellName) {
		String[] cellArray = cellName.split("_");
		int hour = Integer.parseInt(cellArray[1]);
		DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(cellArray[2]) - 1];
		return dao.findScheduleTile(userId, hour, dayOfWeek);
	}
}
