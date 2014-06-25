<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/24/14
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.krugvs.entity.Department" %>
<%@ page import="com.krugvs.entity.Position" %>
<%@ page import="com.krugvs.entity.Employee" %>
<%@ page import="java.util.List" %>


<jsp:include page="/elements/header.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Employees: List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Employees
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>#</th>
                            <th>Name</th>
                            <th>Salary</th>
                            <th>Birthday</th>
                            <th>Department</th>
                            <th>Position</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="employee" items="${requestScope.listEmployees}">
                        <tr>
                            <td><c:out value="${employee.id}"/></td>
                            <td><c:out value="${employee.name}"/></td>
                            <td><c:out value="${employee.salary}"/></td>
                            <td><c:out value="${employee.birthday}"/></td>
                            <td><c:out value="${employee.department.name}"/></td>
                            <td><c:out value="${employee.position.name}"/></td>
                            <td>
                                <a href="<%=request.getContextPath()%>/employees/edit/?id=<c:out value="${employee.id}"/>">Edit</a>
                                <a href="<%=request.getContextPath()%>/employees/edit/?id=<c:out value="${employee.id}"/>&action=delete">Delete</a>
                            </td>
                        </tr>

                        </c:forEach>
                        </tbody>
                    </table>
                </div>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-6 -->
</div>
<button type="button" class="btn btn-success addNewEmployee">Add new Employee</button>
<jsp:include page="/elements/footer.jsp" />
<!-- Page-Level Plugin Scripts - Tables -->
<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $(".addNewEmployee").on('click', function(){
            document.location = '<%=request.getContextPath()%>/employees/edit/?id=0'
        });

        $('#dataTables-example').dataTable();
    });
</script>


