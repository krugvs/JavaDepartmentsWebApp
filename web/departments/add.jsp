<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/23/14
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.krugvs.entity.Department" %>
<%@ page import="java.util.List" %>

<jsp:include page="/elements/header.jsp" />
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Departments:
            <c:if test="${requestScope.department.id ne null}">
                Edit <c:out value="${requestScope.department.name}"/>
            </c:if>
            <c:if test="${requestScope.department.id eq null}">
                Add new department
            </c:if>
        </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>


<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <c:if test="${requestScope.department.id ne null}">
                    Edit <c:out value="${requestScope.department.name}"/>
                </c:if>
                <c:if test="${requestScope.department.id eq null}">
                    Add new department
                </c:if>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="<c:out value="${requestScope.actionUrl}"/>" enctype="application/x-www-form-urlencoded" method="post">
                            <div class="form-group">
                                <label>Department name</label>
                                <input class="form-control" placeholder="Please type department name" value="<c:out value="${requestScope.department.name}"/>" name="name">
                                <input value="<c:out value="${requestScope.department.id}"/>" name="id" type="hidden">
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