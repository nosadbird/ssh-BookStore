package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Base {

	Connection dbconn = null;
	
	//构造函数中连接数据库
	public Base() {
		String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    	String dburl = "jdbc:sqlserver://localhost:1433; DatabaseName = Zhouz_University_Mis";
    	String username = "zz_User1";
    	String password = "zzuser1";
    	try {
    		Class.forName(driver);
    		dbconn = DriverManager.getConnection(dburl, username, password);
    	}catch(ClassNotFoundException e1){
    		e1.printStackTrace();
    	}catch(SQLException e2) {
    		e2.printStackTrace();
    	}
	}
}
