package pl.snowball.model;

public class ScheduleCell {
	private String cellName;
	private boolean isHighlighted;
	
	public String getCellName() {
		return cellName;
	}
	public void setCellName(String cellName) {
		this.cellName = cellName;
	}
	public boolean isHighlighted() {
		return isHighlighted;
	}
	public void setHighlighted(boolean isHighlighted) {
		this.isHighlighted = isHighlighted;
	}
}
