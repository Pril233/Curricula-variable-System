package org.System.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.System.entity.Sct;
import org.System.entity.Student;
import org.System.entity.Teacher;
import org.System.service.impl.SctServiceImpl;

@WebServlet("/SctServlet")
public class SctServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SctServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void addSct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("addSct123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SctServiceImpl sctimpl = new SctServiceImpl();
		Student student = (Student)request.getSession().getAttribute("student");
		System.out.println(student.getSname());
		
		  int cno = Integer.parseInt(request.getParameter("cno")); 
		  int cpno =Integer.parseInt(request.getParameter("cpno")); 
		  int tno =Integer.parseInt(request.getParameter("tno"));
		 System.out.println(cno+"|"+cpno+"|"+tno);
		 Sct sct = new Sct(student.getSno(),cno,tno);
	
		 boolean addResult = sctimpl.addSct(sct, cpno); 
		 
		request.getRequestDispatcher("selectCourse.IN").forward(request, response);

		 
		 
		
	}
	
	private void deleteSct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteSct123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SctServiceImpl sctimpl = new SctServiceImpl();
		Student student = (Student)request.getSession().getAttribute("student");
		System.out.println("当前学生名字:"+student.getSname());
		int cno = Integer.parseInt(request.getParameter("cno"));
		
		boolean deleteResult = sctimpl.deleteSct(student.getSno(), cno);
		
	}
	
	private void Score(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Score123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int sno = Integer.parseInt(request.getParameter("sno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
		Teacher teacher =  (Teacher)request.getSession().getAttribute("teacher");
		int tno = teacher.getTno();
		int grade = Integer.parseInt(request.getParameter("grade"));
		SctServiceImpl sctimpl = new SctServiceImpl();
		sctimpl.Score(grade, sno, cno, tno);
		request.getRequestDispatcher("Score.IN").forward(request, response);

		
		

		
	}
	
}
