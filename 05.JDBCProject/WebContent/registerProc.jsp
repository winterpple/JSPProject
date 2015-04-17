<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
  
    <%
    
    // 0. 요청 처리
    
    String id = request.getParameter("id");
    String pass = request.getParameter("pwd");
  //  out.print(id);
    
  
  //1.JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver");
    //2. 데이터 베이스와 연결
    
   	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
	//서버 연결 주소/아이디/패스워드
	//접속자 두개.. 클라이언트 2개고 서버는 1개
	
	
    //3. SQL문 실행
    String sql = "insert into member values('" +id+"', '"+pass+"', '홍길동', 20, '1', '대한민국 서울시', '2015-04-17')";

    Statement stmt = con.createStatement(); //위의 문장 sql임을 알려줌
  	int result = stmt.executeUpdate(sql);	//애 없으면 위에 두줄 실항 ㄴ
    out.print(result); 
    //4. 데이터 베이스와 연결 끊음
    stmt.close();
    con.close();
    
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