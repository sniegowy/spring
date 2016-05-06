package pl.snowball.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import pl.snowball.model.EventType;

@Repository("eventTypeDao")
public class EventTypeDaoImpl extends AbstractDao<Long, EventType> implements EventTypeDao {

	@SuppressWarnings("unchecked")
	public Set<EventType> findAllEventTypes() {
		Criteria criteria = createEntityCriteria();
		return new HashSet<EventType>(criteria.list());
	}

	public void deleteEventType(Long eventId) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", eventId));
        EventType eventType = (EventType)crit.uniqueResult();
        delete(eventType);
	}

	public void addEventType(EventType eventType) {
		persist(eventType);
	}

}
