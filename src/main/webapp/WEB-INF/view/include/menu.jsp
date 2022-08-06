<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>

<s:url var="url_logout" value="/logout"/>
<s:url var="url_reg_from" value="/reg_form"/>
<s:url var="url_uhome" value="/user/dashboard"/>
<s:url var="url_cform" value="/user/contact_form"/>



<c:if test="${sessionScope.userId == null }">
  <a href="#">Home</a> | <a href="#">Login</a> | <a href="${url_reg_from}">Register</a> | 
   <a href="#">About</a> | <a href="#">help</a> 
</c:if>

		
<c:if test="${sessionScope.userId != null && sessionScope.role == 1}">
	<a href="#">Home</a> |<a href="#">User List</a> | <a href="${url_logout}">LogOut</a>
</c:if>


<c:if test="${sessionScope.role != null && sessionScope.role == 2}">
	<a href="${url_uhome}">Home</a> |<a href="${url_cform}">Add Contact</a> | <a href="#">Contact List</a> |
	 <a href="${url_logout}">LogOut</a>
</c:if>