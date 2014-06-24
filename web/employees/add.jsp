<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/24/14
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.krugvs.entity.Department" %>
<%@ page import="com.krugvs.entity.Position" %>
<%@ page import="com.krugvs.entity.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.krugvs.entity.Employee" %>

<jsp:include page="/elements/header.jsp" />
<%
    Employee employee = (Employee)request.getAttribute("employee");
    Integer employeeId  = (Integer)request.getAttribute("employeeId");
    String actionUrl      = request.getAttribute("actionUrl").toString();
%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Employees:  <% if (employeeId!=null){%>
            <%="Edit \""+employee.getName()+"\""%>
            <%}else{%>
            Add new
            <%}%></h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <% if (employeeId!=null){%>
                <%="Edit \""+employee.getName()+"\""%>
                <%}else{%>
                Add new employee
                <%}%>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="<%=actionUrl%>" enctype="application/x-www-form-urlencoded" method="post">
                            <div class="form-group">
                                <label>Employee name</label>
                                <input class="form-control" placeholder="Please type employee name" value="<%=employee.getName()%>" name="name">
                                <input value="<%=employeeId%>" name="id" type="hidden">
                            </div>
                            <div class="form-group">
                                <label>Birthday</label>
                                <input class="form-control" placeholder="Please type employee name" value="<%=employee.getBirthday()%>" name="name">
                            </div>
                            <label class="control-label" >Salary</label>
                            <div class="form-group input-group">
                                <span class="input-group-addon">$</span>
                                <input type="number" class="form-control" name="minSalary" min="0" value="<%=minSalary%>">
                                <span class="input-group-addon">.00</span>
                            </div>
                            <div class="form-group">
                                <label>Department</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Posiotion</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>

                            <button type="submit" class="btn btn-default">Submit</button>
                            <button type="reset" class="btn btn-default">Reset</button>
                        </form>
                    </div>
                </div>
                <!-- /.row (nested) -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<jsp:include page="/elements/footer.jsp" />