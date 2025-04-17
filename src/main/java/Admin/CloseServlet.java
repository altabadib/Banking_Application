package Admin;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/closeAccount")
public class CloseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
         req.setAttribute("msg", "Session Log Out.");
         req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			long accno = Long.parseLong(req.getParameter("accountNumber"));
			String msg = new CloseDAO().closeAccount(accno);
			req.setAttribute("result", msg);
			req.getRequestDispatcher("Close.jsp").forward(req, res);
		}
	}

}
