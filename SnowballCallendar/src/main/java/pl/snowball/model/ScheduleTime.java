package pl.snowball.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import pl.snowball.enums.WeekDay;

@Entity
@Table(name="schedule_time")
public class ScheduleTime {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long userId;
	
	@Column
	private WeekDay weekDay;
	
	@Column
	private int startHour;
	
	@Column
	private int startMinute = 0;
	
	@Column
	private int endHour;
	
	@Column
	private int endMinute = 0;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public WeekDay getWeekDay() {
		return weekDay;
	}
	public void setWeekDay(WeekDay weekDay) {
		this.weekDay = weekDay;
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
}
