package org.System.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.System.entity.Course;
import org.System.entity.Teacher;
import org.System.util.DBUtil;
public class TeacherDaoImpl {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";

	public boolean addTeacher(Teacher teacher) {
		String sql = "insert into TEACHER (tno,tname,tsex,tage,teb,tpt,cno1,cno2,cno3) values(?,?,?,?,?,?,?,?,?)";
		Object []params = {teacher.getTno(),teacher.getTname(),teacher.getTsex(),teacher.getTage(),teacher.getTeb(),teacher.getTpt(),teacher.getCno1(),teacher.getCno2(),teacher.getCno3()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public boolean deleteTeacherByTno(int tno) {
		String sql = "delete from TEACHER where tno=?";
		Object[] params = {tno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public List<Teacher> queryTeacherBypage(int currentPage,int pageSize){
		String sql = "select * from"
				+ "("
				+ "select rownum r,t.*from "
				+ " (select s.* from TEACHER s order by tno asc)t"
				+ " where rownum<=?"
				+ ")"
				+ " where r>=?";
		Object []params = {currentPage*pageSize,(currentPage-1)*pageSize+1};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		List<Teacher> Teachers = new ArrayList();
		try {
			while(rs.next()) {
			Teacher	teacher = new Teacher(rs.getInt("TNO"),rs.getString("TNAME"),rs.getString("TSEX"),rs.getInt("TAGE"),rs.getString("TEB"),rs.getString("TPT"),rs.getInt("CNO1"),rs.getInt("CNO2"),rs.getInt("CNO3"));
			Teachers.add(teacher);
			}
			return Teachers;
		} catch (SQLException e) {		
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	public Teacher queryTeacherByTno(int tno) {
		Teacher teacher = null;
		ResultSet rs = null;
		String sql = "select * from TEACHER where tno = ?";
		Object []params = {tno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				teacher = new Teacher(rs.getInt("TNO"),rs.getString("TNAME"),rs.getString("TSEX"),rs.getInt("TAGE"),rs.getString("TEB"),rs.getString("TPT"),rs.getInt("CNO1"),rs.getInt("CNO2"),rs.getInt("CNO3"));
			}
			return teacher;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
	}
	
	
	public boolean updateTeacherByTno(int tno,Teacher teacher) {
		String sql = "update Teacher set TNAME=?,TSEX=?,TAGE=?,TEB=?,TPT=?,CNO1=?,CNO2=?,CNO3=? WHERE TNO=?";
		Object []params = {teacher.getTname(),teacher.getTsex(),teacher.getTage(),teacher.getTeb(),teacher.getTpt(),teacher.getCno1(),teacher.getCno2(),teacher.getCno3(),teacher.getTno()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public boolean isExist(int tno) {
		return queryTeacherByTno(tno)==null? false:true;
	}
	
	public int getTotalCount() {
		String sql = "select count(*) from TEACHER";
		int count = DBUtil.getTotality(sql);
		return count;
	}
	
	
	public List<Teacher> queryAllTeacher(){
		List<Teacher> Teachers = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from Teacher order by TNO asc";
		rs = DBUtil.executeQuery(sql, null);

		try {
			while(rs.next()) {
				Teacher	teacher = new Teacher(rs.getInt("TNO"),rs.getString("TNAME"),rs.getString("TSEX"),rs.getInt("TAGE"),rs.getString("TEB"),rs.getString("TPT"),rs.getInt("CNO1"),rs.getInt("CNO2"),rs.getInt("CNO3"));
				Teachers.add(teacher);
			}
			return Teachers;
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}finally {
				DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
			}
	}
	
	
	
	

	
	
	
	
}
