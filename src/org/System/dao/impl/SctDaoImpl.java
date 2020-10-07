package org.System.dao.impl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.System.entity.*;
import org.System.util.DBUtil;
public class SctDaoImpl {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";

	
	
	public List<Sct> queryAllSct(){
		List<Sct> Scts = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from SCT order by SNO asc";
		rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				Sct	sct = new Sct(rs.getInt("SNO"),rs.getInt("CNO"),rs.getInt("TNO"),rs.getInt("GRADE"));
				Scts.add(sct);
			}
			return Scts;
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}finally {
				DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
			}
	}
	
	public List<MyCourses> queryMyCourse(int sno){
		List<MyCourses> MyCourses = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select c.CNO,c.CNAME,b.TNAME from SCT a,Teacher b,Course c WHERE b.TNO=a.TNO AND a.CNO=c.CNO and  grade=-1 and sno=? order by CNO asc";
		Object []params= {sno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				MyCourses mycourse = new MyCourses(rs.getInt("CNO"),rs.getString("CNAME"),rs.getString("TNAME"));
				MyCourses.add(mycourse);
			}
			return MyCourses;
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}finally {
				DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
			}
		}
	
	
	public List<TeaCourse> queryTeaCourse(int tno){
		List<TeaCourse> TeaCourses = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select b.cno,b.cname,a.sno,a.sname,c.grade from student a,course b ,sct c where a.sno=c.sno and c.cno=b.cno and c.tno=? order by SNO asc";
		Object []params= {tno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()) {
				TeaCourse teacourse = new TeaCourse(rs.getInt("CNO"),rs.getString("CNAME"),rs.getInt("SNO"),rs.getString("SNAME"),rs.getInt("GRADE"));
				TeaCourses.add(teacourse);
			}
			return TeaCourses;
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
			}finally {
				DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
			}

	}
	
	
	public boolean addSct(Sct sct) {
		String sql = "insert into SCT (SNO,CNO,TNO) values(?,?,?)";
		Object []params = {sct.getSno(),sct.getCno(),sct.getTno()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public boolean isExist(Sct sct) {
		ResultSet rs = null;
		String sql = "select * from SCT where sno=? and cno=?";
		Object []params = {sct.getSno(),sct.getCno()};
		rs = DBUtil.executeQuery(sql, params);
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
	
	public boolean isFinish(int sno,int cno) {
		ResultSet rs = null;
		String sql = "select grade from SCT where sno=? and cno=?";
		Object []params = {sno,cno};
		rs = DBUtil.executeQuery(sql, params);
		try {
			if(rs.next()) {
				if(rs.getInt("GRADE")>=60)
				return true;
				return false;
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

	public boolean deleteSct(int sno,int cno) {
		String sql = "delete from SCT where sno=? and cno=?";
		Object []params= {sno,cno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	public boolean Score(int grade,int sno,int cno,int tno) {
		String sql = "update Sct set GRADE = ? where sno=? and cno=? and tno= ?";
		Object []params = {grade,sno,cno,tno};
		return DBUtil.executeUpdate(sql, params);
	}




}
