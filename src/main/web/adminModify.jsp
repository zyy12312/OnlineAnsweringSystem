<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 13:48
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
                <div class="page-header">
                    <h3 class="page-title">Information List</h3>
                </div>
                <div class="row">
                    <div class="col-lg-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-dark">
                                        <thead>
                                        <tr>
                                            <c:forEach var="title" items="${requestScope.titleList}" varStatus="status">
                                                <th> ${title} </th>
                                            </c:forEach>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="info" items="${requestScope.infoList}" varStatus="status">
                                            <tr>
                                                <c:forEach var="title" items="${requestScope.titleList}" varStatus="status">
                                                    <td> ${info[title]} </td><%--不可以${info.title}--%>
                                                </c:forEach>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <button type="button" class="btn btn-outline-primary btn-fw" onclick="modify('insert')">Insert</button>
                                <button type="button" class="btn btn-outline-danger btn-fw" onclick="modify('delete')">Delete</button>
                                <button type="button" class="btn btn-outline-info btn-fw" onclick="modify('update')">Update</button>
                                <p>  </p>
                                <div class="col-md-6" id="modifyDiv">
                                </div>
                                <script type="text/javascript">
                                    function modify(content) {
                                        var newDiv;
                                        if(content==='insert'){
                                            newDiv =
                                                "<c:forEach var="title" items="${requestScope.titleList}" varStatus="status">"+
                                                    "<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" placeholder=${title}>"+
                                                "</c:forEach>"
                                        }
                                        else if(content==='delete'){
                                            newDiv = "<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" placeholder= id>"
                                        }
                                        else{
                                            newDiv =
                                            "<div class=\"form-group\">"+
                                                "<c:forEach var="title" items="${requestScope.titleList}" varStatus="status">"+
                                                    "<div class=\"form-check\">"+
                                                    "<input type=\"radio\" class=\"form-check-input\" name=\"level\" id=${status}> ${title} <i class=\"input-helper\"></i></label>"+
                                                    "</div>"+
                                                "</c:forEach>"+
                                            "</div>"+
                                            "<input type=\"text\" class=\"form-control mb-2 mr-sm-2\" placeholder= update content>"
                                        }
                                        document.getElementById("modifyDiv").innerHTML =
                                            "<form>"+newDiv+
                                            "<button type=\"button\" class=\"btn btn-primary btn-fw\" onclick=\"alert('操作成功');\">Submit</button>"+
                                            "</form>"
                                    }
                                    function onloadFunction() {
                                        $("#navSideDiv").load('navSide.jsp');
                                        $("#navHeadDiv").load('navHead.jsp',{createQuestion:"0", searchQuestion:"0" ,searchCourse:"0"});
                                        $("#footerDiv").load('footer.html');
                                    }
                                </script>
                            </div>
                        </div>
                    </div>
                </div>
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
