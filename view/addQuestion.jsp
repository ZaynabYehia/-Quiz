<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
	<head>
		<link href="/webjars/bootstrap/3.4.0/css/bootstrap.min.css" rel = "stylesheet">
		<title>Add Question</title>
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
			<p><font color = "red">${errorMessage}</font></p>
			<form action = "/questions/${title}" method = "post">
				<div class="form-group">
				    <label for="statement">Statement</label>
				  	<input type="text" name = "statement" class="form-control" id="statement"  placeholder="Enter Statement">
				</div>
				<div class="form-group">
				    <label for="choice1">Choice1</label>
				    <input type="text" name = "choice1" class="form-control" id="choice1"  placeholder="Enter Choice1">
				</div>
				<div class="form-group">
				    <label for="choice2">Choice2</label>
				    <input type="text" name = "choice2" class="form-control" id="choice2"  placeholder="Enter Choice2">
				</div>
				<div class="form-group">
				    <label for="choice3">Choice3</label>
				    <input type="text" name = "choice3" class="form-control" id="choice3"  placeholder="Enter choice3">
				</div>
				<div class="form-group">
				    <label for="choice4">Choice4</label>
				    <input type="text" name = "choice4" class="form-control" id="choice4"  placeholder="Enter choice4">
				</div>
				<div class="form-group">
				    <label for="correctChoice">Correct Choice</label>
				    <input type="text" name = "correctChoice" class="form-control" id="correctChoice"  placeholder="Enter Correct Choice">
				</div>
				<input type="submit" class="btn btn-primary" value = "Submit"/>
			</form>	
		</div>
	</body>
	
	<script src="webjars/jquery/3.3.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</html>