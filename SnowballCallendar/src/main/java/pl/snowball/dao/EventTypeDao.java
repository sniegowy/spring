package pl.snowball.dao;

import java.util.Set;

import pl.snowball.model.EventType;

public interface EventTypeDao {

	Set<EventType> findAllEventTypes();

	void deleteEventType(Long eventId);

	void addEventType(EventType eventType);

}
