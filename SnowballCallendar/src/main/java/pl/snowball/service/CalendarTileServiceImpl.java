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
	
	public String findSelectedCells(Long userId) {
		List<CalendarTile> list = this.findUserCalendarTiles(userId);
    	String result = "0_0";
    	for (CalendarTile tile : list) {
    		for (int i = tile.getStartHour(); i <tile.getEndHour(); i++) {
    			result += ";" + tile.getCellId(i);
    		}
    	}
    	return result;
	}

	public void saveCalendarTile(CalendarTile tile) {
		dao.saveCalendarTile(tile);
	}
	
	public List<CalendarTile> findUserCalendarTiles(Long userId) {
		return dao.findUserCalendarTiles(userId);
	}
}
