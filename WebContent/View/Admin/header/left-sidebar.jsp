<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/View/Admin/assets" var="url"/>
    <div id="sidebar-wrapper" data-simplebar="" data-simplebar-auto-hide="true">
      <div class="brand-logo">
        <a href="Adminhome">
          <img src="${url}/images/logo-icon.png" class="logo-icon" alt="logo icon">
          <h5 class="logo-text">Admin Web Nông Sản</h5>
        </a>
      </div>
      <ul class="sidebar-menu do-nicescrol">
        <li class="sidebar-header">MENU ADMIN</li>
        <li>
          <a href="Adminhome">
            <i class="zmdi zmdi-view-dashboard"></i> <span>Tổng quan</span>
          </a>
        </li>
        
         <li>
          <a href="List">
            <i class="zmdi zmdi-account-box"></i> <span>Quản lí Admin</span>
          </a>
        </li>
        <li>
          <a href="Listuser">
            <i class="zmdi zmdi-accounts"></i> <span>Quản lí User</span>
          </a>
        </li>
        <li>
          <a href="Listcate">
            <i class="zmdi zmdi-grid"></i> <span>Chuyên Mục</span>
          </a>
        </li>
        <li>
          <a href="Listproduct">
            <i class="zmdi zmdi-widgets"></i> <span>Danh Sách Sản Phẩm</span>
          </a>
        </li>
        <li>
          <a href="Listorder">
            <i class="zmdi zmdi-shopping-cart"></i> <span>Đơn Hàng</span>
          </a>
        </li>
        
        <li>
          <a href="Orderdetail">
            <i class="zmdi zmdi-shopping-cart"></i> <span>Chi Tiết Đơn Hàng</span>
          </a>
        </li>
        <li>
          <a href="Listreview">
            <i class="zmdi zmdi-calendar-check"></i> <span>Review</span>
          </a>   
        </li>
        <li>
          <a href="Listnew">
            <i class="icon-envelope-open"></i> <span>Tin tức</span>
          </a>
        </li>
      </ul>
    </div>