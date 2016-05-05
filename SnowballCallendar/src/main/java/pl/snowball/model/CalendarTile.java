package pl.snowball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "calendar_tile")
public class CalendarTile extends Tile {
	
	public CalendarTile() {	}

	public CalendarTile(Long userId, String startCellId, String endCellId) {
		super(userId, startCellId, endCellId);
	}

	@Column
	private Long type;

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}
	
}

