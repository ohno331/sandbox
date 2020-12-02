package jp.ac.o_hara.site.calendar;

import java.io.Serializable;
import java.sql.Date;

public class CalendarEntry implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date date = null;
	
	public CalendarEntry() {}
	public CalendarEntry(Date date) {
		this.setDate(date);
	}
	
	public void setDate(Date date) { this.date = date;}
	public Date getDate() { return this.date; }

	public String getFormat(int date) {
		if (this.getDate()!=null) {
			return "<td class='warning'><a href='./CalendarEntry?date="
					+this.getDate().toString()+"'>"+date+"</a></td>";
		}
		return "<td>"+String.valueOf(date)+"</td>";
	}
}
