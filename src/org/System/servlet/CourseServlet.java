package org.System.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.System.entity.*;
import org.System.service.impl.CourseServiceImpl;


@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CourseServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		System.out.println(url);
		String methodName = url.substring(url.lastIndexOf("/")+1,url.lastIndexOf("."));
		System.out.println(methodName);
		java.lang.reflect.Method method = null;
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request,response);
		}catch (Exception e) {
			throw new RuntimeException("调用方法出错!");
		}
	}
	
	private void queryCourseBypage(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryCourseBypage");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		CourseServiceImpl courimpl = new CourseServiceImpl();
		int MaxPage = (int)courimpl.getMaxPage();
		System.out.println(MaxPage);
		if(currentPage>MaxPage){
			currentPage=MaxPage;
		}
		if(currentPage==0){
			currentPage=1;
		}
		List<Course> Courses = courimpl.queryCourseByPage(currentPage, 5);
		request.setAttribute("Courses", Courses);
		request.setAttribute("MaxPage", MaxPage);
		request.getRequestDispatcher("index.jsp?pageIndex="+currentPage).forward(request, response);
		
		
	}
	
	
	
	private void queryAllCourse(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryAllCourse");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int cno = 0;
		cno = Integer.parseInt(request.getParameter("cno"));
		CourseServiceImpl courimpl = new CourseServiceImpl();
		List<Course> Courses = courimpl.queryAllCourse();
		if(cno!=0) {
			request.setAttribute("Courses", Courses);
			request.getRequestDispatcher("update.jsp?cno="+cno).forward(request, response);	
		}
		
	}
	
	
	
	private void updateCourseBycno(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("updateCourseBycno");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int cno = Integer.parseInt(request.getParameter("cno"));
		String cname = request.getParameter("cname");
		int cpno = Integer.parseInt(request.getParameter("cpno"));
		int ccredit = Integer.parseInt(request.getParameter("ccredit"));
		Course course = new Course(cno,cname,cpno,ccredit);
		CourseServiceImpl courimpl = new CourseServiceImpl();
		boolean updateResult = courimpl.updateCourseBycno(cno, course);
		request.getRequestDispatcher("queryCourseBypage.Go?currentPage=1").forward(request, response);	
	}
	
	private void deleteCourseBycno(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("deleteCourseBycno");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int cno = Integer.parseInt(request.getParameter("cno"));
		CourseServiceImpl courimpl = new CourseServiceImpl();
		boolean deleteResult = courimpl.deleteCourse(cno);
		request.getRequestDispatcher("queryCourseBypage.Go?currentPage=1").forward(request, response);	

	}
	
	private void queryCourseByKey(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryCourseByKey");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		CourseServiceImpl courimpl = new CourseServiceImpl();
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		List<Course> Courses = courimpl.queryCourseByKey(key, keyword);
		 if(Courses.size()>=1) {
				
			 request.setAttribute("Courses", Courses);
		 }
		 request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	

}
