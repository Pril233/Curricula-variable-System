package org.System.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.System.entity.*;


import org.System.service.IStudentService;
import org.System.service.impl.CourseServiceImpl;
import org.System.service.impl.SctServiceImpl;
import org.System.service.impl.StudentServiceImpl;
import org.System.service.impl.SystemServiceImpl;
import org.System.service.impl.TeacherServiceImpl;

@WebServlet("/SystemServlet")
public class SystemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SystemServlet() {
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
	
	protected void check(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("check");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String usertype = request.getParameter("usertype");
		
		
		System.out.println(username+password+usertype);
		
		SystemServiceImpl syssimpl = new SystemServiceImpl();
		
		
		boolean checkResult = syssimpl.checkLogin(username, password, usertype);
		
		 IStudentService stuimpl = new StudentServiceImpl();  
		 TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		 
		
		 
		
		 
	
		 
		if(checkResult==true) {
			if(usertype.equals("student")) {
				List<Student> Students = stuimpl.queryStudentByKey("sno", username); 
				 Student student = Students.get(0);
			request.getSession().setAttribute("student", student);
			request.getRequestDispatcher("SystemOfStudent.jsp?sno="+username).forward(request, response);
			}
			
			if(usertype.equals("teacher")) {
				int tusername = Integer.parseInt(username);
				Teacher teacher =  teaimpl.queryTeacherByTno(tusername);
				request.getSession().setAttribute("teacher", teacher);
				request.getRequestDispatcher("SystemOfTeacher.jsp?tno="+tusername).forward(request, response);

			}
		}
		
		
	}
	
	
	private void selectCourse(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryCourseAndTeacher");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Student student = (Student)request.getSession().getAttribute("student");
		
		CourseServiceImpl courimpl = new CourseServiceImpl();
		TeacherServiceImpl teaimpl = new TeacherServiceImpl();
		SctServiceImpl sctimpl = new SctServiceImpl();
		List<Course> Courses = courimpl.queryAllCourse();
		List<Teacher> Teachers = teaimpl.queryAllTeacher();
		List<Sct> Scts = sctimpl.queryAllSct();
		List<MyCourses> MyCourses = sctimpl.queryMyCourses(student.getSno());
		
		
		 /* 
		 * for(Course course:Courses) { System.out.println(course.getCname()); } for(Sct
		 * sct:Scts) { System.out.println(sct.getGrade()); }
		 */
		request.setAttribute("MyCourses",MyCourses);
		request.setAttribute("Courses", Courses);
		request.setAttribute("Teachers", Teachers);
		request.setAttribute("Scts", Scts);
	
		
		
		request.getRequestDispatcher("selectCourse/index.jsp").forward(request, response);
	}
	
	private void Score(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		System.out.println("queryCourseAndTeacher");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		Teacher teacher =(Teacher) request.getSession().getAttribute("teacher");
		SctServiceImpl sctimpl = new SctServiceImpl();
		List<TeaCourse> TeaCourses = sctimpl.queryTeaCourse(teacher.getTno());
		request.setAttribute("TeaCourses", TeaCourses);
		request.getRequestDispatcher("Score/index.jsp").forward(request, response);


	}
	

}
