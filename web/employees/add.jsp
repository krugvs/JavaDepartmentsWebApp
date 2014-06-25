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
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/elements/header.jsp" />

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Employees:
            <c:if test="${requestScope.employee.id ne null}">
                Edit <c:out value="${requestScope.employee.name}"/>
            </c:if>
            <c:if test="${requestScope.employee.id eq null}">
                Add new employee
            </c:if>
        </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <c:if test="${requestScope.employee.id ne null}">
                    Edit <c:out value="${requestScope.employee.name}"/>
                </c:if>
                <c:if test="${requestScope.employee.id eq null}">
                    Add new employee
                </c:if>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="<c:out value="${requestScope.actionUrl}"/>" enctype="application/x-www-form-urlencoded" method="post">
                            <div class="form-group">
                                <label>Employee name</label>
                                <input class="form-control" placeholder="Please type employee name" value="<c:out value="${requestScope.employee.name}"/>" name="name">
                                <input value="<c:out value="${requestScope.employeeId}"/>" name="id" type="hidden">
                            </div>
                            <div class="form-group">
                                <label>Birthday</label>
                                <input class="form-control" placeholder="Please type Birthday" value="<c:out value="${requestScope.employee.birthday}"/>" name="birthday">
                            </div>
                            <div class="form-group">
                                <label>Passport number</label>
                                <input class="form-control" placeholder="Please type Passport number" value="<c:out value="${requestScope.employee.passportNumber}"/>" name="passportNumber">
                            </div>
                            <label class="control-label" >Salary</label>
                            <div class="form-group input-group">
                                <span class="input-group-addon">$</span>
                                <input type="number" class="form-control" name="salary" min="0" value="<c:out value="${requestScope.employee.salary}"/>">
                                <span class="input-group-addon">.00</span>
                            </div>
                            <div class="form-group">
                                <label>Department</label>
                                <select class="form-control" name="department_id">
                                    <c:forEach var="department" items="${requestScope.listDepartments}">
                                        <option value="<c:out value="${department.id}"/>"
                                                <c:if test="${requestScope.employee.department.id==department.id}"> selected </c:if>
                                                ><c:out value="${department.name}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Position</label>
                                <select class="form-control" name="position_id">
                                    <c:forEach var="position" items="${requestScope.listPositions}" varStatus="loopStatus">
                                        <option value="<c:out value="${position.id}"/>"
                                                <c:if test="${requestScope.employee.position.id==position.id}"> selected </c:if>
                                        ><c:out value="${position.name}"/></option>
                                    </c:forEach>
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