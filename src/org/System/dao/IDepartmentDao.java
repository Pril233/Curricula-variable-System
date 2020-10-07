package org.System.dao;

import java.util.List;


import org.System.entity.Department;

public interface IDepartmentDao {
	
	public boolean addDepartment(Department department); 
	
	public boolean deleteDepartmentBydno(int dno);
	
	public List<Department> queryallDepartment();
	
	public Department queryDepartmentBydno(int dno);
	
	public boolean UpdateDepartmentBydno(int dno,Department department);
	
	//根据系名字查询(x)
	//根据系主任查询(x)
	
	public boolean isExist(int dno);
	
	
	
	
		
	

}
