<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>User Login Form</h1>
		<form action="login" method="post">
			<table>

				<tr>
					<td>User Name:</td>
					<td><input type="text" name="userLoginId"></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password"></td>
				</tr>

				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
					<td><a href="regcus.jsp">Registration</a></td>
				</tr>
			</table>


		</form>

	</div>
</body>
</html>