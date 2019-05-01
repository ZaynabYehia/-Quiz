<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel=”stylesheet”
	href=”https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css”
	crossorigin=”anonymous”>
<link rel=”stylesheet”
	href=”//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css”>
<link rel=”stylesheet” href=”build.css”>
<meta charset="UTF-8">
<link href="/webjars/bootstrap/3.4.0/css/bootstrap.min.css"
	rel="stylesheet">
<title>Take Quiz</title>
<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">WebSiteName</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="/quizzes">Quizzes</a></li>
				<li><a href="#">Page 2</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#"><span class="glyphicon glyphicon-user"></span>
						Sign Up</a></li>
				<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>
						Login</a></li>
			</ul>
		</div>
	</nav>

	<p style="color: blue; font-size: 46px;">${quizTitle }</p>


	<script>
		setTimeout(function() {

			window.location.href = "/questions/TimeOut";
		}, 7000 * 60);
	</script>

	<form method="post"
		action="${pageContext.request.contextPath }/questions/takequiz/${quizTitle}/submit">
		<ol type="1">
			<c:forEach items="${questions }" var="question">
				<label for="radiobtn" class="col-sm-2 control-label">${question.statement}</label>
				<input type="hidden" name="questionStatement"
					value="${question.statement}">
				<div class="col-sm-5">
					<c:forEach var="choice" items="${question.choices}">
						<div class="radio radio-danger">
							<input type="radio" name="${question.statement }"
								value="${choice}"> <label> ${choice} </label>
						</div>
					</c:forEach>
				</div>
			</c:forEach>
		</ol>

		<br />

		<footer class="footer">
			<input type="submit" class="btn btn-primary" value="Submit">
		</footer>
	</form>
</body>
</html>