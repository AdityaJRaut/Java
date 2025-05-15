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
<title>User Registration</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light">
	<%
	String error = (String) session.getAttribute("Registererror");
	String msg = (String) session.getAttribute("Registermsg");
	String role = (String) session.getAttribute("role");
	if(role==null){role="unassigned";}
	%>

	<%
	if (error != null) {
		session.removeAttribute("Registererror");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-danger alert-dismissible fade show"
			role="alert">
			<%=error%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	<%
	}
	%>

	<%
	if (msg != null) {
		session.removeAttribute("Registermsg");
	%>
	<div class="container mt-3 text-center">
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<%=msg%>
			<button type="button" class="btn-close" data-bs-dismiss="alert"
				aria-label="Close"></button>
		</div>
	</div>
	<%
	}
	%>
	<!-- Bootstrap Modal -->
	<div class="modal fade" id="validationModal" tabindex="-1"
		aria-labelledby="modalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-warning">
					<h5 class="modal-title" id="modalLabel">Validation Error</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body" id="modalMessage">
					<!-- Dynamic error message goes here -->
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">OK</button>
				</div>
			</div>
		</div>
	</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

	<script>
		window.addEventListener('DOMContentLoaded', function() {
			setTimeout(function() {
				const alerts = document.querySelectorAll('.alert');
				alerts.forEach(function(alertNode) {
					const alert = bootstrap.Alert
							.getOrCreateInstance(alertNode);
					alert.close();
				});
			}, 4000);
		});
	</script>

	<div class="container mt-5">

		<div class="card mx-auto" style="max-width: 400px;">
			<div class="mt-3 ms-3">
				<%
				if (role.equals("admin")) {
				%>
				<a href="admin-home.jsp" class="btn btn-secondary mb-3">🏠 Home</a>
				<%
				}
				%>
			</div>
			<div class="card-body">

				<h3 class="card-title text-center mb-4">Register</h3>

				<form action="RegisterServlet" method="post">
					<div class="mb-3">
						<label class="form-label">Name</label> <input type="text"
							name="fname" class="form-control" required>
					</div>
					<div class="mb-3">
						<label class="form-label">Username</label> <input type="text"
							name="username" class="form-control" pattern="^\S+$" required
							title="Username cannot contain spaces"
							onkeypress="return event.key !== ' '">
					</div>
					<div class="mb-3">
						<label class="form-label">Gender</label><br> <input
							type="radio" name="gender" value="Male" required> Male <input
							type="radio" name="gender" value="Female"> Female
					</div>

					<div class="mb-3">
						<label class="form-label">Password</label> <input type="password"
							name="password" class="form-control" required
							title="Password must be at least 8 characters long and include uppercase, lowercase, number, and special character.">
					</div>

					<div class="mb-3">
						<label class="form-label">Confirm Password</label> <input
							type="password" id="confirmPassword" name="confirm_password"
							class="form-control" required>
					</div>

					<div class="d-grid">
						<button type="submit" class="btn btn-primary">Register</button>
					</div>
				</form>
				<%
				if (role == null || !role.equals("admin")) {
				%>
				<div class="text-center mt-3">
					<p class="mb-0">
						Already registered? <a href="login.jsp">Login here</a>
					</p>
				</div>
				<%
				}
				%>

			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
	<script>
		function showBootstrapModal(message) {
			const modalMessage = document.getElementById("modalMessage");
			modalMessage.textContent = message;

			const validationModal = new bootstrap.Modal(document
					.getElementById('validationModal'));
			validationModal.show();
		}

		document
				.querySelector("form")
				.addEventListener(
						"submit",
						function(e) {
							const name = document
									.querySelector('input[name="fname"]').value
									.trim();
							const username = document
									.querySelector('input[name="username"]').value
									.trim();
							const password = document
									.querySelector('input[name="password"]').value;
							const confirmPassword = document
									.querySelector('input[name="confirm_password"]').value;
							const genderSelected = document
									.querySelector('input[name="gender"]:checked');

							const nameRegex = /^[A-Za-z\s]+$/;
							if (!nameRegex.test(name)) {
								showBootstrapModal("Name must contain only letters and spaces.");
								e.preventDefault();
								return;
							}

							if (username.includes(" ")) {
								showBootstrapModal("Username must not contain spaces.");
								e.preventDefault();
								return;
							}

							if (!genderSelected) {
								showBootstrapModal("Please select your gender.");
								e.preventDefault();
								return;
							}

							const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[\W_]).{8,}$/;
							if (!passwordRegex.test(password)) {
								showBootstrapModal("Password must be at least 8 characters long and include uppercase, lowercase, number, and special character.");
								e.preventDefault();
								return;
							}

							if (password !== confirmPassword) {
								showBootstrapModal("Passwords do not match.");
								e.preventDefault();
								return;
							}
						});
	</script>


</body>
</html>
