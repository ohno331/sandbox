package jp.ac.o_hara.site.calendar;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.o_hara.site.ContentBean;
import jp.ac.o_hara.site.user.UserBean;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarEntry")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date date = Date.valueOf((String) request.getParameter("date"));
		UserBean user = (UserBean)request.getSession().getAttribute("user");
		
		ArrayList<CalendarBean> clist = CalendarBean.getEntriesOfDate(user.getUserId(), date);
		request.setAttribute("list", clist);
		ContentBean content = (ContentBean)request.getAttribute("content");
		content.setContent("/WEB-INF/jsp/Calendar/content.jsp");
		request.setAttribute("content", content);
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
