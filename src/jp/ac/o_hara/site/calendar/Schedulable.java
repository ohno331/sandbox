package jp.ac.o_hara.site.calendar;


public interface Schedulable {
	public String preRenderSchedule();
	public String renderSchedule(CalendarBean bean);
	public String postRenderSchedule();
}
