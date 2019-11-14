package contorl;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userdao;
import javabean.Bookbean;
import javabean.Userbean;

@WebServlet("/contorller")
public class contorller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public contorller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String judge = request.getParameter("hidden");
		
		if(judge != null && judge.equals("register")) {		//注册
			String tel = request.getParameter("tel");
			String password = request.getParameter("password");

			Userbean u = new Userbean();
			u.setTel(tel);
			u.setUsername(new String(request.getParameter("name").trim().getBytes("iso-8859-1"),"UTF-8"));
			u.setSex(new String(request.getParameter("sex").trim().getBytes("iso-8859-1"),"UTF-8"));
			u.setPassword(password);
			Userdao addu = new Userdao();
			int j = addu.existUser(u);
			if(j == 1 || j == -1) {
				request.setAttribute("message", "已存在该用户！注册失败！");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
			}else if(addu.addUser(u)) {
				request.setAttribute("message", "注册成功！请登录！");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("message", "服务器错误，注册失败！请重试！");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
			}
			
		} else if(judge != null && judge.equals("login")) {		//登录
			String tel = request.getParameter("tel");
			String password = request.getParameter("password");
			
			Userbean u = new Userbean();
			u.setTel(tel);
			u.setPassword(password);
			Userdao exist = new Userdao();
			int j = exist.existUser(u);
			if(j == 1) {	//登录成功
				u = exist.getUser(u);	//获取用户完整信息
				HttpSession s = request.getSession(true);
				s.setAttribute("user", u);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			} else if(j == -1) {
				request.setAttribute("message", "密码错误，登录失败！请重试！");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			} else if(j == 0) {
				request.setAttribute("message", "不存在该用户，登录失败！请注册！");
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
			} else if(j == -100) {
				request.setAttribute("message", "服务器错误，登录失败！请重试！");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			}
		} else if(judge != null && judge.equals("search")) {	//站内搜索

			request.setCharacterEncoding("utf-8");
			String s = new String(request.getParameter("search").trim().getBytes("iso-8859-1"),"UTF-8");
			
			Userdao d = new Userdao();
			Vector<Bookbean> b = d.search(s);
			HttpSession session = request.getSession();
			session.setAttribute("Book", b);
			RequestDispatcher rd = request.getRequestDispatcher("/search.jsp");
			rd.forward(request, response);

		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
