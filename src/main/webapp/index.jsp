<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Home</h1>
<ul class="list-group">
    <li class="list-group-item"><a class="btn btn-outline-info" href="controller?action=getAllCandidate">Candidate</a></li>
    <li class="list-group-item"><a class="btn btn-outline-info" href="controller?action=getCandidateByRole">Report 01</a></li>
    <li class="list-group-item"><a class="btn btn-outline-info" href="controller?action=getCandidateUseGmail">Report 02</a></li>
</ul>
</div>
</body>
</html>