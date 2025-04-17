package Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs=request.getSession(false);
		if(hs==null) {
			request.setAttribute("msg", "Session LogOut.");
			request.getRequestDispatcher("msg.jsp").forward(request, response);
			
		}
		else {
			hs.invalidate();
			request.setAttribute("msg", "LoggedOut SuccessFully!!!");
			request.getRequestDispatcher("logout.jsp").forward(request, response);
		}
	}

}
