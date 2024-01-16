<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 11:22
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <link rel="stylesheet" href="static/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="static/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="static/css/style.css">
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
                <div class="page-header">
                    <h3 class="page-title"> User Setting </h3>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th> ID </th>
                                            <th> Name </th>
                                            <th> Password </th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <tr>
                                            <td> ${sessionScope.userId}
                                                <button type="button" class="btn btn-outline-secondary btn-md" onclick="modify('id')">modify</button>
                                            </td>
                                            <td> ${sessionScope.userName}
                                                <button type="button" class="btn btn-outline-secondary btn-md" onclick="modify('name')">modify</button>
                                            </td>
                                            <td> ***
                                                <button type="button" class="btn btn-outline-secondary btn-md" onclick="modify('password')">modify</button>
                                            </td>
                                        </tr>
                                        </tbody>
                                    </table>
                                    <p> </p>
                                    <div id="modifyDiv"> </div>

                                    <script type="text/javascript">
                                        function modify(content) {
                                            var newDiv;
                                            if(content==='password'){
                                                newDiv = "<input type=\"password\" class=\"form-control mb-2 mr-sm-2\" placeholder=\"old password:\">"+
                                                    "<input type=\"password\" class=\"form-control mb-2 mr-sm-2\" placeholder=\"new password:\">"+
                                                    "<input type=\"password\" class=\"form-control mb-2 mr-sm-2\" placeholder=\"confirm new password:\">"
                                            }
                                            else{
                                                newDiv = "<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" placeholder="+content+">"
                                            }
                                            document.getElementById("modifyDiv").innerHTML =
                                                "<form>"+newDiv+
                                                "<button type=\"button\" class=\"btn btn-primary btn-fw\" onclick=\"alert('操作成功');\">Submit</button>"+
                                                "</form>"
                                        }
                                        function onloadFunction() {
                                            $("#navSideDiv").load('navSide.jsp');
                                            var createQue;
                                            if(${sessionScope.userKind=="student"})
                                                createQue=1;
                                            else createQue=0
                                            $("#navHeadDiv").load('navHead.jsp',{createQuestion:createQue, searchQuestion:"0" ,searchCourse:"0"});
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
