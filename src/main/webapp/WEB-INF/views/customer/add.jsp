<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="POST">
	<h1>고객 정보 입력</h1>
	<div>
		<label for="custid">고객 아이디: </label>
		<input name="custid" type="number" id="custid">
	</div>
	<div>
		<label for="name">고객 이름: </label>
		<input name="name" type="text" id="name"/>
	</div>
	<div>
		<label for="address">고객 주소: </label>
		<input name="address" type="text" id="address"/>
	</div>
	<div>
		<label for="phone">고객 휴대번호: </label>
		<input name="phone" type="text" id="phone"/>
	</div>
	<div>
		<input type="submit" value="Submit"/>
	</div>
	</form>
	
		
</body>
</html>