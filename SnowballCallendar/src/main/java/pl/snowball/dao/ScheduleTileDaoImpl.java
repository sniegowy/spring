package pl.snowball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.ScheduleTile;

@Repository("scheduleTileDao")
public class ScheduleTileDaoImpl extends AbstractDao<Long, ScheduleTile> implements ScheduleTileDao {

	public void saveScheduleTime(ScheduleTile scheduleTime) {
		saveOrUpdate(scheduleTime);
	}

	@SuppressWarnings("unchecked")
	public List<ScheduleTile> findUsersScheduleTime(Long userId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		return (List<ScheduleTile>) criteria.list();
	}

	public void deleteScheduleTime(ScheduleTile scheduleTile) {
        delete(scheduleTile);
	}
}
