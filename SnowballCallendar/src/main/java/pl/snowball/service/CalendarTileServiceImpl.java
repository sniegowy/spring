package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.CalendarTileDao;
import pl.snowball.enums.DayOfWeek;
import pl.snowball.model.CalendarTile;
import pl.snowball.model.ScheduleTile;

@Service("calendarTileService")
@Transactional
public class CalendarTileServiceImpl implements CalendarTileService {

	@Autowired
	private CalendarTileDao dao;

	public CalendarTile fillNewTileData(Long userId, String startCellId, String endCellId) {
		//return (CalendarTile) scheduleTileService.fillNewTileData(userId, startCellId, endCellId);
		String[] startCellStrings = startCellId.split("_");
		String[] endCellStrings = endCellId.split("_");
		CalendarTile tile = new CalendarTile();
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
	
	public String findSelectedCells(Long userId, boolean highlightFirstCell) {
		List<CalendarTile> list = this.findUserCalendarTiles(userId);
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

	public void saveCalendarTile(CalendarTile tile) {
		dao.saveCalendarTile(tile);
	}
	
	public List<CalendarTile> findUserCalendarTiles(Long userId) {
		return dao.findUserCalendarTiles(userId);
	}
}
