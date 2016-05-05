package pl.snowball.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.CalendarTileDao;
import pl.snowball.model.CalendarTile;

@Service("calendarTileService")
@Transactional
public class CalendarTileServiceImpl implements CalendarTileService {

	@Autowired
	private CalendarTileDao dao;
	
	public String findSelectedCells(Long userId, boolean highlightFirstCell) {
		List<CalendarTile> list = this.findUserCalendarTiles(userId);
    	StringBuilder result = new StringBuilder();
    	result.append("0_0");
    	for (CalendarTile tile : list) {
    		int i = tile.getStartHour();
    		if (highlightFirstCell) {
	    		result.append(";firstCell,");
	    		result.append(tile.getDisplayTime());
	    		result.append(",");
				result.append(tile.getCellId());
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
