package org.System.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.System.entity.Course;
import org.System.entity.Teacher;
import org.System.service.impl.CourseServiceImpl;
import org.System.service.impl.TeacherServiceImpl;


@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public TeacherServlet() {
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
	
	
	private void queryTeacherByPage(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryTeacherByPage");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));

		TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		int MaxPage = (int)teaimpl.getMaxPage();
		if(currentPage>MaxPage){
			currentPage=MaxPage;
		}
		if(currentPage==0){
			currentPage=1;
		}
		
		List<Teacher> Teachers = teaimpl.queryTeacherByPage(currentPage, 5);
	
		request.setAttribute("Teachers", Teachers);
		request.setAttribute("MaxPage", MaxPage);
		request.getRequestDispatcher("index.jsp?pageIndex="+currentPage).forward(request, response);
	}
	
	
	private void getCourses(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("getCourses");
		int tno = 0;
		tno = Integer.parseInt(request.getParameter("tno"));
		CourseServiceImpl courimpl = new CourseServiceImpl();
		List<Course> Courses = courimpl.queryAllCourse();
		request.setAttribute("Courses", Courses);
		if(tno!=0) {
			request.getRequestDispatcher("update.jsp?tno="+tno).forward(request, response);	
		}
		else {
			request.getRequestDispatcher("add.jsp").forward(request, response);	

		}
	}
	
	private void updateTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("updateTeacher");
		int tno = Integer.parseInt(request.getParameter("tno"));
		TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		int tage = Integer.parseInt(request.getParameter("tage"));
		String teb= request.getParameter("teb");
		String tpt = request.getParameter("tpt");
		int cno1 = Integer.parseInt(request.getParameter("cno1"));
		int cno2 = Integer.parseInt(request.getParameter("cno2"));
		int cno3 = Integer.parseInt(request.getParameter("cno3"));
		Teacher teacher = new Teacher(tno,tname,tsex,tage,teb,tpt,cno1,cno2,cno3);
		boolean updateResult = teaimpl.updateTeacherByTno(tno, teacher);
		 if(updateResult) 
			  request.setAttribute("result", "updateYES");
		  else 
			 request.setAttribute("result", "NO");
		 request.getRequestDispatcher("queryTeacherByPage.GO?currentPage=1").forward(request, response);	
		
	}

	private void addTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("addTeacher");
		TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		int tno = Integer.parseInt(request.getParameter("tno"));
		String tname = request.getParameter("tname");
		String tsex = request.getParameter("tsex");
		int tage = Integer.parseInt(request.getParameter("tage"));
		String teb= request.getParameter("teb");
		String tpt = request.getParameter("tpt");
		int cno1 = Integer.parseInt(request.getParameter("cno1"));
		int cno2 = Integer.parseInt(request.getParameter("cno2"));
		int cno3 = Integer.parseInt(request.getParameter("cno3"));
		Teacher teacher = new Teacher(tno,tname,tsex,tage,teb,tpt,cno1,cno2,cno3);
		boolean addResult = teaimpl.addTeacher(teacher);
		 request.getRequestDispatcher("queryTeacherByPage.GO?currentPage=1").forward(request, response);	
		
	}
	
	private void deleteTeacherBytno(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("deleteTeacher");
		int tno = Integer.parseInt(request.getParameter("tno"));
		TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		boolean deleteResult = teaimpl.deleteTeacherByTno(tno);
		 request.getRequestDispatcher("queryTeacherByPage.GO?currentPage=1").forward(request, response);	



	}
}
