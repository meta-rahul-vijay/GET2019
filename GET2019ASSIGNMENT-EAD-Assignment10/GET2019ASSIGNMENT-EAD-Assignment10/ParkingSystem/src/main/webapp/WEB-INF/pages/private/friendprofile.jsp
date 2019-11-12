<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Friend Profile</title>
</head>
<body>

<nav>
		<div>
			<ul>
				<li>
					<a href="logout">Logout</a>
				</li>
				<li>
					<a href="homepage">Home</a>
				</li>
			</ul>
		</div>
	</nav>
	
	<div>
	<h1 align="center">Friend Profile</h1>
	<table align="center">
		
		<tr>
			<td>
				<label>Employee Id :</label>
			</td>
			<td>
				<label>${friendDTO.id}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Name : </label>
			</td>
			<td>
				<label>${friendDTO.name}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Gender : </label>
			</td>
			<td>
				<label>${friendDTO.gender}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Email : </label>
			</td>
			<td>
				<label>${friendDTO.email}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Contact Number : </label>
			</td>
			<td>
				<label>${friendDTO.phoneNumber}</label>
			</td>
		</tr>
		<tr>
			<td>
				<label>Company : </label>
			</td>
			<td>
				<label>${friendDTO.company}</label>
			</td>
		</tr>
		
	</table>
</div>
</body>
</html>