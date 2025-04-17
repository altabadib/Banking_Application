package Admin;

import java.io.IOException;

import Customer.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            long accno = Long.parseLong(req.getParameter("accno").trim());
            CustomerBean bean = new EditDAO().getDetails(accno);

            if (bean == null) {
                req.setAttribute("msg", "Account Does Not Exist");
                req.getRequestDispatcher("msg.jsp").forward(req, res);
            } else {
                HttpSession session = req.getSession(false);
                if (session == null) {
                    req.setAttribute("msg", "Session Logged Out");
                    req.getRequestDispatcher("msg.jsp").forward(req, res);
                } else {
                    session.setAttribute("customerBean", bean);
                    req.setAttribute("bean", bean);
                    req.getRequestDispatcher("edit.jsp").forward(req, res);
                }
            }
        } catch (NumberFormatException e) {
            req.setAttribute("msg", "Invalid Account Number Format");
            req.getRequestDispatcher("msg.jsp").forward(req, res);
        }
    }
}
