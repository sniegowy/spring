package pl.snowball.service;

import java.util.Set;

import pl.snowball.model.EventType;

public interface AdminService {
	
	Set<EventType> findAllEventTypes();
	
	void deleteEventType(Long eventId);
	
	void addEventType(EventType eventType);
}
