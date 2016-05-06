package pl.snowball.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.snowball.dao.EventTypeDao;
import pl.snowball.model.EventType;

@Service("adminService")
@Transactional
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private EventTypeDao dao;

	public Set<EventType> findAllEventTypes() {
		return dao.findAllEventTypes();
	}

	public void deleteEventType(Long eventId) {
		dao.deleteEventType(eventId);
	}

	public void addEventType(EventType eventType) {
		dao.addEventType(eventType);
	}

}
