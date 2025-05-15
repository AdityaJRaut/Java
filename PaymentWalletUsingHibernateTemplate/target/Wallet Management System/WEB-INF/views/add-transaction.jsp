<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Transaction</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<c:if test="${not empty error}">
    <div class="alert alert-danger">${error}</div>
</c:if>
<div class="container mt-5">
    <div class="card">
        <div class="card-header bg-success text-white">
            <h2 class="mb-0">Add Transaction</h2>
        </div>
        <div class="card-body">
            <form action="save" method="post">
                <div class="mb-3">
                    <label for="type" class="form-label">Type</label>
                    <select name="type" id="type" class="form-select">
                        <option value="CREDIT">CREDIT</option>
                        <option value="DEBIT">DEBIT</option>
                    </select>
                </div>

                <div class="mb-3">
                    <label for="amount" class="form-label">Amount</label>
                    <input type="text" name="amount" id="amount" class="form-control" required/>
                </div>

                <div class="mb-3">
                    <label for="description" class="form-label">Description</label>
                    <input type="text" name="description" id="description" class="form-control" required/>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
                <a href="<c:url value='/'/>" class="btn btn-secondary">Cancel</a>
            </form>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
