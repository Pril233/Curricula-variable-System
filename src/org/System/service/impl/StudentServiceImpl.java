package org.System.service.impl;

import java.util.List;

import org.System.dao.impl.StudentDaoImpl;
import org.System.entity.Student;
import org.System.service.IStudentService;

public class StudentServiceImpl implements IStudentService{
		StudentDaoImpl studentdao = new StudentDaoImpl();
	@Override
	public boolean addStudent(Student student) {
		if(studentdao.isExist(student.getSno())==false) {
			return studentdao.addStudent(student);
		}
		else System.out.println("此学号学生已存在!");
		return false;
	}

	@Override
	public boolean deleteStudent(Student student) {
		if(studentdao.isExist(student.getSno())==true) {
			return studentdao.deleteStudentBysno(student.getSno());
		}
		else System.out.println("要删除的学生已存在");
		return false;
	}

	@Override
	public boolean deleteStudentBysno(int sno) {
		if(studentdao.isExist(sno)==true) {
			return studentdao.deleteStudentBysno(sno);
		}
		else System.out.println("要删除的学生已存在");
		return false;
	}

	@Override
	public List<Student> queryAllStudent() {
		
		return studentdao.queryallStudent();
	}

	@Override
	public Student queryStudentBysno(int sno) {
		
		return studentdao.queryStudentBysno(sno);
	}
	
	public List<Student> queryStudentBypage(int currentPage,int pageSize){
		return studentdao.queryStudentBypage(currentPage, pageSize);
	}

	@Override
	public boolean updateStudentBysno(int sno, Student student) {
		if(studentdao.isExist(sno)==true) {
			return studentdao.updateStudentBysno(sno, student);
		}
		else System.out.println("要更新的部门不存在!");
		return false;
	}
	
	public double getMaxPage() {
		double count =(double)studentdao.getTotalCount();
		return Math.ceil(count/5.0);
	}
	
	public double getStudentCount() {
		return studentdao.getTotalCount();
	}

	@Override
	public List<Student> queryStudentByKey(String key, String keyword) {
		return studentdao.queryStudentByKey(key, keyword);
	}
	
	

}
