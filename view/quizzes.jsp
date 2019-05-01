<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
	<head>
		<link href="/webjars/bootstrap/3.4.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>Quizzes</title>
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
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
		    </ul>
		  </div>
		</nav>
		
		<div class = "container">
			<table class = "table table-hover">
				<tr>
					<th>Title</th>
					<th>Skill</th>
					<th>Duration</th>
					<th>Pass Score</th>
					<th>Number Of Question</th>
					<th>Add Question</th>
					<th>Take Quiz</th>	
				</tr>
				<c:forEach items="${quizzes}" var="quiz">
					<tr>
						<td>${quiz.title}</td>
						<td>${quiz.skill}</td>
						<td>${quiz.duration}</td>
						<td>${quiz.passScore}</td>
						<td>${quiz.numberOfQuestion}</td>
						<td><a href = "/questions/${quiz.title}" class="btn btn-primary">Add</a></td>
						<td><a href = "/questions/takequiz/${quiz.title}" class="btn btn-primary">Take</a></td>
					</tr>
				</c:forEach>		
			</table>
		</div>
		
		<footer class="footer">
			<div><a href="/quizzes/addQuiz" class="btn btn-primary btn-lg btn-block">Add Quiz</a></div>
		</footer>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	</body>
</html>