<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:set var="pageTitle" scope="request" value="Students" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Students</h3>
		</div>
		<div class="card-body">
			<div class="table-responsive">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Father's Name</th>
						<th>Email</th>
						<th>Class</th>
						<th>Age</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${students}" var="student">
						<tr>
							<td>${student.firstName}</td>
							<td>${student.lastName}</td>
							<td>${student.fatherName}</td>
							<td>${student.email}</td>
							<td>${student.studentClass}</td>
							<td>${student.studentAge}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>