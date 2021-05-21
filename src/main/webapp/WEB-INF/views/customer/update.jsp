<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>고객 정보 변경</h1>
	<form method="POST">
	<div>
		<label for="custid">고객아이디: </label>
		<input id="custid" name="custid" type="number" value="${item.custid}">
	</div>
	<div>
		<label for="name">고객 이름: </label>
		<input id="name" name="name" type="text" value="${item.name}">
	</div>
	<div>
		<label for="address">고객 주소: </label>
		<input id="address" type="text" name="address" value="${item.address}">
	</div>
	<div>
		<label for="phone">고객 휴대번호: </label>
		<input id="phone" type="text" name="phone" value="${item.phone}">
	</div>
	<div>
		<input type="submit" value="Submit">
	</div>
	
	</form>
</body>
</html>