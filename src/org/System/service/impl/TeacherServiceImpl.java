package org.System.service.impl;

import java.util.List;

import org.System.dao.impl.StudentDaoImpl;
import org.System.dao.impl.TeacherDaoImpl;
import org.System.entity.Teacher;

public class TeacherServiceImpl {
	TeacherDaoImpl teadao = new TeacherDaoImpl();
	
	public boolean addTeacher(Teacher teacher) {
		if(teadao.isExist(teacher.getTno())==false) {
			return teadao.addTeacher(teacher);
		}
		else
			System.out.println("该教师已存在");
			return false;
	}
	
	
	public boolean deleteTeacherByTno(int tno) {
		if(teadao.isExist(tno)==true) {
			return teadao.deleteTeacherByTno(tno);
		}
		else
			System.out.println("该教师不存在");
			return false;
	}
	
	
	public Teacher queryTeacherByTno(int tno) {
		return teadao.queryTeacherByTno(tno);
	}
	
	
	public List<Teacher> queryTeacherByPage(int currentPage,int pageSize){
		return teadao.queryTeacherBypage(currentPage, pageSize);
	}
	
	public boolean updateTeacherByTno(int tno,Teacher teacher) {
		if(teadao.isExist(tno)==true) {
			return teadao.updateTeacherByTno(tno, teacher);
		}
		else
			System.out.println("该教师不存在");
			return false;
	}
	
	
	public double getMaxPage() {
		double count =(double)teadao.getTotalCount();
		return Math.ceil(count/5.0);
	}
	
	public double getTeacherCount() {
		return teadao.getTotalCount();
	}
	
	public List<Teacher> queryAllTeacher(){
		return teadao.queryAllTeacher();
	}
	
}
