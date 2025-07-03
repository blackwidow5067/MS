<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import = "com.wipro.model.Student"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to spring mvc </h1>
<br/>
 
<%-- <%
   Student student = (Student)request.getAttribute("xyz");
%>
<%=student%> --%>
 
<h2>Student Details</h2>
    <p><strong>Student ID:</strong> ${xyz.stid}</p>
    <p><strong>Student Name:</strong> ${xyz.stname}</p>
</body>
</html>