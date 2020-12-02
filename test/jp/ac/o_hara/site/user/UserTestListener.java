package jp.ac.o_hara.site.user;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class UserListener
 *
 */
@WebListener
public class UserTestListener implements ServletContextListener {
	UserDAO dao = null;

    /**
     * Default constructor. 
     */
    public UserTestListener() {
    	dao = UserDAO.getInstance();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	dao = null;
    	System.out.println("SystemStop..");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	if(dao.execSQL("CREATE TABLE IF NOT EXISTS user" 
    			+ " (id IDENTITY, realName VARCHAR(64), userID VARCHAR(64), passwd VARCHAR(64))")) {
    		dao.create(new UserBean("管理者", "admin", "adminpass"));
    		dao.create(new UserBean("hogehoge", "hoge", "hogepass"));
    		dao.create(new UserBean("piyopiyo", "piyo", "piyopass"));
    		System.out.println("TestUserDB is READY.");
    	} else {
    		System.out.println("TestUserDB is NOT READY.");
    	}
    	
    	System.out.println("SystemStart..");
    }
	
}
