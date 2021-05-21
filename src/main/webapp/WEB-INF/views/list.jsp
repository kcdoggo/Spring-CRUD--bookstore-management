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
      <h1>도서 목록</h1>
      <table border="1">
         <thead>
            <tr> 
               <td>도서번호</td>
               <td>도서명</td>
               <td>출판사</td>
               <td>가격</td>
               <td>관리</td>
            </tr>
         </thead>
         <tbody>
            <c:if test="${list.size() < 1}">
               <tr>
                  <td colspan="5">등록 된 도서가 없습니다.</td>
               </tr>
            </c:if>
            <c:forEach var="item" items="${list}">
               <tr>
                  <td>${item.bookid}</td>
                  <td>${item.bookname}</td>
                  <td>${item.publisher}</td>
                  <td>${item.price}</td>
                  <td><a href="delete?bookid=${item.bookid}">삭제</a> <a href="update?bookid=${item.bookid}">변경</a></td>
               </tr>
            </c:forEach>
            
         </tbody>
      </table>
   </div>
      <a href="add">등록</a>
</body>
</html>