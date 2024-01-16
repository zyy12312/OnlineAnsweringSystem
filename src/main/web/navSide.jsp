<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 17:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
  <div class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
    <h3 class="mb-0 font-weight-normal">Answering System</h3>
    <a class="sidebar-brand brand-logo-mini" href="templete/index.html"><img src="static/picture/logo-mini.svg" alt="logo"></a>
  </div>
  <ul class="nav">
    <li class="nav-item profile">
      <div class="profile-desc">
        <div class="profile-pic">
          <div class="count-indicator">
            <c:if test="${sessionScope.userKind==\"student\"}">
              <img class="img-xs rounded-circle" src="static/picture/face15.jpg" alt="">
            </c:if>
            <c:if test="${sessionScope.userKind==\"teacher\"}">
              <img class="img-xs rounded-circle" src="static/picture/face5.jpg" alt="">
            </c:if>
            <span class="count bg-success"></span>
          </div>
          <div class="profile-name">
            <h5 class="mb-0 font-weight-normal">${sessionScope.userName}</h5>
            <span>Usst Member</span>
          </div>
        </div>
<%--        <a href="#" id="profile-dropdown" data-toggle="dropdown"><i class="mdi mdi-dots-vertical"></i></a>--%>
        <div class="dropdown-menu dropdown-menu-right sidebar-dropdown preview-list" aria-labelledby="profile-dropdown">
          <a href="#" class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <div class="preview-icon bg-dark rounded-circle">
                <i class="mdi mdi-settings text-primary"></i>
              </div>
            </div>
            <div class="preview-item-content">
              <p class="preview-subject ellipsis mb-1 text-small">Account settings</p>
            </div>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <div class="preview-icon bg-dark rounded-circle">
                <i class="mdi mdi-onepassword  text-info"></i>
              </div>
            </div>
            <div class="preview-item-content">
              <p class="preview-subject ellipsis mb-1 text-small">Change Password</p>
            </div>
          </a>
          <div class="dropdown-divider"></div>
          <a href="#" class="dropdown-item preview-item">
            <div class="preview-thumbnail">
              <div class="preview-icon bg-dark rounded-circle">
                <i class="mdi mdi-calendar-today text-success"></i>
              </div>
            </div>
            <div class="preview-item-content">
              <p class="preview-subject ellipsis mb-1 text-small">To-do list</p>
            </div>
          </a>
        </div>
      </div>
    </li>
    <li class="nav-item nav-category">
      <span class="nav-link">Navigation</span>
    </li>
    <c:if test="${sessionScope.userKind==\"student\"}">
        <li class="nav-item menu-items">
            <a class="nav-link" href="questions.do">
              <span class="menu-icon">
                <i class="mdi mdi-speedometer"></i>
              </span>
                <span class="menu-title">Questions</span>
            </a>
        </li>
        <li class="nav-item menu-items">
            <a class="nav-link" href="myCourses.do">
              <span class="menu-icon">
                <i class="mdi mdi-table-large"></i>
              </span>
                <span class="menu-title">My Courses</span>
            </a>
        </li>
        <li class="nav-item menu-items">
            <a class="nav-link" href="selectCourses.do">
              <span class="menu-icon">
                <i class="mdi mdi-playlist-play"></i>
              </span>
                <span class="menu-title">Select Courses</span>
            </a>
        </li>
    </c:if>
      <c:if test="${sessionScope.userKind==\"teacher\"}">
          <li class="nav-item menu-items">
              <a class="nav-link" href="questions.do">
              <span class="menu-icon">
                <i class="mdi mdi-speedometer"></i>
              </span>
                  <span class="menu-title">Questions</span>
              </a>
          </li>
          <li class="nav-item menu-items">
              <a class="nav-link" href="myCourses.do">
              <span class="menu-icon">
                <i class="mdi mdi-table-large"></i>
              </span>
                  <span class="menu-title">My Courses</span>
              </a>
          </li>
      </c:if>
      <c:if test="${sessionScope.userKind==\"admin\"}">
          <li class="nav-item menu-items">
              <a class="nav-link" href="admin.do"><%--adminCourse.do--%>
              <span class="menu-icon">
                <i class="mdi mdi-chart-bar"></i>
              </span>
                  <span class="menu-title">Course Management</span>
              </a>
          </li>
          <li class="nav-item menu-items">
              <a class="nav-link" href="adminTeacher.do">
              <span class="menu-icon">
                <i class="mdi mdi-contacts"></i>
              </span>
                  <span class="menu-title">Teacher Management</span>
              </a>
          </li>
          <li class="nav-item menu-items">
              <a class="nav-link" href="adminAllocation.jsp">
              <span class="menu-icon">
                <i class="mdi mdi-file-document-box"></i>
              </span>
                  <span class="menu-title">Courses Allocation</span>
              </a>
          </li>
      </c:if>
  </ul>
</nav>
