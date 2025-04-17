package Customer;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerBalance")
public class CustomerBalanceServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{	
		HttpSession session = req.getSession(false);
		if(session==null) {
			
			req.setAttribute("msg", "Customer Session Expired");
			req.getRequestDispatcher("cmsg.jsp").forward(req, resp);
			
		}else {
    long accno = Long.parseLong(req.getParameter("accno").trim());
	double balance = new CustomerBalanceDAO().getBalance(accno);
	req.setAttribute("balance", balance);
	req.getRequestDispatcher("customerBalance.jsp").forward(req, resp);
		}
		
	}
	
}
