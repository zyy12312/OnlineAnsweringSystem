<%--
  User: zhengxiaozhu
  Date: 2022/12/18
  Time: 08:27
--%>
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
    <link rel="stylesheet" href="static/css/jquery-jvectormap.css">
    <link rel="stylesheet" href="static/css/flag-icon.min.css">
    <link rel="stylesheet" href="static/css/owl.carousel.min.css">
    <link rel="stylesheet" href="static/css/owl.theme.default.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <!-- endinject -->
    <!-- Layout styles -->
    <link rel="stylesheet" href="static/css/style.css">
    <!-- End layout styles -->

</head>
<body onload="onloadFunction();">
<div class="container-scroller">
    <!-- partial:partials/_sidebar.html -->
    <div id="navSideDiv"></div>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_navbar.html -->
        <div id="navHeadDiv"></div>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row ">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Course List</h4>
                                <div class="table-responsive">
                                    <form method="post" action="selectCourses.do">
                                    <table class="table">
                                        <thead><%--第一行 列名，静态--%>
                                        <tr>
                                            <th>
                                                <div class="form-check form-check-muted m-0">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" class="form-check-input">
                                                    </label>
                                                </div>
                                            </th>
                                            <th> Course Name </th>
                                            <th> Course Id </th>
                                            <th> Teacher Name </th>
                                            <th> Teacher Level </th>
                                            <th> Class Status </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <%--第一行开始--%>
                                        <c:forEach var="course" items="${requestScope.coursesList}">
                                        <tr>
                                            <td>
                                                <div class="form-check form-check-muted m-0">
                                                    <label class="form-check-label">
                                                        <input type="checkbox" class="form-check-input" id="${course.courseId}" name="${course.courseId}"><%--选择框--%>
                                                    </label>
                                                </div>
                                            </td>
                                            <td> ${course.courseName} </td>
                                            <td> ${course.courseId} </td>
                                            <td>
                                                <img src="static/picture/${course.teacherAvatar}.jpg" alt="image">
                                                <span class="pl-2">${course.teacherName}</span>
                                            </td>

                                            <td> ${course.teacherLevel} </td>
                                            <td>
                                                <c:if test="${course.courseStatus==1}"> <%--可选：1--%>
                                                    <div class="badge badge-outline-success">Selectable</div>
                                                </c:if>
                                                <c:if test="${course.courseStatus==2}"> <%--已选：2--%>
                                                    <div class="badge badge-outline-warning">Already Selected</div>
                                                </c:if>
                                                <c:if test="${course.courseStatus==3}"> <%--已满：3--%>
                                                    <div class="badge badge-outline-danger">Already Full</div>
                                                </c:if>
                                            </td>
                                        </tr>
                                        <%--第一行结束--%>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <button type="submit" class="btn btn-primary mr-2" onclick="submitSelect()">Submit</button>
                                    <button class="btn btn-dark">Cancel</button>
                                    </form>
                                    <script type="text/javascript">
                                        function submitSelect() {
                                            alert("提交成功");
                                        }
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
<script src="static/js/Chart.min.js"></script>
<script src="static/js/progressbar.min.js"></script>
<script src="static/js/jquery-jvectormap.min.js"></script>
<script src="static/js/jquery-jvectormap-world-mill-en.js"></script>
<script src="static/js/owl.carousel.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="static/js/off-canvas.js"></script>
<script src="static/js/hoverable-collapse.js"></script>
<script src="static/js/misc.js"></script>
<script src="static/js/settings.js"></script>
<script src="static/js/todolist.js"></script>
<script src="static/js/axios.min.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<script src="static/js/dashboard.js"></script>
<!-- End custom js for this page -->
</body>
</html>
