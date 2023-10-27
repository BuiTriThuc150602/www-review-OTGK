<%@ page import="vn.edu.iuh.fit.backend.modals.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 02</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>
<div class="container">
    <h1 class="text-center">Candidates Use Gmail</h1>
    <table class="table table-border table-striped table-hover">
        <thead class="table-info text-center">
        <th>ID</th>
        <th>Full Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th colspan="2"></th>
        </thead>
        <tbody>
        <%
            List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidatesUseGmail");
            if (candidates != null) {
                for (Candidate candidate : candidates) {
        %>
        <tr class="text-center">
            <td><%=candidate.getId()%></td>
            <td><%=candidate.getFullName()%></td>
            <td><%=candidate.getPhone()%></td>
            <td><%=candidate.getEmail()%></td>
            <td><a class="btn btn-outline-success" href="controller?action=viewDetailCandidate&can_id=<%=candidate.getId()%>">View</a></td>
        </tr>
        <%}}%>
        </tbody>
    </table>
    <a href="index.jsp" class="btn btn-outline-success">Home</a>



</div>

</body>
</html>
