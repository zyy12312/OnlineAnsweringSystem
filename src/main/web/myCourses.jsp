<%--
  User: zhengxiaozhu
  Date: 2022/12/18
  Time: 11:56
--%>
<%--id，name，teacherName，--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="static/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="static/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- End layout styles -->

</head>
<body onload="onloadFunction();">
<div class="container-scroller">
    <!-- partial:../../partials/_sidebar.html -->
    <div id="navSideDiv"></div>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:../../partials/_navbar.html -->
        <div id="navHeadDiv"></div>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-lg-12 stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Courses List</h4>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-contextual">
                                        <thead>
                                        <tr>
                                            <th> Course ID </th>
                                            <th> Course Name </th>
                                            <th> Teacher Name </th>
                                            <th> Classroom </th>
                                            <th> Time </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="course" items="${requestScope.coursesList}" varStatus="status">
                                        <%--一行开始--%>
                                            <c:if test="${(status.count+4) % 5==0}">
                                            <tr class="table-info">
                                            </c:if>
                                            <c:if test="${(status.count+3) % 5==0}">
                                                <tr class="table-warning">
                                            </c:if>
                                            <c:if test="${(status.count+2) % 5==0}">
                                                <tr class="table-danger">
                                            </c:if>
                                            <c:if test="${(status.count+1) % 5==0}">
                                                <tr class="table-success">
                                            </c:if>
                                            <c:if test="${(status.count) % 5==0}">
                                                <tr class="table-primary">
                                            </c:if>
                                                <td onclick="window.location.href='/courseDetail.do?course_id=${course.courseId}'"> ${course.courseId} </td>
                                                <td onclick="window.location.href='/courseDetail.do?course_id=${course.courseId}'"> ${course.courseName} </td>
                                                <td>
                                                    <img src="static/picture/${course.teacherAvatar}.jpg" alt="image">
                                                    <span class="pl-2">${course.teacherName}</span>
                                                </td>
                                            <c:if test="${(status.count+4) % 5==0}">
                                                <td> Room 401, Building 1 </td>
                                                <td> Monday 9:55-12:20 </td>
                                            </c:if>
                                            <c:if test="${(status.count+3) % 5==0}">
                                                <td> Room 318, Building 3 </td>
                                                <td> Wednesday 18:00-20:25 </td>
                                            </c:if>
                                            <c:if test="${(status.count+2) % 5==0}">
                                                <td> Room 105, Building 2 </td>
                                                <td> Friday 8:00-9:35 </td>
                                            </c:if>
                                            <c:if test="${(status.count+1) % 5==0}">
                                                <td> Room 230, Building 3 </td>
                                                <td> Tuesday 13:15-14:50 </td>
                                            </c:if>
                                            <c:if test="${(status.count+0) % 5==0}">
                                                <td> Room 122, Building 1 </td>
                                                <td> Thursday 15:10-16:35 </td>
                                            </c:if>
                                            </tr>
                                        <%--一行结束--%>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <script type="text/javascript">
                                        function onloadFunction() {
                                            $("#navSideDiv").load('navSide.jsp');
                                            var createQue;
                                            if(${sessionScope.userKind=="student"})
                                                createQue=1;
                                            else createQue=0
                                            $("#navHeadDiv").load('navHead.jsp',{createQuestion:createQue, searchQuestion:"0" ,searchCourse:"1"});
                                            $("#footerDiv").load('footer.html');
                                        }
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- content-wrapper ends -->
            <div id="footerDiv"></div>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="static/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="static/js/off-canvas.js"></script>
<script src="static/js/hoverable-collapse.js"></script>
<script src="static/js/misc.js"></script>
<script src="static/js/settings.js"></script>
<script src="static/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<!-- End custom js for this page -->
</body>
</html>


<script src="static/js/axios.min.js"></script>