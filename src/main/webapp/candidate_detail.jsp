<%@ page import="vn.edu.iuh.fit.backend.modals.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.modals.Experience" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidate Detail</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Candidate detail</h1>
    <%
        Candidate candidate = (Candidate) request.getAttribute("candidate");
        List<Experience> experiences = (List<Experience>) request.getAttribute("experiences");
    %>
    <div class="form">
        <div class="row">
            <div class="col">
                <label for="can_id" class="form-label">ID</label>
                <input type="text" value="<%=candidate.getId()%>" id="can_id" class="form-control">
            </div>
            <div class="col">
                <label for="can_name" class="form-label">Full Name</label>
                <input type="text" value="<%=candidate.getFullName()%>" id="can_name"
                       class="form-control">
            </div>
        </div>
        <div class="row">
            <div class="col">
                <label for="can_phone" class="form-label">Phone</label>
                <input type="text" value="<%=candidate.getPhone()%>" id="can_phone"
                       class="form-control">
            </div>
            <div class="col">
                <label for="can_email" class="form-label">Email</label>
                <input type="text" value="<%=candidate.getEmail()%>" id="can_email"
                       class="form-control">
            </div>
        </div>
        <div class="row">
            <table class="table table-border table-striped table-hover">
                <thead class="text-center table-info">
                <th>Company</th>
                <th>From Date</th>
                <th>To Date</th>
                <th>Roles</th>
                </thead>
                <tbody>
                <%for (Experience ex : experiences) {%>
                <tr>
                    <td><%=ex.getCompanyName()%></td>
                    <td><%=ex.getFormDate()%></td>
                    <td><%=ex.getToDate()%></td>
                    <td><%=ex.getRole().name()%></td>
                </tr>
                <%}%>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
