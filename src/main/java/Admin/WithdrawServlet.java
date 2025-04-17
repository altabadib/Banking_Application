package Admin;

import java.io.IOException;
import java.net.http.HttpResponse;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session == null) {
			req.setAttribute("msg", "Session Log Out.");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		} else {
			long accno = Long.parseLong(req.getParameter("accountNumber"));
			double amnt = Double.parseDouble(req.getParameter("amount"));

			String str = new WithdrawDAO().withdraw(accno, amnt);
			req.setAttribute("msg", str);
			req.getRequestDispatcher("Withdraw.jsp").forward(req, res);
		}
	}

}
