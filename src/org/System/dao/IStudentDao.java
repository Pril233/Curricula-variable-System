package org.System.dao;

import java.util.List;

import org.System.entity.Student;

public interface IStudentDao {
	
	public boolean addStudent(Student student); 
	
	public boolean deleteStudentBysno(int sno);
	
	public List<Student> queryallStudent();
	
	public List<Student> queryStudentBypage(int currentPage,int pageSize);
	
	public Student queryStudentBysno(int sno);
	
	public boolean updateStudentBysno(int sno,Student student);
	
	public boolean isExist(int sno);
	
	public int getTotalCount();
	
	public List<Student> queryStudentByKey(String key,String keyword);
	
	
	

}
