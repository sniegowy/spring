package pl.snowball.service;

import pl.snowball.model.CalendarTile;

public interface CalendarTileService {

	void saveCalendarTile(CalendarTile tile);
	
	String findSelectedCells(Long userId, boolean highlightFirstCell);
	
}
