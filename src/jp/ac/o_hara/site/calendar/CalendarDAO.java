package jp.ac.o_hara.site.calendar;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.o_hara.site.SimpleDAO;

public class CalendarDAO extends SimpleDAO {
	boolean create(CalendarBean calender) {
		Connection db = this.createConnection();
		PreparedStatement ps = null;
		boolean result = false;
		try {
			ps = db.prepareStatement("INSERT INTO calentry(date, userID, moduleName) VALUES(? ,?, ?)");
			ps.setDate(1, calender.getDate());
			ps.setString(2, calender.getUserID());
			ps.setString(3, calender.getModuleName());
			ps.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.closeConnection(db);
		}
		return result;
	}
	
	public ArrayList<CalendarBean> findEntries(String userID, Date dateStart, Date dateEnd) {
		ArrayList<CalendarBean> list = new ArrayList<CalendarBean>();
		Connection db = this.createConnection();
		PreparedStatement ps = null;
		try {
			ps = db.prepareStatement("SELECT * FROM calentry WHERE ( userID = ? or userID = 'all' ) and ( date >= ? and date <= ? ) ORDER BY date, moduleName");
			ps.setString(1, userID);
			ps.setDate(2, dateStart);
			ps.setDate(3, dateEnd);
			ResultSet rst = ps.executeQuery();
			while (rst.next()){
				list.add(new CalendarBean(rst.getDate("date"), rst.getString("userID"), rst.getString("moduleName")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) { ps.close(); }
			} catch (SQLException e) {
				e.printStackTrace();
			}
			this.closeConnection(db);
		}
		
		return list;
	}	
}