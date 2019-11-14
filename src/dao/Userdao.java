package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javabean.Userbean;
import javabean.Bookbean;

public class Userdao extends Base {
	
	//构造函数中连接数据库
	public Userdao() {
		super();
	}
	
	//添加用户
	public boolean addUser(Userbean u) {
		String sql = "INSERT INTO UserInfo"+"(Utel,Uname,Usex,Upassword)VALUES(?,?,?,?)";
    	
    	try (
			PreparedStatement pstmt = dbconn.prepareStatement(sql)){
			pstmt.setString(1, u.getTel());
			pstmt.setString(2, u.getUsername());
			pstmt.setString(3, u.getSex());
			pstmt.setString(4, u.getPassword());
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//判断用户是否存在
	public int existUser(Userbean u) {
		try {
			String sql1 = "SELECT Upassword FROM UserInfo WHERE Utel='";
			String sql2 = u.getTel();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				if(u.getPassword().equals(rst.getString("Upassword").trim())) {
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
	
	//返回用户信息
	public Userbean getUser(Userbean u) {
		try {
			String sql1 = "SELECT * FROM UserInfo WHERE Utel='";
			String sql2 = u.getTel();
			String sql = sql1+sql2+"'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			if(rst.next()) {
				u.setUsername(rst.getString("Uname"));
				u.setSex(rst.getString("Usex"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}
	
	//关键字查询 站内搜索
	public Vector<Bookbean> search(String s) {
		Vector<Bookbean> v = new Vector<Bookbean>();
		boolean flag = false;
		try {
			String sql1 = "SELECT * FROM BookInfo WHERE Bname LIKE '%";
			String sql2 =  s;
			String sql = sql1+sql2+"%'";
			PreparedStatement pstmt = dbconn.prepareStatement(sql);
			ResultSet rst = pstmt.executeQuery();
			while(rst.next()) {
				flag = true;
				Bookbean b = new Bookbean();
				b.setBno(rst.getString("Bno"));
				b.setBname(rst.getString("Bname"));
				b.setBauthor(rst.getString("Bauthor"));
				b.setBpub(rst.getString("Bpub"));
				b.setBprice(rst.getFloat("Bprice"));
				v.add(b);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(flag)
			return v;
		else
			return null;
	}

}
