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
    	StringBuilder result = new StringBuilder();
    	result.append("0_0");
    	for (ScheduleTile tile : list) {
    		int i = tile.getStartHour();
    		if (highlightFirstCell) {
	    		result.append(";firstCell,");
	    		result.append(tile.getTimeStr());
	    		result.append(",");
				result.append(tile.getStartHour());
				result.append("_");
				result.append(tile.getDayOfWeek().ordinal() + 1);
				i++;
    		}
    		while (i < tile.getEndHour()) {
    			result.append(";");
    			result.append(i);
    			result.append("_");
    			result.append(tile.getDayOfWeek().ordinal() + 1);
    			i++;
    		}
    	}
    	return result.toString();
	}

	public ScheduleTile fillNewTileData(Long userId, String startCellId, String endCellId) {
		String[] startCellStrings = startCellId.split("_");
		String[] endCellStrings = endCellId.split("_");
		ScheduleTile tile = new ScheduleTile();
		tile.setDayOfWeek(DayOfWeek.values()[Integer.parseInt(startCellStrings[2])-1]);
		tile.setStartHour(Integer.parseInt(startCellStrings[1]));
		tile.setEndHour(Integer.parseInt(endCellStrings[1])+1);
		if (tile.getStartHour() > tile.getEndHour()) {
			int hour = tile.getStartHour();
			tile.setStartHour(tile.getEndHour());
			tile.setEndHour(hour);
		}
		tile.setUserId(userId);
		return tile;
	}

	public ScheduleTile findScheduleTile(Long userId, String cellName) {
		ScheduleTile resultTile = null;
		String[] cellArray = cellName.split("_");
		int hour = Integer.parseInt(cellArray[1]);
		DayOfWeek dayOfWeek = DayOfWeek.values()[Integer.parseInt(cellArray[2]) - 1];
		List<ScheduleTile> list = this.findUsersScheduleTime(userId);
		for (ScheduleTile tile : list) {
			if (tile.getDayOfWeek().equals(dayOfWeek)) {
				if (hour >= tile.getStartHour() && hour <= tile.getEndHour()) {
					resultTile = tile;
				}
			}
		}
		return resultTile;
	}
}
