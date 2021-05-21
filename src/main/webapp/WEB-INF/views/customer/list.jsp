<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
  
  <div>
  	<h1>고객정보</h1>
  	<table border="1">
  		<thead>
  			<tr>
  				<td>고객아이디</td>
  				<td>고객이름</td>
  				<td>고객주소</td>
  				<td>고객휴대번호</td>
  				<td>고객관리</td>
  			</tr>
  		</thead>
  		<tbody>
  			<c:if test="${list.size()<1}">
  			<tr>
  				<td colspan="5"> 등록된 고객의 정보가 없습니다</td>
  			</tr>
  			</c:if>
  			<c:forEach var="item" items="${list}">
  				<tr>
  					<td>${item.custid}</td>
   					<td>${item.name}</td>
   					<td>${item.address}</td>
   					<td>${item.phone}</td>
   					<td><a href="delete?custid=${item.custid}">삭제</a><a href="update?custid=${item.custid}">변경</a></td>
 
  				</tr>
  			</c:forEach>
  		</tbody>
  	
  	</table>
  
  </div>
  
  <a href="add">고객 추가하기</a>

</body>
</html>