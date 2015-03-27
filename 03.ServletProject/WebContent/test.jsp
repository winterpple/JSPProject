<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
    
    <head>
    	<title>JSP/Servlet Example</title>
    	<style>
    	/*CSS 주석은 일케쓴당*/
    		body{
    			background-image:url("molang.png");
    			background-repeat:no-repeat;
    			background-attachment:fixed;
    		}
    		input, select, textarea{
    			border:green 2pt dashed;
    			color:red;
    			font-size:50px;
    			background-color:pink;
    		}
    	
    	</style>
    	<script>
    		function gofunc(){
    			alert("Hello JavaScript!");
    		}
    	</script>
    	
    	
    </head>
    
	<body>
	<!-- test.jsp -->
	<h1>request test</h1>
	<hr>
	<form action="TestServlet" onsubmit="return gofunc()">
		<label for="name"> 이름 : </label><input type="text" id="name" name="name"><br>
		<label for="pwd"> 비밀번호 : </label><input type="password" id="pwd" name="pwd"><br>
		<input type="radio" name="gender" value="남자"> 남자
		<input type="radio" name="gender" value="여자"> 여자<br>
		
		<input type="checkbox" name="hobby" value="축구">축구
		<input type="checkbox" name="hobby" value="야구">야구
		<input type="checkbox" name="hobby" value="농구">농구 <br>		
		
		<input type="color" name="mycolor"><br>
		<input type="email" name="myEmail"><br>
		
		<select name="subject">
			<option value="java">Java</option>
			<option value="jsp">JSP</option>
			<option value="html">HTML</option>
		</select>
		
		<textarea rows="20" cols="50" name="txt"></textarea><br>
		
		<input type="submit" value="서버로 제출"><br>
	</form>
	</body>
	
	</html>