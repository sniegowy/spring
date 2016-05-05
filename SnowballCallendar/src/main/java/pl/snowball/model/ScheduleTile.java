package pl.snowball.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "schedule_time")
public class ScheduleTile extends Tile {
	
	public ScheduleTile(){}

	public ScheduleTile(Long userId, String startCellId, String endCellId) {
		super(userId, startCellId, endCellId);
	}

}
