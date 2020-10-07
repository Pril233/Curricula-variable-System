<%@page import="org.System.entity.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>CourseIndex</title>
<link rel="stylesheet" href="css/selectCourseIndex.css">
<script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
 <script  type="text/javascript">  
      $(function(){  
         var $table = $("#tb");  
         var currentPage = 0;//当前页默认值为0  
         var pageSize = 5;//每一页显示的数目  
         $table.bind('paging',function(){  
             $table.find('tbody tr').hide().slice(currentPage*pageSize,(currentPage+1)*pageSize).show();  
         });       
         var sumRows = $table.find('tbody tr').length;  
         var sumPages = Math.ceil(sumRows/pageSize);//总页数  
           
         var $pager = $('<div class="page"></div>');  //新建div，放入a标签,显示底部分页码  
         for(var pageIndex = 0 ; pageIndex<sumPages ; pageIndex++){  
             $('<a href="#" id="pageStyle" οnclick="changCss(this)"><span>'+(pageIndex+1)+'</span></a>').bind("click",{"newPage":pageIndex},function(event){  
                 currentPage = event.data["newPage"];  
                 $table.trigger("paging");  
                   //触发分页函数  
                 }).appendTo($pager);  
                 $pager.append(" ");  
             }     
             $pager.insertAfter($table);  
             $table.trigger("paging");  
               
             //默认第一页的a标签效果  
             var $pagess = $('#pageStyle');  
             //$pagess[0].style.backgroundColor="#006B00";  
             //$pagess[0].style.color="#ffffff";  
    });  
      
    //a链接点击变色，再点其他回复原色  
      function changCss(obj){  
        var arr = document.getElementsByTagName("a");  
        for(var i=0;i<arr.length;i++){     
         if(obj==arr[i]){       //当前页样式  
          obj.style.backgroundColor="#006B00";  
          obj.style.color="#ffffff";  
        }  
         else  
         {  
           arr[i].style.color="";  
           arr[i].style.backgroundColor="";  
         }  
        }  
     }      
  </script> 

</head>

<body>


<%
	List<MyCourses> MyCourses =(List<MyCourses>) request.getAttribute("MyCourses");
	List<Course> Courses =(List<Course>) request.getAttribute("Courses");
	List<Teacher> Teachers =(List<Teacher>) request.getAttribute("Teachers");
	List<Sct> Scts = (List<Sct>)request.getAttribute("Scts");
	Student student = (Student)session.getAttribute("student");

%>


<%
	if(Teachers!=null && Courses!=null){
%>

<table border="1px" id="tb">
<thead>	
		<tr>
		<th>CNO</th>
		<th>CNAME</th>
		<th>CPNO</th>
		<th>TNO</th>
		<th>TNAME</th>
		<th>操作</th>
		</tr>
	</thead>
<%
	for(int i=0;i<Teachers.size();i++){
			
		for(int j=0;j<Courses.size();j++){
			if(Teachers.get(i).getCno1()==Courses.get(j).getCno()){
				%>
				
			<tbody>
				<tr>
				<td><%= Courses.get(j).getCno()%></td>
				<td><%= Courses.get(j).getCname() %></td>
				<td><%= Courses.get(j).getCpno() %></td>
				<td><%= Teachers.get(i).getTno() %></td>
				<td><%= Teachers.get(i).getTname() %></td>
				<td><a href="addSct.In?cno=<%=Courses.get(j).getCno()%>&cpno=<%=Courses.get(j).getCpno()%>&tno=<%=Teachers.get(i).getTno()%>">选课</a></td>
				</tr>
	
				<% 
			}
			if(Teachers.get(i).getCno2()==Courses.get(j).getCno()){
				%>
			
				<tr>
				<td><%= Courses.get(j).getCno()%></td>
				<td><%= Courses.get(j).getCname() %></td>
				<td><%= Courses.get(j).getCpno() %></td>
				<td><%= Teachers.get(i).getTno() %></td>
				<td><%= Teachers.get(i).getTname() %></td>
				<td><a href="addSct.In?cno=<%=Courses.get(j).getCno()%>&cpno=<%=Courses.get(j).getCpno()%>&tno=<%=Teachers.get(i).getTno()%>">选课</a></td>
				</tr>
				<% 
			}
			if(Teachers.get(i).getCno3()==Courses.get(j).getCno()){
				%>
				<tr>
				<td><%= Courses.get(j).getCno()%></td>
				<td><%= Courses.get(j).getCname() %></td>
				<td><%= Courses.get(j).getCpno() %></td>
				<td><%= Teachers.get(i).getTno() %></td>
				<td><%= Teachers.get(i).getTname() %></td>
				<td><a href="addSct.In?cno=<%=Courses.get(j).getCno()%>&cpno=<%=Courses.get(j).getCpno()%>&tno=<%=Teachers.get(i).getTno()%>">选课</a></td>
				</tr>
			</tbody>
				<% 
			}
		}
	}
}

%>

</table>


<table border="1px">


		<tr>
		<th>CNO</th>
		<th>CNAME</th>
		<th>TNAME</th>
		<th>操作</th>
		</tr>

	
	<%
	for(MyCourses mycourse:MyCourses){
		%>
		

			<tr>
			<td><%=mycourse.getCno() %></td>
			<td><%=mycourse.getCname() %></td>
			<td><%=mycourse.getTname()  %></td>
			
			<td><a href="deleteSct.In?cno=<%=mycourse.getCno() %>">退课</a></td>
			</tr>
	
			<% 
	}

	%>


</table>




</body>
</html>