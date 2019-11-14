package contorl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Orderdao;
import javabean.Addressbean;
import javabean.Userbean;


@WebServlet("/AddAddress")
public class AddAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AddAddress() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aim = request.getParameter("hidden");
		HttpSession session = request.getSession();
		Userbean user = (Userbean) session.getAttribute("user");
		if(user == null) {
			request.setAttribute("message", "请先登录");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
		if(aim != null && aim.equals("addaddress")) {	//添加收货地址
			Addressbean ab = new Addressbean();
			ab.setUtel(user.getTel());
			ab.setDname(new String(request.getParameter("dname").trim().getBytes("iso-8859-1"),"UTF-8"));
			ab.setDaddress(new String(request.getParameter("daddress").trim().getBytes("iso-8859-1"),"UTF-8"));
			ab.setDtel(new String(request.getParameter("dtel").trim().getBytes("iso-8859-1"),"UTF-8"));
			Orderdao od = new Orderdao();
			if(od.addAddress(ab)) {
				request.setAttribute("message", "添加成功");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
