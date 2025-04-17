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
@WebServlet("/deposit")
public class DepositServelet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			req.setAttribute("msg", "Session Log Out");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			long accno = Long.parseLong(req.getParameter("accountNumber"));
			double amnt = Double.parseDouble(req.getParameter("amount"));

			String msg = new DepositDAO().depositAmount(accno, amnt);
			req.setAttribute("result", msg);
			req.getRequestDispatcher("depositBalance.jsp").forward(req, res);
		}

	}

}
