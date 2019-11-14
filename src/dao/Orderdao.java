package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javabean.Addressbean;
import javabean.Cartbean;
import javabean.Orderbean;
import javabean.Userbean;

public class Orderdao extends Base{

	public Orderdao() {
		super();
	}
	
	//添加订单
	public boolean addOrder(Orderbean order) {
	
			try {
				String sql1 = "INSERT INTO Orderform VALUES(?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				pstmt.setString(1, order.getUtel().trim());
				pstmt.setString(2, order.getBno().trim());
				pstmt.setString(3, order.getBname().trim());
				pstmt.setFloat(4, order.getBprice());
				pstmt.setString(5, order.getDname().trim());
				pstmt.setString(6, order.getDaddress().trim());
				pstmt.setString(7, order.getDtel().trim());
				pstmt.setInt(8, order.getOstate());
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
			try {
				String sql1 = "DELETE FROM Cart WHERE Utel=? AND Bno=?";
				PreparedStatement pstmt = dbconn.prepareStatement(sql1);
				pstmt.setString(1, order.getUtel().trim());
				pstmt.setString(2, order.getBno().trim());
				int rst = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		
		return true;
	}
	
	//获取收货地址
	public Vector<Addressbean> getAddress(Userbean user){
		Vector<Addressbean> address = new Vector<Addressbean>();
		
		boolean flag = false;
		try {
			String sql1 = "SELECT * FROM Address WHERE Utel = '";
			String sql2 =  user.getTel();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				flag = true;
				Addressbean add = new Addressbean();
				add.setUtel(rst.getString("Utel"));
				add.setDname(rst.getString("Dname"));
				add.setDaddress(rst.getString("Daddress"));
				add.setDtel(rst.getString("Dtel"));
				address.add(add);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(flag)
			return address;
		else
			return null;
	
	}

	public boolean addAddress(Addressbean ab) {
		try {
			String sql1 = "INSERT INTO Address VALUES(?,?,?,?)";
			PreparedStatement pstmt = dbconn.prepareStatement(sql1);
			pstmt.setString(1, ab.getUtel());
			pstmt.setString(2, ab.getDname());
			pstmt.setString(3, ab.getDaddress());
			pstmt.setString(4, ab.getDtel());
			int rst = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Vector<Orderbean> getOrder(String tel) {
		Vector<Orderbean> order = new Vector<Orderbean>();
		
		boolean flag = false;
		try {
			String sql1 = "SELECT * FROM Orderform WHERE Utel = '";
			String sql2 =  tel.trim();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				flag = true;
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
		if(flag)
			return order;
		else
			return null;
	}
}
