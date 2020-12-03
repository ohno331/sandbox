package jp.ac.o_hara.site.dummy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.o_hara.site.ContentBean;

/**
 * Servlet implementation class DummyServlet
 */
@WebServlet("/dummy")
public class DummyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ContentBean content =  new ContentBean();

		req.removeAttribute("content"); // 既存のcontentを消去
		req.setAttribute("content", content);
		req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
	}
}
