<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
             <title>User Login</title>
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
				<h3>User Login</h3> 
			 <c:if test="${err!=null}">
			      <p class="error">${err}</p>
			 </c:if>
			 
			<c:if test="${param.act eq 'lo'}">
			      <p class="sucess">Logout sucessfull</p>
			 </c:if>
			 
			 <c:if test="${param.act eq 'reg'}">
			      <p class="sucess">registration sucessfull. pls login</p>
			 </c:if>
			 <!-- we we press the login teh we are submitting the request to the login page-->
			 <s:url var="url_login" value="/login"/>
				<f:form action="${url_login}" modelAttribute="command">

					<table border="1">
						<tr>
							<td>Username</td>
							<td><f:input path="loginName"/></td>
						</tr>
						<tr>
							<td>password</td>
							<td><f:password path="password" /></td>
						</tr>
						<tr>

							<td colspan="2" align="right">
								<button>Login</button> <br>
								<a href="#">New User Registration</a>
							</td>

						</tr>
					</table>
             </f:form>
		</tr>
			


	</table>

</body>
</html>