package jp.ac.o_hara.site.calendar;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalenderDispServlet
 */
@WebServlet("/showCal")
public class CalenderDispServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int year = Integer.parseInt(req.getParameter("year"));
		int month = Integer.parseInt(req.getParameter("month"));
		
		Calendar c = Calendar.getInstance();
		c.set(year, month-1, 1);
		
		req.setAttribute("cdate", c);
		req.getRequestDispatcher("/WEB-INF/jsp/Calendar/showCal.jsp").forward(req, resp);
	}
}
