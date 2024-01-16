<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 17:46
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <!-- End Plugin css for this page -->
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
        <script type="text/javascript">
            function onloadFunction() {
                $("#navSideDiv").load('navSide.jsp');
                $("#navHeadDiv").load('navHead.jsp',{createQuestion:"0", searchQuestion:"0" ,searchCourse:"0"});
                $("#footerDiv").load('footer.html');
            }
        </script>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <h1>Welcome to the administrator</h1>
            </div>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
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