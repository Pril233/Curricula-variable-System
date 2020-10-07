package org.System.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.System.dao.IDepartmentDao;
import org.System.entity.*;
import org.System.util.DBUtil;

public class CourseDaoImpl {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";
	
	
	public boolean addCourse(Course course) {
		String sql = "insert into COURSE(CNO,CNAME,CPNO,CCREDIT) values(?,?,?,?)";
		Object []params = {course.getCno(),course.getCname(),course.getCpno(),course.getCcredit()};
		return DBUtil.executeUpdate(sql, params);
		
	}
	
	
	public boolean deteleCourseBycno(int cno) {
		String sql = "delete from COURSE where cno = ?";
		Object []params = {cno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public Course queryCourseBycno(int cno) {
		Course course = null;
		ResultSet rs = null;
		String sql = "select * from COURSE where cno = ?";
		Object []params = {cno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				course = new Course(rs.getInt("CNO"),rs.getString("CNAME"),rs.getInt("CPNO"),rs.getInt("CCREDIT"));
			}
			return course;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}
	
	
	public List<Course> queryCourseByKey(String key,String keyword){
		String sql = null;
		Object []params = new Object[1];
		List<Course> Courses = new ArrayList();
		ResultSet rs = null;
		if(key.equals("cno")) {
			int cno =Integer.parseInt(keyword);
			sql = "select * from Course where cno = ?";
			params[0]= cno;
		}
		else if(key.equals("cname")) {
			sql = "select * from Course where cname like ?";
			params[0]="%"+keyword+"%";
		}
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				int cno = rs.getInt("CNO");
				String cname = rs.getString("CNAME");
				int cpno = rs.getInt("CPNO");
				int ccredit = rs.getInt("CCREDIT");
				Course course = new Course(cno,cname,cpno,ccredit);
				Courses.add(course);
			}
			return Courses;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}
	
	
	
	public List<Course> queryCourseBypage(int currentPage,int pageSize){
		String sql = "select * from"
				+ "("
				+ "select rownum r,t.*from "
				+ " (select s.* from COURSE s order by cno asc)t"
				+ " where rownum<=?"
				+ ")"
				+ " where r>=?";
		Object []params = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Course> Courses = new ArrayList();
		try {
			while(rs.next()) {
				Course course = new Course(rs.getInt("CNO"),rs.getString("CNAME"),rs.getInt("CPNO"),rs.getInt("CCREDIT"));
				Courses.add(course);
			}
			return Courses;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Course> queryAllCourse(){
		List<Course> Courses = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from COURSE order by CNO asc";
		rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				Course course = new Course(rs.getInt("CNO"),rs.getString("CNAME"),rs.getInt("CPNO"),rs.getInt("CCREDIT"));
				Courses.add(course);
			}
			return Courses;
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}finally {
				DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
			}
	}
	
	
	public boolean updateCourse(int cno,Course course) {
		String sql="update Course set CNAME=?,CPNO=?,CCREDIT=? where CNO=?";
		Object []params = {course.getCname(),course.getCpno(),course.getCcredit(),course.getCno()};
		return DBUtil.executeUpdate(sql, params);
	}
	public boolean isExist(int cno) {
		return queryCourseBycno(cno)==null? false:true;
	}
	
	public int getTotalCount() {
		String sql = "select count(*) from COURSE";
		int count = DBUtil.getTotality(sql);
		return count;
	}
}
