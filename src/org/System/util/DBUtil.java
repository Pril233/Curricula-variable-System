package org.System.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";
	public static PreparedStatement  ps = null;
	public static Connection con = null;
	public static ResultSet rs = null;
	
public 	static Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("oracle.jdbc.OracleDriver");
	return DriverManager.getConnection(URL,Username,password);

}

public static PreparedStatement createPs(String sql,Object []params) throws ClassNotFoundException, SQLException {
	ps = getConnection().prepareStatement(sql);
	if(params!=null) {
		for(int i =0;i<params.length;i++)
		ps.setObject(i+1, params[i]);
	}
	return ps;
	
}

public static void closeAll(ResultSet rs,Connection con,PreparedStatement ps)  {
		if(rs!=null)
			try {
				rs.close();
				if(ps!=null)ps.close();
				if(con!=null)con.close();
		
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
}

public static boolean executeUpdate(String sql, Object []params) {
	try {
		ps = createPs(sql,params);
		int count = ps.executeUpdate();
		if(count>0)
			return true;
		else
			return false;
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}finally {
		closeAll(null,con,ps);
	}
	
}

public static ResultSet executeQuery(String sql, Object []params){
	try {
		createPs(sql,params);
		rs = ps.executeQuery();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
}

//public static list<Student>


public static int getTotality(String sql) {
	int count = 0;
	try {
		ps = createPs(sql,null);
		rs = ps.executeQuery();
		if(rs.next()) {
			count = rs.getInt(1);       //检索第一列（id）当前行的值
		}
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		closeAll(rs,con,ps);
	}
	return count; 
	
}



	
	/*
	 * public static void main(String[] args) { String sql =
	 * "select * from department"; ResultSet ra = executeQuery(sql,null); try {
	 * while(ra.next()) { int dno = ra.getInt("dno"); String dname =
	 * ra.getString("dname"); String dmanager = ra.getString("dmanager");
	 * System.out.println(dno+"-"+dname+"-"+dmanager); } } catch (SQLException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); }finally {
	 * closeAll(rs,con,ps); } }
	 */
	 

	

}
