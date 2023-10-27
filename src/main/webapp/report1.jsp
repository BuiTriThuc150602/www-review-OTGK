<%@ page import="vn.edu.iuh.fit.backend.modals.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="vn.edu.iuh.fit.backend.enums.Roles" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report 01</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container">
    <h1 class="text-center">Report 01</h1>
    <form class="form" action="controller" method="get">
        <div class="row">
            <input type="hidden" name="action" value="getCandidateByRole">
            <label for="selectRole" class="form-label">Candidate By Role</label>
            <select name="selectRole" class="form-control" id="selectRole">
                <%
                    for (Roles role : Roles.values()) {
                        if (role.name().equalsIgnoreCase(request.getParameter("selectRole"))) {
                %>
                <option value="<%=role.name()%>" selected><%=role.name()%></option>

                <%} else {%>
                <option value="<%=role.name()%>"><%=role.name()%></option>

                <%}%>


                <%}%>

            </select>
            <button type="submit" class="btn btn-outline-success form-control">Get Candidate</button>
        </div>
        <div class="row">
            <h2 class="text-center">Candidates</h2>
            <table class="table table-border table-striped table-hover">
                <thead class="table-info text-center">
                <th>ID</th>
                <th>Full Name</th>
                <th>Phone</th>
                <th>Email</th>
                </thead>
                <tbody>
                <%
                    List<Candidate> candidates = (List<Candidate>) request.getAttribute(
                            "candidatesByRole");
                    if (candidates != null) {
                        for (Candidate candidate : candidates) {
                %>
                <tr class="text-center">
                    <td><%=candidate.getId()%>
                    </td>
                    <td><%=candidate.getFullName()%>
                    </td>
                    <td><%=candidate.getPhone()%>
                    </td>
                    <td><%=candidate.getEmail()%>
                    </td>
                </tr>
                <%
                        }
                    }
                %>
                </tbody>
            </table>
        </div>
    </form>
    <a href="index.jsp" class="btn btn-outline-success">Home</a>

</div>
</body>
</html>
