<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
             <title>User-List</title>
       <s:url var="url_css" value="/static/css/style.css" />
    <link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="static/images/loginpage.jsp" />
<body background ="${url_bg}">
	<table style="margin-left: 140px;" border="1" width="80%">

		<tr>
			<td height="80px" width="80%" align="center">
				<!-- Header -->
			    <jsp:include page="include/header.jsp"/>
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- menu -->
				<jsp:include page="include/menu.jsp"/>
				
			</td>
		</tr>
		<tr>

			<td height="350px" valign="top">
				<!-- pageContent -->
				<h1>User-List</h1>
	   <table border="1" cellpadding="11">
		  <tr>
		        <td>SR</td>
		        <td>User Id</td>
				<td>Name</td>
				<td>Phone</td>
				<td>Address</td>
				<td>Email</td>
				<td>user name</td>
				<td>Login status</td>
			</tr>
		 <c:forEach var ="u" items="${userList}" varStatus="st">
		   
		    <tr>
		        <td>${st.count}</td>
				<td>${u.userId}</td>
				<td>${u.name}</td>
				<td>${u.phone}</td>
				<td>${u.email}</td>
				<td>${u.address} </td>
				<td>${u.loginName} </td>
				<td>${u.loginStatus} </td>
			</tr>
			
		 </c:forEach>
	  </table>
			</td>
		</tr>
		<tr>
			<td height="25px"">
			   <jsp:include page="include/footer.jsp"/>
			</td>
		</tr>


	</table>

</body>
</html>