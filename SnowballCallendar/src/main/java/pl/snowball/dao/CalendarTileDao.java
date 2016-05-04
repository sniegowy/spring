package pl.snowball.dao;

import java.util.List;

import pl.snowball.model.CalendarTile;

public interface CalendarTileDao {

	void saveCalendarTile(CalendarTile tile);

	List<CalendarTile> findUserCalendarTiles(Long userId);
}
