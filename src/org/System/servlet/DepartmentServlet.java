package org.System.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.System.entity.*;
import org.System.service.impl.DepartmentServiceImpl;






//@WebServlet("/DepartmentServlet")
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	
    public DepartmentServlet() {
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
	
	private void queryDepart(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
		
		System.out.println("123");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		DepartmentServiceImpl departimpl = new DepartmentServiceImpl();
		List<Department> Departments = departimpl.queryAllDepartment();
		request.setAttribute("Departments", Departments);
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		/*
		 * PrintWriter pw = response.getWriter(); pw.println("<h1>啊啊啊啊啊</h1>");
		 * pw.flush(); pw.close();
		 */
	}
	
	private void addDepart(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		System.out.println("456");
		  request.setCharacterEncoding("utf-8");
		
		  int deptno =Integer.parseInt( request.getParameter("deptno"));
		  //String deptno = (String)request.getAttribute("deptno");
		  String deptname = (String)request.getParameter("deptname"); 
		
		  String deptmanager = (String)request.getParameter("deptmanager");
		  
		  Department department = new Department(deptno,deptname,deptmanager);
		  DepartmentServiceImpl departimpl = new DepartmentServiceImpl(); 
		  boolean addresult = departimpl.addDepartment(department);
		  if(addresult) 
			  request.setAttribute("result", "addYES");
		  else
			  request.setAttribute("result", "NO");
		  
		  
		  request.getRequestDispatcher("queryDepart.do").forward(request,response); 
		  
		  response.setContentType("text/html;charset=utf-8");
		 
	}
	
	private void deleteDepart(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		System.out.println("789");
		request.setCharacterEncoding("utf-8");
		int deptno =Integer.parseInt(request.getParameter("deptno"));
		System.out.println(deptno);
		 DepartmentServiceImpl departimpl = new DepartmentServiceImpl(); 
		 departimpl.deleteDepartmentBydno(deptno);
		 request.getRequestDispatcher("queryDepart.do").forward(request,response); 
		 response.setContentType("text/html;charset=utf-8");
		 
	}
	
	private void updateDepart(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		System.out.println("101112");
		
		int updatedDno =Integer.parseInt(request.getParameter("updatedDno"));
		System.out.println(updatedDno);
		
		  DepartmentServiceImpl departimpl = new DepartmentServiceImpl(); 
		
		  String deptname = (String)request.getParameter("deptname"); 
		
		  String deptmanager = (String)request.getParameter("deptmanager");
		  
		  Department department = new Department(updatedDno,deptname,deptmanager);
		  
		  boolean updateResult = departimpl.UpdateDepartmentByDno(updatedDno, department);
		  
		  if(updateResult) 
			  request.setAttribute("result", "updateYES");
		  else
			  request.setAttribute("result", "NO");
		  
		  request.getRequestDispatcher("queryDepart.do").forward(request,response); 
		  response.setContentType("text/html;charset=utf-8");
	  	  
		
	}
	
	private void queryDepartBydno(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		System.out.println("131415");
		int keyword = Integer.parseInt(request.getParameter("keyword"));
		System.out.println(keyword);
		DepartmentServiceImpl departimpl = new DepartmentServiceImpl(); 
		
		String method=request.getParameter("method");
		System.out.println(method);
		
		List<Department> Departments=new ArrayList<Department>();
		if(method.equals("DNO")) {
			
			Department department = departimpl.queryDepartmentByDno(keyword);
			if(department!=null) {
			Departments.add(department);
			request.setAttribute("Departments", Departments);
			}
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	

}
