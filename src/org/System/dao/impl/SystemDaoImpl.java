package org.System.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.System.util.DBUtil;

public class SystemDaoImpl {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";
	
	public boolean check(String username,String passwrod,String usertype) {
		String sql = "select * from users where username=? and password=? and usertype=?";
		Object []params = {username,passwrod,usertype};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
		if(rs.next()) {
			return true;
		}
		else
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}

		}
	}



