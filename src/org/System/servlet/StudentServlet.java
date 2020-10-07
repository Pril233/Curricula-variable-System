package org.System.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.System.entity.Student;
import org.System.service.IStudentService;
import org.System.service.impl.DepartmentServiceImpl;
import org.System.service.impl.StudentServiceImpl;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURI();
		System.out.println(url);
		String methodName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("."));
		System.out.println(methodName);
		java.lang.reflect.Method method = null;
		try {
			method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			method.invoke(this, request, response);
		} catch (Exception e) {
			throw new RuntimeException("调用方法出错!");
		}
	}

	private void queryStudentBypage(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("s123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		// request.setAttribute("pageIndex", currentPage);

		StudentServiceImpl stusimpl = new StudentServiceImpl();
		int MaxPage = (int) stusimpl.getMaxPage();
		System.out.println(MaxPage);
		if (currentPage > MaxPage) {
			currentPage = MaxPage;
		}
		if (currentPage == 0) {
			currentPage = 1;
		}
		List<Student> Students = stusimpl.queryStudentBypage(currentPage, 5);
		request.setAttribute("Students", Students);
		request.setAttribute("MaxPage", MaxPage);
		request.getRequestDispatcher("index.jsp?pageIndex=" + currentPage).forward(request, response);

	}

	private void getDepartmentNames(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("s456");
		int sno = 0;
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		sno = Integer.parseInt(request.getParameter("sno"));
		DepartmentServiceImpl deptimpl = new DepartmentServiceImpl();
		List DepartmentNames = deptimpl.queryAllDepartmentNames();
		request.setAttribute("DepartmentNames", DepartmentNames);
		if (sno != 0)
			request.getRequestDispatcher("update.jsp?sno=" + sno).forward(request, response);
		else {
			IStudentService stuimpl = new StudentServiceImpl();
			int scount = (int) stuimpl.getStudentCount();
			request.setAttribute("scount", scount);
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}
	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("s789");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int updatesno = Integer.parseInt(request.getParameter("updatesno"));
		IStudentService stuimpl = new StudentServiceImpl();

		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String sdept = request.getParameter("sdept");
		Student student = new Student(updatesno, sname, ssex, sage, sdept);

		boolean updateResult = stuimpl.updateStudentBysno(updatesno, student);

		if (updateResult)
			request.setAttribute("result", "updateYES");
		else
			request.setAttribute("result", "NO");
		request.getRequestDispatcher("queryStudentBypage.Do?currentPage=1").forward(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("s101112");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		IStudentService stuimpl = new StudentServiceImpl();

		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		String ssex = request.getParameter("ssex");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String sdept = request.getParameter("sdept");
		Student student = new Student(sno, sname, ssex, sage, sdept);

		boolean addResult = stuimpl.addStudent(student);

		if (addResult)
			request.setAttribute("result", "addYES");
		else
			request.setAttribute("result", "NO");
		request.getRequestDispatcher("queryStudentBypage.Do?currentPage=1").forward(request, response);

	}

	private void deleteStudentBysno(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("s131415");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		IStudentService stuimpl = new StudentServiceImpl();

		int sno = Integer.parseInt(request.getParameter("sno"));

		boolean deleteResult = stuimpl.deleteStudentBysno(sno);
		request.getRequestDispatcher("queryStudentBypage.Do?currentPage=1").forward(request, response);
	}

	private void queryStudentByKey(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		System.out.println("queryStudentByKey");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		
		  IStudentService stuimpl = new StudentServiceImpl();
		 
		String key = request.getParameter("key");
		String keyword = request.getParameter("keyword");
		
		
		  List<Student> Students = stuimpl.queryStudentByKey(key, keyword);
		 
		 if(Students.size()>=1) {
			
			 request.setAttribute("Students", Students);
		 }
		 
		 request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
