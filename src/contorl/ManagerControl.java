package contorl;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Managerdao;
import javabean.Bookbean;
import javabean.Orderbean;


@WebServlet("/ManagerControl")
public class ManagerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ManagerControl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aim= request.getParameter("aim");
		Managerdao md = new Managerdao();
		if(aim != null && aim.equals("addbook")) {
			RequestDispatcher rd = request.getRequestDispatcher("/addbook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("ensureaddbook")) {
			Bookbean book = new Bookbean();
			book.setBno(request.getParameter("bno"));
			book.setBname(new String(request.getParameter("bname").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBauthor(new String(request.getParameter("bauthor").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBprice(Float.parseFloat(request.getParameter("bprice")));
			book.setBpub(new String(request.getParameter("bpub").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBtype(new String(request.getParameter("btype").trim().getBytes("iso-8859-1"),"UTF-8"));
			if(md.addBook(book)) {
				request.setAttribute("message", "添加成功");
				RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "编号重复，添加失败");
				RequestDispatcher rd = request.getRequestDispatcher("/addbook.jsp");
				rd.forward(request, response);
			}
		}else if(aim != null && aim.equals("delbook")) {
			request.setAttribute("aim", "delbook");
			RequestDispatcher rd = request.getRequestDispatcher("/delbook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("getdelbook")) {
			String bno= request.getParameter("bno");
			Bookbean book = md.getBook(bno);
			request.setAttribute("aim", "getdelbook");
			request.setAttribute("delbook", book);
			RequestDispatcher rd = request.getRequestDispatcher("/delbook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("ensuredelbook")) {
			String bno = request.getParameter("bno");
			if(md.delBook(bno)) {
				request.setAttribute("message", "删除成功");
				RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "删除失败");
				RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
				rd.forward(request, response);
			}
		}else if(aim != null && aim.equals("updatebook")) {
			request.setAttribute("aim", "updatebook");
			RequestDispatcher rd = request.getRequestDispatcher("/updatebook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("getupdatebook")) {
			String bno= request.getParameter("bno");
			Bookbean book = md.getBook(bno);
			request.setAttribute("aim", "getupdatebook");
			request.setAttribute("updatebook", book);
			RequestDispatcher rd = request.getRequestDispatcher("/updatebook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("ensureupdatebook")) {
			Bookbean book = new Bookbean();
			book.setBno(request.getParameter("bno"));
			book.setBname(new String(request.getParameter("bname").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBauthor(new String(request.getParameter("bauthor").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBprice(Float.parseFloat(request.getParameter("bprice")));
			book.setBpub(new String(request.getParameter("bpub").trim().getBytes("iso-8859-1"),"UTF-8"));
			book.setBtype(new String(request.getParameter("btype").trim().getBytes("iso-8859-1"),"UTF-8"));
			if(md.updateBook(book)) {
				request.setAttribute("message", "修改成功");
				RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "修改失败");
				RequestDispatcher rd = request.getRequestDispatcher("/managerindex.jsp");
				rd.forward(request, response);
			}
		}else if(aim != null && aim.equals("viewbook")) {
			Vector<Bookbean> books = md.getAllBook();
			request.setAttribute("aim", "viewbook");
			request.setAttribute("book", books);
			RequestDispatcher rd = request.getRequestDispatcher("/viewbook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("viewonebook")) {
			String bno= request.getParameter("bno");
			Bookbean book = md.getBook(bno);
			request.setAttribute("aim", "viewonebook");
			request.setAttribute("viewonebook", book);
			RequestDispatcher rd = request.getRequestDispatcher("/viewbook.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("order")) {
			Vector<Orderbean> order = md.getAllOrder();
			request.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
			rd.forward(request, response);
		}else if(aim != null && aim.equals("send")) {
			String bno= request.getParameter("bno");
			if(md.send(bno)) {
				Vector<Orderbean> order = md.getAllOrder();
				request.setAttribute("order", order);
				request.setAttribute("message", "发货成功");
				RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
				rd.forward(request, response);
			}else {
				request.setAttribute("message", "发货失败！");
				RequestDispatcher rd = request.getRequestDispatcher("/order.jsp");
				rd.forward(request, response);
			}
			
		}else if(aim != null && aim.equals("form")) {
			Vector<Orderbean> order = md.getAllOrder();
			request.setAttribute("order", order);
			RequestDispatcher rd = request.getRequestDispatcher("/form.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
