<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Logged Out</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<%
session.invalidate();
%>
<script type="text/javascript">
	let seconds = 4;

	function startTimer() {
		const timerDisplay = document.getElementById("timer");

		const interval = setInterval(function() {
			seconds--;
			timerDisplay.textContent = seconds;

			if (seconds == 0) {
				clearInterval(interval);
				window.location.href = "login.jsp"; // Redirect
			}
		}, 1000);
	}

	window.onload = startTimer;
</script>
</head>

<body class="d-flex align-items-center justify-content-center vh-100">
	<div class="text-center">
		<h2>
			Redirecting in <span id="timer">4</span> seconds...
		</h2>
		<h2>Thank you for using the application!</h2>
		<p>You have been successfully logged out.</p>
		<a href="login.jsp" class="btn btn-primary">Go to Login</a>
	</div>
</body>

</html>
