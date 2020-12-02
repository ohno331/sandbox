package jp.ac.o_hara.site.calendar;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

public class CalendarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date _date = null;
	private String _userID = null;
	private String _moduleName = null;
	
	public CalendarBean(){}
	public CalendarBean(Date date, String id, String className) {
		this.setDate(date);
		this.setUserID(id);
		this.setModuleName(className);
	}
	
	public void setDate(Date date) { this._date = date;}
	public Date getDate() { return this._date; }
	public void setUserID(String id) { this._userID = id; }
	public String getUserID() { return this._userID; }
	public void setModuleName(String className) { this._moduleName = className; }
	public String getModuleName(){ return this._moduleName; }
	
	public boolean createEntry() {
		CalendarDAO dao = new CalendarDAO();
		return dao.create(this);
	}
	
	public static ArrayList<CalendarBean> getEntriesOfDate(String userID, java.sql.Date date) {
		return new CalendarDAO().findEntries(userID, date, date);
	}
	
	public static ArrayList<CalendarEntry> getAllEntries(String userId, java.util.Date dateStart, java.util.Date dateEnd) {
		ArrayList<CalendarEntry> list = new ArrayList<CalendarEntry>();
		ArrayList<CalendarBean> in = new CalendarDAO().findEntries(userId, new Date(dateStart.getTime()), new Date(dateEnd.getTime()));
		Calendar cal = Calendar.getInstance();
		
		//System.out.println(in.size());
		cal.setTime(dateStart);
		int nStart = cal.get(Calendar.DAY_OF_MONTH)-1;
		int nEnd;
		for (int i=0; i<in.size(); i++) {
			cal.setTime(in.get(i).getDate());
			nEnd = cal.get(Calendar.DAY_OF_MONTH)-1;
			for (int j=0; j<nEnd-nStart; j++) {
				list.add(new CalendarEntry());
			}
			if (nStart <= nEnd) list.add(new CalendarEntry(in.get(i).getDate()));
			nStart = nEnd+1;
		}
		//System.out.println(list.size());
		cal.setTime(dateEnd);
		nEnd = cal.get(Calendar.DAY_OF_MONTH);
		for (int i=0; i<nEnd-nStart; i++) {
			list.add(new CalendarEntry());
		}
		//System.out.println(list.size());
		
		return list;
	}
}
