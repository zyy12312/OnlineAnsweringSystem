<%--
  User: zhengxiaozhu
  Date: 2022/12/15
  Time: 23:28
  331
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
    <link rel="stylesheet" href="static/css/select2.min.css">
    <link rel="stylesheet" href="static/css/select2-bootstrap.min.css">
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
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Create New Question</h4>
                                <p class="card-description"> Please fill in your question information </p>
                                <form id="questionForm" class="forms-sample" onsubmit="submit()" action="createQuestion.do" method="post" enctype="multipart/form-data"> <%--enctype="multipart/form-data"--%>
                                    <div class="form-group">
                                        <label>select a course</label><%--课程--%>
                                        <select class="js-example-basic-single" name="course" style="width:100%">
                                            <c:if test="${fn:length(requestScope.courseNameList)==0}"> <%--如果学生没有选课程--%>
                                                <option value="null">请先选择课程</option>
                                            </c:if>
                                            <c:forEach var="courseName" items="${requestScope.courseNameList}">
                                            <option value="${courseName}">${courseName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group"><%--标题--%>
                                        <label for="title">Title</label>
                                        <input type="text" class="form-control" id="title" name="title" placeholder="Title">
                                    </div>

                                    <div class="form-group"><%--文件--%>
                                        <label>File upload</label>
                                        <input type="file" name="file" class="file-upload-default">
                                        <div class="input-group col-xs-12">
                                            <input type="text" class="form-control file-upload-info" disabled="" placeholder="Upload Image" name="file">
                                            <span class="input-group-append">
                                                <button class="file-upload-browse btn btn-primary" type="button">Upload</button>
                                            </span>
                                        </div>
                                    </div>
                                    <div class="form-group"><%--正文--%>
                                        <label for="content">Textarea</label>
                                        <textarea class="form-control" id="content" rows="4" name="content"></textarea>
                                    </div>

                                    <div class="form-group"><%--open--%>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                            <input type="radio" class="form-check-input" name="open" id="optionsRadios1" value="1"> public </label>
                                        </div>
                                        <div class="form-check">
                                            <label class="form-check-label">
                                            <input type="radio" class="form-check-input" name="open" id="optionsRadios2" value="0" checked=""> private </label>
                                        </div>
                                    </div>
                                    <button type="button" class="btn btn-primary mr-2" onclick="submitQuestion()">Submit</button>
                                    <button class="btn btn-dark">Cancel</button>
                                </form>
                                <script type="text/javascript">
                                    function submitQuestion() {
                                        var newContent = $('#content').val().replace(/\n/g,"<br/>");
                                        $('#content').val(newContent);
                                        console.log(newContent);
                                        document.getElementById("questionForm").submit();
                                        alert("提交成功");
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
<script src="static/js/select2.min.js"></script>
<script src="static/js/typeahead.bundle.min.js"></script>
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
<script src="static/js/file-upload.js"></script>
<script src="static/js/typeahead.js"></script>
<script src="static/js/select2.js"></script>
<!-- End custom js for this page -->
</body>
</html>
