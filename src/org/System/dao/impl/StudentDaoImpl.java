package org.System.dao.impl;

import java.util.List;

import org.System.dao.IStudentDao;
import org.System.entity.Department;
import org.System.entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.System.entity.Student;
import org.System.util.DBUtil;

public class StudentDaoImpl implements IStudentDao {
	
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";

	@Override
	public boolean addStudent(Student student) {
		String sql = "insert into STUDENT(sno,sname,ssex,sage,sdept) values(?,?,?,?,?)";
		Object []params = {student.getSno(),student.getSname(),student.getSsex(),student.getSage(),student.getSdept()};
		return DBUtil.executeUpdate(sql, params);

	}

	@Override
	public boolean deleteStudentBysno(int sno) {
		String sql = "delete from STUDENT where sno = ?";
		Object []params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public List<Student> queryallStudent() {
		List<Student> Students = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from STUDENT order by sno asc";
		rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				int sno = rs.getInt("SNO");
				String sname = rs.getString("SNAME");
				String ssex = rs.getString("SSEX");
				int sage = rs.getInt("SAGE");
				String sdept = rs.getString("SDEPT");
				Student student = new Student(sno,sname,ssex,sage,sdept);
				Students.add(student);
			}
			return Students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
		
		
	}

	@Override
	public Student queryStudentBysno(int sno) {
		Student student = null;
		ResultSet rs = null;
		String sql = "select * from STUDENT where sno = ?";
		Object[] params = {sno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				
				String sname = rs.getString("SNAME");
				String ssex = rs.getString("SSEX");
				int sage = rs.getInt("SAGE");
				String sdept = rs.getString("SDEPT");
				student = new Student(sno,sname,ssex,sage,sdept);
			}
			return student;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
		
	}

	@Override
	public boolean updateStudentBysno(int sno, Student student) {
		String sql = "update Student set sname=?,ssex=?,sage=?,sdept=? where sno=?";
		Object []params = {student.getSname(),student.getSsex(),student.getSage(),student.getSdept(),sno};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean isExist(int sno) {
		return queryStudentBysno(sno)==null? false:true;
	}

	@Override
	public List<Student> queryStudentBypage(int currentPage,int pageSize) {
		String sql = "select * from"
				+ "("
				+ "select rownum r,t.*from "
				+ " (select s.* from STUDENT s order by sno asc)t"
				+ " where rownum<=?"
				+ ")"
				+ " where r>=?";
		
		Object []params = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Student> Students = new ArrayList();
		try {
			while(rs.next()) {
				Student student = new Student(rs.getInt("SNO"),rs.getString("SNAME"),rs.getString("SSEX"),rs.getInt("SAGE"),rs.getString("SDEPT"));
				Students.add(student);
			}
			return Students;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from STUDENT";
		int count = DBUtil.getTotality(sql);
		return count;
	}

	@Override
	public List<Student> queryStudentByKey(String key, String keyword) {
		String sql = null;
		Object []params = new Object[1];
		List<Student> Students = new ArrayList();
		ResultSet rs = null;
		if(key.equals("sno")) {
			int sno =Integer.parseInt(keyword);
			sql = "select * from Student where sno = ?";
			params[0]= sno;
		}
		else if(key.equals("sname")) {
			sql = "select * from Student where sname like ?";
			params[0]="%"+keyword+"%";
		}
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				int sno = rs.getInt("SNO");
				String sname = rs.getString("SNAME");
				String ssex = rs.getString("SSEX");
				int sage = rs.getInt("SAGE");
				String sdept = rs.getString("SDEPT");
				Student student = new Student(sno,sname,ssex,sage,sdept);
				Students.add(student);
			}
			return Students;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}

	

}
