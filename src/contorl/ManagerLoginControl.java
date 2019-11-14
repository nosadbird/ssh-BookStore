package contorl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Managerdao;
import javabean.Managerbean;


@WebServlet("/ManagerLoginControl")
public class ManagerLoginControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ManagerLoginControl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mno = request.getParameter("id");
		String mpass = request.getParameter("password");
		Managerbean mb = new Managerbean();
		mb.setMno(mno);
		mb.setMpass(mpass);
		Managerdao md = new Managerdao();
		int j = md.exist(mb);
		if(j == 1) {	//µÇÂ¼³É¹¦
			HttpSession session = request.getSession(true);
			session.setAttribute("manager", mb);
			RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
			rd.forward(request, response);
		}else if(j == -1) {	//ÃÜÂë´íÎó
			request.setAttribute("message", "ÃÜÂë´íÎóµÇÂ¼Ê§°Ü");
			RequestDispatcher rd = request.getRequestDispatcher("/managerlogin.jsp");
			rd.forward(request, response);
		}else if(j == 0) {
			request.setAttribute("message", "²»´æÔÚ¸ÃÕËºÅ£¬µÇÂ¼Ê§°Ü");
			RequestDispatcher rd = request.getRequestDispatcher("/managerlogin.jsp");
			rd.forward(request, response);
		}else if(j == -100) {
			request.setAttribute("message", "·şÎñÆ÷´íÎó£¬µÇÂ¼Ê§°Ü");
			RequestDispatcher rd = request.getRequestDispatcher("/managerlogin.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
