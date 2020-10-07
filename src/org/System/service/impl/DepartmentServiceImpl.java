package org.System.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.System.dao.IDepartmentDao;
import org.System.dao.impl.DepartmentDaoimpl;
import org.System.entity.Department;
import org.System.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService  {
			
		 IDepartmentDao departdao = new DepartmentDaoimpl();
	@Override
	public boolean addDepartment(Department department) {
		if(departdao.isExist(department.getDno())==false) {
			return departdao.addDepartment(department);
		}
		else System.out.println("此部门已存在！");
		return false;
	}

	
	@Override
	public boolean deleteDepartmentBydno(int dno) {
		if(departdao.isExist(dno)==true)
			return departdao.deleteDepartmentBydno(dno);
		else
			System.out.println("不存在此部门");
		return false;
	}
	

	@Override
	public boolean deleteDepartment(Department department) {
		if(departdao.isExist(department.getDno())==true) {
			return departdao.deleteDepartmentBydno(department.getDno());
		}
		else
			System.out.println("不存在此部门");
		return false;
	}

	@Override
	public Department queryDepartmentByDno(int Dno) {
		
		return departdao.queryDepartmentBydno(Dno);
	}

	@Override
	public List<Department> queryAllDepartment() {
		
		return departdao.queryallDepartment();
	}

	@Override
	public boolean UpdateDepartmentByDno(int Dno, Department department) {
		if(departdao.isExist(Dno)==true) {
			return departdao.UpdateDepartmentBydno(Dno, department);
		}
			else
				System.out.println("要更新的部门不存在");
			return false;
	
	}


	@Override
	public List queryAllDepartmentNames() {
		List DepartmentNames = new ArrayList();
		List<Department> Departments = departdao.queryallDepartment();
		for(Department department:Departments) {
			DepartmentNames.add(department.getDname()); 
		}
		return DepartmentNames;
	}


}
