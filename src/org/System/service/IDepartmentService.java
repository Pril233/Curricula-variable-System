package org.System.service;


import java.util.List;

import org.System.entity.Department;
import org.System.util.DBUtil;

public interface IDepartmentService {
	public boolean addDepartment(Department department);
	
	public boolean deleteDepartment(Department department);
	
	public boolean deleteDepartmentBydno(int dno);
	
	public Department queryDepartmentByDno(int Dno);
	
	public List<Department> queryAllDepartment();
	
	public List queryAllDepartmentNames();
	
	public boolean UpdateDepartmentByDno(int Dno,Department department);
	
	
	
	
	
	
		
	
}
