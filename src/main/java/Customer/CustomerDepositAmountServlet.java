package Customer;

import java.io.IOException;

import Admin.DepositDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerDepositAmount")
public class CustomerDepositAmountServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg", "Session Expired...");
			req.getRequestDispatcher("cmsg.jsp").forward(req, resp);
		}
		else {
			long accno = Long.parseLong(req.getParameter("accountNumber"));
			double amnt = Double.parseDouble(req.getParameter("amount"));

			String msg = new CustomerDepositAmountDAO().depositAmount(accno, amnt);
			req.setAttribute("result", msg);
			req.getRequestDispatcher("customerDeposit.jsp").forward(req, resp);
		}
	}
	
}
