<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact list Page</title>
<s:url var="url_css" value="/static/css/style.css" />
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<s:url var="url_bg" value="static/images/loginpage.jsp" />
<body background="${url_bg}">
	<table style="margin-left: 140px;" border="1" width="80%">

		<tr>
			<td height="80px" width="80%" align="center">
				<!-- Header --> <jsp:include page="include/header.jsp" />
			</td>
		</tr>
		<tr>
			<td height="25px">
				<!-- menu --> <jsp:include page="include/menu.jsp" />

			</td>
		</tr>
		<tr>

			<td height="350px" valign="top">
				<!-- pageContent -->
				<h3>Contact List</h3> 
				<table border="1">
					<tr>
						<td>Sr.no</td>
						<td>Contact ID</td>
						<td>Name</td>
						<td>Phone</td>
						<td>Email</td>
						<td>Address</td>
						<td>Remark</td>
						<td>Action</td>
					</tr>
					<c:forEach var="c" items="${contactList}" varStatus="st">
					<tr>
						<td>${st.count}</td>
						<td>${c.contactId}</td>
						<td>${c.name}</td>
						<td>${c.phone}</td>
						<td>${c.email}</td>
						<td>${c.address}</td>
						<td>${c.remark}</td>
						<td><button>Edit</button> | <button>Delete</button></td>
					</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
		<tr>
			<td height="25px""><jsp:include page="include/footer.jsp" /></td>
		</tr>


	</table>

</body>
</html>