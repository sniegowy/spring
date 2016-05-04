package pl.snowball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.CalendarTile;

@Repository("calendarTileDao")
public class CalendarTileDaoImpl extends AbstractDao<Long, CalendarTile> implements CalendarTileDao  {

	public void saveCalendarTile(CalendarTile tile) {
		saveOrUpdate(tile);
	}

	@SuppressWarnings("unchecked")
	public List<CalendarTile> findUserCalendarTiles(Long userId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		return (List<CalendarTile>) criteria.list();
	}

}
