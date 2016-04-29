package pl.snowball.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.ScheduleTime;

@Repository("scheduleTimeDao")
public class ScheduleTimeDaoImpl extends AbstractDao<Long, ScheduleTime> implements ScheduleTimeDao {

	public void saveScheduleTime(ScheduleTime scheduleTime) {
		persist(scheduleTime);
	}

	@SuppressWarnings("unchecked")
	public List<ScheduleTime> findUsersScheduleTime(Long userId) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("userId", userId));
		return (List<ScheduleTime>) criteria.list();
	}

}
