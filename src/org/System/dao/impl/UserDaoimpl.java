package org.System.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.System.dao.IUserDao;
import org.System.entity.Department;
import org.System.entity.Student;
import org.System.entity.User;
import org.System.util.DBUtil;

public class UserDaoimpl implements IUserDao{
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";
	
	public boolean addUser(User user) {
		String sql = "insert into USERS(username,password,usertype,gender,authorization) values(?,?,?,?,?)";
		Object []params = {user.getUsername(),user.getPassword(),user.getUsertype(),user.getGender(),user.getAuthorization()};
		return DBUtil.executeUpdate(sql, params);
	
	}

	
	public boolean deleteUserById(int id) {
	
		String sql = "delete from USER where id = ?";
		Object params[]= {id};
		return DBUtil.executeUpdate(sql,params);
	}


	public List<User> queryAllUser() {
		List<User> Users = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from USER order by id asc ";
		rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String usertype = rs.getString("USERTYPE");
				String gender = rs.getString("Gender");
				String authorization = rs.getString("authorization");
				User user = new User(username,password,usertype,gender,authorization);
				Users.add(user);
			}
				return Users;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con,DBUtil.ps);
		}
	}


	public User queryUserByusername(String username) {
		ResultSet rs = null;
		User user = null;
		String sql = "select * from USER where username like '"+username+"'";
		rs = DBUtil.executeQuery(sql, null);	
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String password = rs.getString("PASSWORD");
				String usertype = rs.getString("USERTYPE");
				String gender = rs.getString("Gender");
				String authorization = rs.getString("authorization");
				user = new User(id,username,password,usertype,gender,authorization);
			}
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}
	
	
	
	public User queryUserById(int id) {
		ResultSet rs = null;
		User user = null;
		String sql = "select * from USER where id= ?";
		Object []params = {id};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				
				String username = rs.getString("USERNAME");
				String passwrod = rs.getString("PASSWORD");
				String usertype = rs.getString("USERTYPE");
				String gender = rs.getString("Gender");
				String authorization = rs.getString("authorization");
				user = new User(id,username,password,usertype,gender,authorization);
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}


	
	public boolean UpdateUserByusername(String username, User user) {

		return false;
	}


	public boolean isExist(String username) {

		return false;
	}



	public boolean isExist(int id) {
		
		return queryUserById(id)==null? false:true;
	}


	@Override
	public List<User> queryUserBypage(int currentPage, int pageSize) {
		String sql = "select * from"
				+ "("
				+ "select rownum r,t.*from "
				+ " (select s.* from User s order by id asc)t"
				+ " where rownum<=?"
				+ ")"
				+ " where r>=?";
		Object []params = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<User> Users = new ArrayList();
		try {
			while(rs.next()) {
				int id = rs.getInt("ID");
				String username = rs.getString("USERNAME");
				String passwrod = rs.getString("PASSWORD");
				String usertype = rs.getString("USERTYPE");
				String gender = rs.getString("Gender");
				String authorization = rs.getString("authorization");
				User user = new User(id,username,password,usertype,gender,authorization);
				Users.add(user);
			}
			return Users;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}
	
	}


	

}
