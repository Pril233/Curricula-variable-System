package org.System.service;

import java.util.List;

import org.System.entity.Student;

public interface IStudentService {
	public boolean addStudent(Student student);
	
	public boolean deleteStudent(Student student);
	
	public boolean deleteStudentBysno(int sno);
	
	public List<Student> queryAllStudent();
	
	public Student queryStudentBysno(int sno);
	
	public List<Student> queryStudentBypage(int currentPage,int pageSize);
	
	public boolean updateStudentBysno(int sno,Student student);

	public double getStudentCount();
	
	public List<Student> queryStudentByKey(String key,String keyword);
}
