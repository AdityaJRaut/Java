<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
response.setHeader("Pragma", "no-cache"); // HTTP 1.0
response.setDateHeader("Expires", 0); // Proxies
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile Updated</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Modal HTML -->
	<div class="modal fade" id="successModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5">Employee Management</h1>
				</div>
				<div class="modal-body text-center">
					 Registration Successful!
					 You will able to login once admin approves!
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.4/dist/js/bootstrap.bundle.min.js"></script>

	<!-- Modal Trigger Script -->
	<script>
	    document.addEventListener("DOMContentLoaded", function () {
	        const modal = new bootstrap.Modal(document.getElementById('successModal'));
	        modal.show();

	        // Auto-redirect after 3 seconds
	        setTimeout(() => {
	            window.location.href = "login.jsp";
	        }, 3000);
	    });
	</script>
</body>
</html>
