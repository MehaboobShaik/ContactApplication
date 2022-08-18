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
				<c:if test="${param.act eq 'sv'}">
			      <p class="sucess">Contact saved sucessfully</p>
			 </c:if> 
			 <c:if test="${param.act eq 'del'}">
			      <p class="sucess">Contact deleted sucessfully</p>
			 </c:if> 
			  <c:if test="${param.act eq 'ed'}">
			      <p class="sucess">Contact updated sucessfully</p>
			 </c:if> 
			  <c:if test="${param.act eq 'muldel'}">
			      <p class="sucess">Contacts deleted sucessfully</p>
			 </c:if> 
			
	  <table>
	     <tr> 
	     <td align ="right">
			 <form action="<s:url value="/user/contact_search"/>">
			    <input type ="text" name="freeText" value="${param.freeText}" placeholder="Enter Text To Search">
			            <button>Find</button>
			 </form>
			  <br>
	      </td>
		  </tr>
	   </table>
			  
			 <form action="<s:url value="/user/bulk_cdelete"/>">
			    <button>Delete Selected Records</button> <br></br>
			 
				<table border="1" cellpadding="5">
					<tr>
						<th>SELECT</td>
						<th>Contact ID</td>
						<th>Name</td>
						<th>Phone</td>
						<th>Email</td>
						<th>Address</td>
						<th>Remark</td>
						<th>Action</td>
					</tr>
					<c:forEach var="c" items="${contactList}" varStatus="st">
					<tr>
					    <td align = "center"><input type="checkbox" name="cid" value="${c.contactId}"/></td>
						<td>${c.contactId}</td>
						<td>${c.name}</td>
						<td>${c.phone}</td>
						<td>${c.email}</td>
						<td>${c.address}</td>
						<td>${c.remark}</td>
						<s:url var="url_del" value="/user/del_contact">
						<s:param name ="cid" value ="${c.contactId}"/>
						</s:url>
						<s:url var="url_edit" value="/user/edit_contact">
						<s:param name ="cid" value ="${c.contactId}"/>
						</s:url>
						<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
					</tr>
					</c:forEach>
					<c:if test="${empty contactList}">
					<tr>
					   <td colspan="8" class="error" align="center">no records present</td>
					</tr>
					</c:if>
				</table>
			</form>
			</td>
		</tr>
		<tr>
			<td height="25px""><jsp:include page="include/footer.jsp" /></td>
		</tr>


	</table>

</body>
</html>