<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
             <title>Contact Form</title>
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
				<h3>Adding New Contact</h3> 
			 <c:if test="${err!=null}">
			      <p class="error">${err}</p>
			 </c:if>
			 
			 <s:url var="url_csave" value="/user/save_contact"/>
				<f:form action="${url_csave}" modelAttribute="command">

					<table border="1">
						<tr>
							<td>Name</td>
							<td><f:input path="name"/></td>
						</tr>
						<tr>
							<td>Phone</td>
							<td><f:input path="phone"/></td>
						</tr>
						<tr>
							<td>Email</td>
							<td><f:input path="email"/></td>
						</tr>
						<tr>
							<td>Address</td>
							<td><f:textarea path="address"/></td>
						</tr>
						<tr>
							<td>Remark</td>
							<td><f:textarea path="remark"/></td>
						</tr>
					
						<tr>

							<td colspan="2" align="right">
								<button>save</button> <br>
							</td>

						</tr>
					</table>
             </f:form>
		</tr>
			


	</table>

</body>
</html>