package pl.snowball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import pl.snowball.enums.DayOfWeek;

@Entity
@Table(name = "schedule_time")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class ScheduleTile {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Long userId;

	@Column
	private DayOfWeek dayOfWeek;

	@Column
	private int startHour;

	@Column
	private int startMinute = 0;

	@Column
	private int endHour;

	@Column
	private int endMinute = 0;

	public String getTimeStr() {
		return startHour + ":" + minutesToString(startMinute) + " - " + endHour + ":" + minutesToString(endMinute);
	}
	
	private String minutesToString(Integer minutes) {
		if (minutes < 10) {
			return "0" + minutes;
		} else {
			return minutes.toString();
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek weekDay) {
		this.dayOfWeek = weekDay;
	}

	public int getStartHour() {
		return startHour;
	}

	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}

	public int getStartMinute() {
		return startMinute;
	}

	public void setStartMinute(int startMinute) {
		this.startMinute = startMinute;
	}

	public int getEndHour() {
		return endHour;
	}

	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	public int getEndMinute() {
		return endMinute;
	}

	public void setEndMinute(int endMinute) {
		this.endMinute = endMinute;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
