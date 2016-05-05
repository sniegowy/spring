package pl.snowball.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "calendar_tile")
public class CalendarTile extends Tile {

	@ManyToOne(cascade = CascadeType.ALL)
	private EventType eventType;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Customer customer;

	public CalendarTile() {	}

	public CalendarTile(Long userId, String startCellId, String endCellId) {
		super(userId, startCellId, endCellId);
	}
	
	public EventType getEventType() {
		return eventType;
	}

	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}

