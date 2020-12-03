package jp.ac.o_hara.site.dummy;

import java.io.Serializable;

import jp.ac.o_hara.site.calendar.CalendarBean;
import jp.ac.o_hara.site.calendar.Schedulable;

public class DummyBean implements Serializable, Schedulable {

	@Override
	public String preRenderSchedule() {
		return "<table class='table table-bordered table-condensed'><tr><th>日時</th><th>ユーザー</th></tr>";
	}

	@Override
	public String renderSchedule(CalendarBean bean) {
		return "<tr><td>"+bean.getDate().toString()+"</td><td>"+bean.getUserID()+"</td></tr>";
	}

	@Override
	public String postRenderSchedule() {
		return "</table>";
	}

}
