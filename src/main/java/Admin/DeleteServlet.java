package Admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Customer.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		if(session==null) {
			req.setAttribute("msg", "Session LogOut.");
			req.getRequestDispatcher("msg.jsp").forward(req, resp);
		}
		else {
			long accno = Long.parseLong(req.getParameter("accno").trim());
			String closeAccount = new CloseDAO().closeAccount(accno);
					req.setAttribute("msg", closeAccount);
					req.getRequestDispatcher("msg.jsp").forward(req, resp);
				
			}
			
		}
		
	}
