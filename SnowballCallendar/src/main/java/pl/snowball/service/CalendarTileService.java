package pl.snowball.service;

import pl.snowball.model.CalendarTile;

public interface CalendarTileService {
	
	CalendarTile fillNewTileData(Long userId, String startCellId, String endCellId);

	void saveCalendarTile(CalendarTile tile);
	
	String findSelectedCells(Long userId, boolean highlightFirstCell);
	
}
