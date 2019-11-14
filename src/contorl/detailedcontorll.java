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
import javabean.Cartbean;
import javabean.Orderbean;
import javabean.Userbean;


@WebServlet("/detailedcontorll")
public class detailedcontorll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public detailedcontorll() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s = request.getParameter("id");
		String aim = request.getParameter("aim");
		if(aim == null && s != null) {	//查看书籍详细页
			Bookbean book = new Bookbean();
			Bookdao b = new Bookdao();
			book = b.getBook(s);
			request.setAttribute("book",book);
			RequestDispatcher rd = request.getRequestDispatcher("/detailed.jsp");
			rd.forward(request, response);
		} else if(aim != null ){	//需要登录才能进行的操作
			
			HttpSession session = request.getSession();
			Userbean user = (Userbean) session.getAttribute("user");
			
			if(user == null) {	//未登录
				request.setAttribute("message", "请先登录！");
				RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
				rd.forward(request, response);
			} else {
				//添加购物车
				if(aim.equals("joincart")) {
					Bookbean book = new Bookbean();
					Bookdao b = new Bookdao();
					Cartbean cart = new Cartbean();
					book = b.getBook(s);
					cart.setUtel(user.getTel());
					cart.setBno(book.getBno());
					cart.setBname(book.getBname());
					cart.setBprice(book.getBprice());
					if(b.addCart(cart)) {
						request.setAttribute("message", "添加成功，宝贝已在购物车等您");
						RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
						rd.forward(request, response);
					}
					
				} else if(aim.equals("opencart")) {	//打开购物车
					
						Vector<Cartbean> cart = new Vector<Cartbean>();
						Bookdao b = new Bookdao();
						cart = b.getCart(user);
						request.setAttribute("cart", cart);
						RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
						rd.forward(request, response);
					
				} else if(aim.equals("buynow")) {	//立即购买
					//判断有无收货地址
					Orderdao od = new Orderdao();
					Vector<Addressbean> address = new Vector<Addressbean>();
					address = od.getAddress(user);
					if(address == null) {
						request.setAttribute("message", "还没有收货地址呢，添加一个吧");
						RequestDispatcher rd = request.getRequestDispatcher("/addaddress.jsp");
						rd.forward(request, response);
					} else {		//选择收货地址及确认支付！
						
						Bookdao bd = new Bookdao();
						Vector<Bookbean> book = new Vector<Bookbean>();
						book.add(bd.getBook(s));
						session.setAttribute("address", address);
						session.setAttribute("buybook", book);
						RequestDispatcher rd = request.getRequestDispatcher("/confirm.jsp");
						rd.forward(request, response);
					}
					
				} else if(aim.equals("myorder")) {
					Orderdao od = new Orderdao();
					Vector<Orderbean> order = od.getOrder(user.getTel());
					request.setAttribute("myorder", order);
					RequestDispatcher rd = request.getRequestDispatcher("/myorder.jsp");
					rd.forward(request, response);
				}else if(aim.equals("myinfo")) {
					RequestDispatcher rd = request.getRequestDispatcher("/myinfo.jsp");
					rd.forward(request, response);
				}
				
			}
		}
			
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
