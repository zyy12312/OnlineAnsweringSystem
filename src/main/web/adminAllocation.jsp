<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 17:47
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Corona Admin</title>
    <link rel="stylesheet" href="static/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="static/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="static/css/select2.min.css">
    <link rel="stylesheet" href="static/css/select2-bootstrap.min.css">
    <link rel="stylesheet" href="static/css/style.css">
</head>
<body onload="onloadFunction();">
<div class="container-scroller">
    <div id="navSideDiv"></div>
    <div class="container-fluid page-body-wrapper">
        <div id="navHeadDiv"></div>
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="page-header">
                    <h3 class="page-title"> Courses Allocation </h3>
                </div>
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <form class="forms-sample">
                                    <div class="form-group">
                                        <label for="tid">Teacher ID</label>
                                        <input type="text" class="form-control" id="tid" name="tid">
                                    </div>
                                    <div class="form-group">
                                        <label for="cid">Course ID</label>
                                        <input type="text" class="form-control" id="cid" name="cid">
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2" onclick="alert('添加成功');">Submit</button>
                                    <button class="btn btn-dark">Cancel</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script type="text/javascript">
                function onloadFunction() {
                    $("#navSideDiv").load('navSide.jsp');
                    $("#navHeadDiv").load('navHead.jsp',{createQuestion:"0", searchQuestion:"0" ,searchCourse:"0"});
                    $("#footerDiv").load('footer.html');
                }
            </script>
            <!-- content-wrapper ends -->
            <!-- partial:../../partials/_footer.html -->
            <div id="footerDiv"></div>
            <!-- partial -->
        </div>
        <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<script src="static/js/vendor.bundle.base.js"></script>
<script src="static/js/select2.min.js"></script>
<script src="static/js/typeahead.bundle.min.js"></script>
<script src="static/js/off-canvas.js"></script>
<script src="static/js/hoverable-collapse.js"></script>
<script src="static/js/misc.js"></script>
<script src="static/js/settings.js"></script>
<script src="static/js/todolist.js"></script>
<script src="static/js/file-upload.js"></script>
<script src="static/js/typeahead.js"></script>
<script src="static/js/select2.js"></script>
</body>
</html>
