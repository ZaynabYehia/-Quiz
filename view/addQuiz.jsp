<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="/webjars/bootstrap/3.4.0/css/bootstrap.min.css" rel = "stylesheet">
		<meta charset="UTF-8">	
		<title>Add Quiz</title>
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
		      <li><a href="#">Page 3</a></li>
		    </ul>
		  </div>
		</nav>
		
		<div class = "container">
			<form action = "/quizzes" method = "post">
				<div class="form-group">
				    <label for="title">Title</label>
				  	  <input type="text" name = "title" class="form-control" id="title"  placeholder="Enter Title">
				</div>
				<div class="form-group">
				    <label for="skill">Skill</label>
				    <input type="text" name = "skill" class="form-control" id="skill"  placeholder="Enter Skill">
				</div>
				<div class="form-group">
				    <label for="passScore">Pass Score</label>
				    <input type="number" name = "passScore" class="form-control" id="passScore"  placeholder="Enter Pass Score">
				</div>
				<div class="form-group">
				    <label for="duration">Duration</label>
				    <input type="number" name = "duration" class="form-control" id="duration"  placeholder="Enter Duration">
				</div>
				<input type="submit" class="btn btn-primary" value = "Submit"/>
			</form>	
		</div>
		
		<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"></script>
		
	</body>
</html>
