<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/22/14
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.krugvs.entity.Position" %>
<%@ page import="java.util.List" %>


<jsp:include page="/elements/header.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Positions: List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Positions
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Position number</th>
                            <th>Position name</th>
                            <th>Min Salary</th>
                            <th>Max Salary</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="position" items="${requestScope.listPositions}">
                        <tr>
                            <td><c:out value="${position.id}"/></td>
                            <td><c:out value="${position.name}"/></td>
                            <td><c:out value="${position.minSalary}"/></td>
                            <td><c:out value="${position.maxSalary}"/></td>
                            <td><a href="<%=request.getContextPath()%>/positions/edit/?id=<c:out value="${position.id}"/>">Edit</a></td>
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
<button type="button" class="btn btn-success addNewPosition">Add new position</button>
<jsp:include page="/elements/footer.jsp" />
<!-- Page-Level Plugin Scripts - Tables -->
<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $(".addNewPosition").on('click', function(){
            document.location = '<%=request.getContextPath()%>/positions/add'
        });

        $('#dataTables-example').dataTable();
    });
</script>


