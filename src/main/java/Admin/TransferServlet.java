 package Admin;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/transfer")
public class TransferServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg", "Session Log Out");
			req.getRequestDispatcher("msg.jsp").forward(req, res);
		}
		else {
		long fromAccount=Long.parseLong(req.getParameter("fromAccount"));
		long toAccount = Long.parseLong(req.getParameter("toAccount"));
		double amnt=Double.parseDouble(req.getParameter("amount"));
		 
		String tranferMsg = TransferDAO.tranfer(fromAccount, toAccount, amnt);
		req.setAttribute("transfer", tranferMsg);
		RequestDispatcher rd = req.getRequestDispatcher("transferAmount.jsp");
		rd.forward(req, res);
		
		}
	}

}
