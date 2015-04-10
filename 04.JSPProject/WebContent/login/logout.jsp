<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<!-- logout.jsp -->
	
	<%
		session.removeAttribute("loginId");
		
		session.invalidate(); //세션에 있는 값들 다 지워버리는거.... 아니면 리무브 여러번 해야함!!
	
		response.sendRedirect("main.jsp");
	
	%>
    <!DOCTYPE html>
    <html>
    <head>
    	<title>JSP/Servlet Example</title>
    </head>
	<body>
	cousor
	</body>
	</html>