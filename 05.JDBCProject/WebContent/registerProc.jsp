<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
  
    <%
    
    // 0. 요청 처리
    request.setCharacterEncoding("UTF-8");//POST방식일 때 한글처리
    String id = request.getParameter("id");
    String pass = request.getParameter("pwd");
    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String age = request.getParameter("age");
    String gender = request.getParameter("gender");
  //  out.print(id);
  // 어떨때는 필요하고, 필요 없을 수도 있음..
  
  //1.JDBC 드라이버 로드
    Class.forName("oracle.jdbc.driver.OracleDriver");
  //>WebContent >WEP_INF>lib>ojdbc6.jar
  //웹브라우저 <---> |JSP| (톰캣) <--(JDBC)---> |Oracle| (서버)
    //2. 데이터 베이스와 연결
    
   	Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jspuserc","jsp1234");
	//서버 연결 주소/아이디/패스워드
	//접속자 두개.. 클라이언트 2개고 서버는 1개
	
	
    //3. SQL문 실행
    //1) Statement 객체 이용
    /*String sql = "insert into member values('" +id+"', '"+pass+"', '홍길동', 20, '1', '대한민국 서울시', '2015-04-17')";

    Statement stmt = con.createStatement(); //위의 문장 sql임을 알려줌
  	int result = stmt.executeUpdate(sql);	//애 없으면 위에 두줄 실항 ㄴ //알트+X 한거랑 똑같음... 멤버 에스큐엘보면댐
    out.print(result); */
    //2) PreparedStatement 객체이용... -> 앞으로 이것만 쓰기! 위에꺼는 해킹 ㅜㅜ 이거 좋은점 하나가 위의ㅏ 더하기 안해도댐 
    String sql = "insert into member values(?,?,?,?,?,?, default)";
    PreparedStatement pstmt = con.prepareStatement(sql);
    
    //바인딩
    pstmt.setString(1, id); //물음표중의 첫번째 것.. 데이터베이스에선 id당... 문자열이라 셋 스트링
    pstmt.setString(2, pass); //물음표중의 두번째.. 멤버 에스큐엘.. 뒤의 패스는 여기의 pass
    pstmt.setString(3, name);
    pstmt.setInt(4, Integer.parseInt(age)); //String은 참조형... Int는 기본형.. 기본형과 참조형은 pstmt.setInt(4, (int) age); 이렇게 바꾸면안댐
    pstmt.setString(5,gender);
    pstmt.setString(6,addr);
    
    
    
    int result = pstmt.executeUpdate();
  	out.print(result);
    
    
    //4. 데이터 베이스와 연결 끊음
    pstmt.close();
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