package jp.ac.o_hara.site.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		if (req.getParameter("register") != null) { // 新規登録画面へ遷移
			req.getRequestDispatcher("WEB-INF/jsp/User/register.jsp").forward(req, resp);
		} else {
			req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		HttpSession session = req.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		
		if (req.getParameter("login") != null) { // ログインの場合
			if (!user.isAuth()) { // !!重要
				String id = req.getParameter("userId").toString();
				String pass = req.getParameter("userPass").toString();
				if (user.login(id, pass)) { // ログインに成功した場合
					session.setAttribute("user", user);
				}
			}
			//req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
			resp.sendRedirect(req.getHeader("Referer"));
		} else if (req.getParameter("logout") != null) { // ログアウトの場合
			user.logout();
			// session.removeAttribute("user");
			//req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
			resp.sendRedirect(req.getHeader("Referer"));
		} else if (req.getParameter("register") != null) { // 新規登録画面からの遷移
			req.getRequestDispatcher("WEB-INF/jsp/User/register.jsp").forward(req, resp);
		} else if (req.getParameter("confirm") != null) { // 確認画面から遷移
			req.getRequestDispatcher("WEB-INF/jsp/home.jsp").forward(req, resp);
		}
		//req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}
