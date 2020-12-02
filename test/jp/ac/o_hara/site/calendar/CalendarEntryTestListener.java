package jp.ac.o_hara.site.calendar;

import java.sql.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class CalendarEntryTestListener
 *
 */
@WebListener
public class CalendarEntryTestListener implements ServletContextListener {
	CalendarDAO dao = null;
    /**
     * Default constructor. 
     */
    public CalendarEntryTestListener() {
    	dao = new CalendarDAO();
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
    	if(dao.execSQL("CREATE TABLE IF NOT EXISTS calentry (id IDENTITY, date DATE, userID VARCHAR(64), moduleName VARCHAR(32))")) {
    		dao.create(new CalendarBean(Date.valueOf("2020-12-19"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-01"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-01"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-01"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-23"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-23"), "hoge", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-23"), "all", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-23"), "all", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-24"), "all", "Dummy"));
    		dao.create(new CalendarBean(Date.valueOf("2020-12-31"), "hoge", "Dummy"));
    		System.out.println("TestCalDB is READY.");
    	} else {
    		System.out.println("TestCalDB is NOT READY.");
    	}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
    	if(dao.execSQL("DROP TABLE calentry")) {
    		System.out.println("TestCalDB is DROPPED.");
    	} else {
    		System.out.println("TestCalDB is NOT DROPPED.");
    	}
    	dao = null;
    }
	
}
