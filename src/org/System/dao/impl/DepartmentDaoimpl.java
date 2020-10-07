package org.System.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.System.dao.IDepartmentDao;
import org.System.entity.Department;
import org.System.util.DBUtil;

public class DepartmentDaoimpl implements IDepartmentDao {
	private static final String URL = "jdbc:oracle:"+"thin:@localhost:1521:ORCL";
	private static final String Username = "czh";
	private static final String password = "123456";


	@Override
	public boolean addDepartment(Department department) {
		String sql = "insert into DEPARTMENT(dno,dname,dmanager) values(?,?,?)";
		Object []params = {department.getDno(),department.getDname(),department.getDmanager()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteDepartmentBydno(int dno) {
		String sql = "delete from DEPARTMENT where dno = ?";
		Object []params= {dno};
		return DBUtil.executeUpdate(sql, params);
		
		
	}

	@Override
	public List<Department> queryallDepartment() {
		List<Department> departments = new ArrayList<>();
		ResultSet rs = null;
		String sql = "select * from DEPARTMENT order by dno asc ";
		rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				int dno = rs.getInt("DNO");
				String dname = rs.getString("DNAME");
				String dmanager = rs.getString("DMANAGER");
				Department department = new Department(dno,dname,dmanager);
				departments.add(department);
				
			}
			return departments;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con,DBUtil.ps);
		}
	
	}

	@Override
	public Department queryDepartmentBydno(int DNO) {
		ResultSet rs = null;
		Department department = null;
		String sql = "select * from DEPARTMENT where dno = ?";
		Object []params = {DNO};  
		rs = DBUtil.executeQuery(sql, params);
		try {
			while(rs.next()){
				  int dno = rs.getInt("DNO");
				  String dname = rs.getString("DNAME");
				  String dmanager = rs.getString("DMANAGER");
				  department  = new Department(dno,dname,dmanager);
			}
			return department;
			
		}
			
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.con, DBUtil.ps);
		}
		
	}

	@Override
	public boolean UpdateDepartmentBydno(int dno, Department department) {
		String sql = "update department set DNAME = ? ,DMANAGER = ? WHERE DNO = ?";
		Object []params = {department.getDname(),department.getDmanager(),dno};
		return DBUtil.executeUpdate(sql, params);
		
	}

	@Override
	public boolean isExist(int dno) {
		return queryDepartmentBydno(dno)==null? false:true;
	
	}
	

}
