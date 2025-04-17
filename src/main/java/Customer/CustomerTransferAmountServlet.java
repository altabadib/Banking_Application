package Customer;

import java.io.IOException;

import Admin.TransferDAO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerTransferAmount")
public class CustomerTransferAmountServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("cmsg.jsp").forward(req, resp);
		}
		else {
			long fromAccount=Long.parseLong(req.getParameter("fromAccount"));
			long toAccount = Long.parseLong(req.getParameter("toAccount"));
			double amnt=Double.parseDouble(req.getParameter("amount"));
			 
			String tranferMsg = new CustomerTransferAmountDAO().tranfer(fromAccount, toAccount, amnt);
			req.setAttribute("transfer", tranferMsg);
			RequestDispatcher rd = req.getRequestDispatcher("cutomerTransferAmount.jsp");
			rd.forward(req, resp);
		}
		
	}
}
