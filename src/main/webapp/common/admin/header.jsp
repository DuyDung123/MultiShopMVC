<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%-- <%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
    .ads{
        margin-left: auto !important;
        margin-right: 50px;
    }
</style>
<!-- Navbar -->
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
    <a class="navbar-brand" href="index.html">ADMIN TỐI CAO</a>
    <button class="btn btn-link btn-sm order-1 order-lg-0" id="sidebarToggle" href="#"><i
            class="fas fa-bars"></i></button>
    <ul class="nav ace-nav ads">
        <li class="text-white mr-2">
            <a >
                welcome, ${USERMODEL.fullName}
            </a>
        </li>
        <li class="text-white">
            <a style="color: white; text-decoration: none;" href='<c:url value="/thoat?action=logout"/>'>
                <i class="ace-icon fa fa-power-off"></i>
                Thoát
            </a>
        </li>
    </ul>
</nav>
<!-- /.navbar -->