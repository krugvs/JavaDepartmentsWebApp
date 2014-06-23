<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/22/14
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.krugvs.entity.Department" %>
<%@ page import="java.util.List" %>


<jsp:include page="/elements/header.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Departments: List</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Departments
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="table-responsive">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Department number</th>
                            <th>Department name</th>
                            <th>Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List<Department> departments = (List<Department>) request.getAttribute("listDepartments");
                            for (Department dep : departments)
                            {%>
                        <tr>
                            <td><%=dep.getId()%></td>
                            <td><a href="<%=request.getContextPath()%>/departments/view/<%=dep.getId()%>"><%=dep.getName()%></a></td>
                            <td><a href="<%=request.getContextPath()%>/departments/edit/?id=<%=dep.getId()%>">Edit</a></td>
                        </tr>

                        <%}%>

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
<button type="button" class="btn btn-success addNewDepartment">Add new department</button>
<jsp:include page="/elements/footer.jsp" />
<!-- Page-Level Plugin Scripts - Tables -->
<script src="js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- SB Admin Scripts - Include with every page -->
<script src="js/sb-admin.js"></script>

<!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    $(document).ready(function() {
        $(".addNewDepartment").on('click', function(){
            document.location = '<%=request.getContextPath()%>/departments/add'
        });

        $('#dataTables-example').dataTable();
    });
</script>


