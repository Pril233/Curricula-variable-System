package org.System.service.impl;

import java.util.List;
import org.System.dao.*;
import org.System.dao.impl.CourseDaoImpl;
import org.System.entity.*;

public class CourseServiceImpl {
		CourseDaoImpl coursedao = new CourseDaoImpl();
		
	public boolean addCourse(Course course) {
		if(coursedao.isExist(course.getCno())==false) {
			return coursedao.addCourse(course);
		}
		else System.out.println("此课程已存在!");
		return false;
	}
	
	public boolean deleteCourse(int cno) {
		if(coursedao.isExist(cno)==true) {
			return coursedao.deteleCourseBycno(cno);
		}
		else System.out.println("要删除的课程不存在");
		return false;
	}
	
	public List<Course> queryCourseByPage(int currentPage,int pageSize) {
		return coursedao.queryCourseBypage(currentPage, pageSize);
	}
	
	public List<Course> queryAllCourse(){
		return coursedao.queryAllCourse();
	}
	
	public boolean updateCourseBycno(int cno,Course course) {
		if(coursedao.isExist(cno)==true) {
		return coursedao.updateCourse(cno, course);
	}else
		System.out.println("要更改的课程不存在");
		return false;
	}
	
	public double getMaxPage() {
		double count = (double)coursedao.getTotalCount();
		return Math.ceil(count/5.0);
	}
	
	public List<Course> queryCourseByKey(String key,String keyword){
		return coursedao.queryCourseByKey(key, keyword);
	}
}
