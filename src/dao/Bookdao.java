package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javabean.Bookbean;
import javabean.Cartbean;
import javabean.Orderbean;
import javabean.Userbean;

public class Bookdao extends Base{

	public Bookdao() {
		super();
	}
	
	//添加购物车
	public boolean addCart(Cartbean cart) {
		
		String sql = "INSERT INTO Cart"+"(Utel,Bno,Bname,Bprice)VALUES(?,?,?,?)";
    	
    	try (
			PreparedStatement pstmt = dbconn.prepareStatement(sql)){
			pstmt.setString(1, cart.getUtel());
			pstmt.setString(2, cart.getBno());
			pstmt.setString(3, cart.getBname());
			pstmt.setFloat(4, cart.getBprice());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	//获取购物车
	public Vector<Cartbean> getCart(Userbean user){
		Vector<Cartbean> cart = new Vector<Cartbean>();
		
		boolean flag = false;
		try {
			String sql1 = "SELECT * FROM Cart WHERE Utel = '";
			String sql2 =  user.getTel();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				flag = true;
				Cartbean c = new Cartbean();
				c.setUtel(rst.getString("Utel"));
				c.setBno(rst.getString("Bno"));
				c.setBname(rst.getString("Bname"));
				c.setBprice(rst.getFloat("Bprice"));
				cart.add(c);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(flag)
			return cart;
		else
			return null;
	}
	
	//根据图书编号获取图书信息
	public Bookbean getBook(String isbn) {
		Bookbean book = new Bookbean();
		
		boolean flag = false;
		try {
			String sql1 = "SELECT * FROM BookInfo WHERE Bno = '";
			String sql2 =  isbn.trim();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				flag = true;
				book.setBno(rst.getString("Bno"));
				book.setBname(rst.getString("Bname"));
				book.setBauthor(rst.getString("Bauthor"));
				book.setBpub(rst.getString("Bpub"));
				book.setBprice(rst.getFloat("Bprice"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(flag)
			return book;
		else
			return null;
	}
	
}
