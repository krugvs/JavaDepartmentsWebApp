<%--
  Created by IntelliJ IDEA.
  User: vlad
  Date: 6/23/14
  Time: 2:46 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.krugvs.entity.Position" %>
<%@ page import="java.util.List" %>
<%@ page import="java.math.BigDecimal" %>

<jsp:include page="/elements/header.jsp" />
<%
    String positionName  = request.getAttribute("positionName").toString();
    Integer positionId   = (Integer)request.getAttribute("positionId");
    String actionUrl     = request.getAttribute("actionUrl").toString();
    BigDecimal minSalary = (BigDecimal)request.getAttribute("minSalary");
    BigDecimal maxSalary = (BigDecimal)request.getAttribute("maxSalary");
%>

<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Positions:  <% if (positionId!=null){%>
            <%="Edit \""+positionName+"\""%>
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
                <% if (positionId!=null){%>
                <%="Edit \""+positionName+"\""%>
                <%}else{%>
                Add new position
                <%}%>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-6">
                        <form role="form" action="<%=actionUrl%>" enctype="application/x-www-form-urlencoded" method="post">
                            <div class="form-group">
                                <label>Position name</label>
                                <input class="form-control" placeholder="Please type position name" value="<%=positionName%>" name="name">
                                <input value="<%=positionId%>" name="id" type="hidden">
                            </div>
                            <label class="control-label" >Minimum salary</label>
                            <div class="form-group input-group">
                                <span class="input-group-addon">$</span>
                                <input type="number" class="form-control" name="minSalary" min="0" value="<%=minSalary%>">
                                <span class="input-group-addon">.00</span>
                            </div>
                            <label>Maximum salary</label>
                            <div class="form-group input-group">
                                <span class="input-group-addon">$</span>
                                <input type="number" class="form-control" name="maxSalary" min="0" value="<%=maxSalary%>">
                                <span class="input-group-addon">.00</span>
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