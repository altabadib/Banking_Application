package customerLogout;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/customerLogout")
public class CustomerLogoutServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		HttpSession session = req.getSession(false);
		
		if(session==null) {
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("cmsg.jsp").forward(req, resp);
		}
		else {
		session.invalidate();
		req.setAttribute("msg", "Log Out Succesfully");
		req.getRequestDispatcher("logoutcustomer.jsp").forward(req, resp);
		}
		
	}
	
}
