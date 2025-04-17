package Customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@SuppressWarnings("serial")
@WebServlet("/customerWithdrawAmount")
public class CustomerWithdrawAmountServlet extends HttpServlet
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
			 long accno = Long.parseLong(req.getParameter("accNo").trim());
			 double amnt=Double.parseDouble(req.getParameter("amount").trim());
			 String withdraw = new CustomerWithdrawAmountDAO().withdraw(accno, amnt);
			 req.setAttribute("msg", withdraw);
			 req.getRequestDispatcher("customerWithdraw.jsp").forward(req, resp);
			 
			 
		}
	}
	
}
