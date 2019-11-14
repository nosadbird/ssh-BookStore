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

import dao.Bookdao;
import dao.Orderdao;
import javabean.Addressbean;
import javabean.Bookbean;
import javabean.Orderbean;
import javabean.Userbean;


@WebServlet("/Paycontroll")
public class Paycontroll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Paycontroll() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		Userbean user = (Userbean) session.getAttribute("user");
		String aim= request.getParameter("hidden");
		if( aim.equals("buynow")) {
			String s = request.getParameter("address");
			int index = Integer.parseInt(s);
			Vector<Bookbean> book = (Vector<Bookbean>) session.getAttribute("buybook");
			Vector<Addressbean> address = (Vector<Addressbean>) session.getAttribute("address");
			Vector<Orderbean> order = new Vector<Orderbean>();
			for(int i = 0;i < book.size();i++) {
				Orderbean o = new Orderbean();
				o.setUtel(user.getTel());
				o.setBno(book.get(i).getBno());
				o.setBname(book.get(i).getBname());
				o.setBprice(book.get(i).getBprice());
				o.setDname(address.get(index).getDname());
				o.setDaddress(address.get(index).getDaddress());
				o.setDtel(address.get(index).getDtel());
				o.setOstate(1);
				order.add(o);
			}
			Orderdao od = new Orderdao();
			boolean flag = true;
			for(int i = 0;i < order.size();i++) {
				if(!od.addOrder(order.get(i)))
					flag = false;
			}
			if(flag) {
				request.setAttribute("message", "购买成功！");
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "未知问题，购买失败");
				RequestDispatcher rd = request.getRequestDispatcher("/confirm.jsp");
				rd.forward(request, response);
			}
		} else if(aim.equals("cart")) {
			//判断有无收货地址
			Orderdao od = new Orderdao();
			Vector<Addressbean> address = new Vector<Addressbean>();
			address = od.getAddress(user);
			if(address == null) {
				request.setAttribute("message", "还没有收货地址呢，添加一个吧");
				RequestDispatcher rd = request.getRequestDispatcher("/addaddress.jsp");
				rd.forward(request, response);
			} else {		//选择收货地址及确认支付！
				String[] b = request.getParameterValues("check");
				Bookdao bd = new Bookdao();
				Vector<Bookbean> book = new Vector<Bookbean>();
				if(b != null) {
					for(int i = 0;i < b.length;i++) {
						Bookbean bo = bd.getBook(b[i]);
						book.add(bo);
					}
				}
				session.setAttribute("address", address);
				session.setAttribute("buybook", book);
				RequestDispatcher rd = request.getRequestDispatcher("/confirm.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
