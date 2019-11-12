<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="pageTitle" scope="request" value="Add Student" />
<%@include file="../includes/header.jsp"%>
<div class="container" style="margin-top: 60px">
	<div class="card">
		<div class="card-header">
			<h3 class="card-title">Add Student Details</h3>
		</div>
		<div class="card-body">
			<form:form modelAttribute="student">
				<form:errors cssClass="text-danger" />
				<div class="form-group">
					<form:label path="firstName">First Name</form:label>
					<form:input path="firstName" type="text" class="form-control" id="student_first_name"
						placeholder="First Name" />
					<form:errors path="firstName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="lastName">Last Name</form:label>
					<form:input path="lastName" type="text" class="form-control" id="student_last_name"
						placeholder="Last Name" />
					<form:errors path="lastName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="fatherName">Father's Name</form:label>
					<form:input path="fatherName" type="text" class="form-control" id="student_father_name"
						placeholder="Father's Name" />
					<form:errors path="fatherName" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="email">Email address</form:label>
					<form:input path="email" type="email" class="form-control" id="student_email"
						placeholder="Email" />
					<form:errors path="email" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="studentClass">Class</form:label>
					<form:input path="studentClass" type="text" class="form-control" id="student_class"
						placeholder="Class" />
					<form:errors path="studentClass" cssClass="text-danger" />
				</div>
				<div class="form-group">
					<form:label path="studentAge">Age</form:label>
					<form:input path="studentAge" type="text" class="form-control" id="student_age"
						placeholder="Age" />
					<form:errors path="studentAge" cssClass="text-danger" />
				</div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form:form>
		</div>
	</div>
</div>
<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>