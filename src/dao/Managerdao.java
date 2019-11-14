package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javabean.Bookbean;
import javabean.Managerbean;
import javabean.Orderbean;

public class Managerdao extends Base {

	//构造函数中连接数据库
		public Managerdao() {
			super();
		}

		public int exist(Managerbean mb) {
			try {
				String sql1 = "SELECT Mpass FROM ManagerInfo WHERE Mno='";
				String sql2 = mb.getMno().trim();
				String sql = sql1+sql2+"'";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				if(rst.next()) {
					if(mb.getMpass().equals(rst.getString("Mpass").trim())) {
						return 1;	//存在该用户且密码正确
					} else {
						return -1;	//存在用户但密码错误
					}
				} else {
					return 0;		//不存在该用户
				}
			}catch(SQLException e) {
				e.printStackTrace();
				return -100;		//数据库异常
			}
		}

		public boolean addBook(Bookbean book) {
			try {
				String sql1 = "INSERT INTO BookInfo VALUES(?,?,?,?,?,?)";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				pstmt.setString(1, book.getBno().trim());
				pstmt.setString(2, book.getBname().trim());
				pstmt.setString(3, book.getBauthor().trim());
				pstmt.setString(4, book.getBpub().trim());
				pstmt.setFloat(5, book.getBprice());
				pstmt.setString(6, book.getBtype().trim());
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Bookbean getBook(String bno) {
			Bookbean bb = new Bookbean();
			try {
				String sql1 = "SELECT * FROM BookInfo WHERE Bno='";
				String sql2 = bno.trim();
				String sql = sql1+sql2+"'";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				ResultSet rst = pstmt.executeQuery();
				if(rst.next()) {
					bb.setBno(rst.getString("Bno"));
					bb.setBname(rst.getString("Bname"));
					bb.setBauthor(rst.getString("Bauthor"));
					bb.setBprice(rst.getFloat("Bprice"));
					bb.setBpub(rst.getString("Bpub"));
					bb.setBtype(rst.getString("Btype"));
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return bb;
		}

		public boolean delBook(String bno) {
			try {
				String sql1 = "DELETE FROM BookInfo WHERE Bno='";
				String sql2 = bno.trim();
				String sql = sql1+sql2+"'";
				PreparedStatement pstmt = dbconn.prepareStatement(sql);
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return true;
			}
			return true;
		}

		public boolean updateBook(Bookbean book) {
			try {
				String sql1 = "UPDATE BookInfo SET Bname=?,Bauthor=?,Bpub=?,Bprice=?,Btype=? WHERE Bno=?";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				pstmt.setString(1, book.getBname().trim());
				pstmt.setString(2, book.getBauthor().trim());
				pstmt.setString(3, book.getBpub().trim());
				pstmt.setFloat(4, book.getBprice());
				pstmt.setString(5, book.getBtype().trim());
				pstmt.setString(6, book.getBno().trim());
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}

		public Vector<Bookbean> getAllBook() {
			Vector<Bookbean> book = new Vector<Bookbean>();
			try {
				String sql1 = "SELECT * FROM BookInfo";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				ResultSet rst = pstmt.executeQuery();
				while(rst.next()) {
					Bookbean bb = new Bookbean();
					bb.setBno(rst.getString("Bno"));
					bb.setBname(rst.getString("Bname"));
					bb.setBauthor(rst.getString("Bauthor"));
					bb.setBprice(rst.getFloat("Bprice"));
					bb.setBpub(rst.getString("Bpub"));
					bb.setBtype(rst.getString("Btype"));
					book.add(bb);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return book;
		}

		public Vector<Orderbean> getAllOrder() {
			Vector<Orderbean> order = new Vector<Orderbean>();
			try {
				String sql1 = "SELECT * FROM Orderform";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				ResultSet rst = pstmt.executeQuery();
				while(rst.next()) {
					Orderbean ob = new Orderbean();
					ob.setUtel(rst.getString("Utel"));
					ob.setBno(rst.getString("Bno"));
					ob.setBname(rst.getString("Bname"));
					ob.setBprice(rst.getFloat("Bprice"));
					ob.setDname(rst.getString("Dname"));
					ob.setDaddress(rst.getString("Daddress"));
					ob.setDtel(rst.getString("Dtel"));
					ob.setOstate(rst.getInt("Ostate"));
					order.add(ob);
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return order;
		}

		public boolean send(String bno) {
			try {
				String sql1 = "UPDATE Orderform SET Ostate=2 WHERE Bno=?";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				pstmt.setString(1, bno.trim());
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
}
