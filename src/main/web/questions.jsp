<%--
  User: zhengxiaozhu
  Date: 2022/12/15
  Time: 09:33
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
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
                <c:if test="${requestScope.unchecked_num!=0}"> <%--未读消息提示--%>
                <div class="row">
                    <div class="col-12 grid-margin stretch-card">
                        <div class="card corona-gradient-card">
                            <div class="card-body py-0 px-0 px-sm-3">
                                <div class="row align-items-center">
                                    <div class="col-4 col-sm-3 col-xl-2">
                                        <img src="static/picture/Group126@2x.png" class="gradient-corona-img img-fluid" alt="">
                                    </div>
                                    <div class="col-5 col-sm-7 col-xl-8 p-0">
                                        <h4 class="mb-1 mb-sm-0">There are ${requestScope.unchecked_num} unchecked replies, please check in time</h4>
                                        <p class="mb-0 font-weight-normal d-none d-sm-block">Click to see these unchecked replies!</p>
                                    </div>
                                    <div class="col-3 col-sm-2 col-xl-2 pl-0 text-center">
                        <span>
                          <a href="javascript:;" target="_blank" class="btn btn-outline-light btn-rounded get-started-btn">Check replies</a>
                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                </c:if>
                <div class="row">
                    <c:forEach var="question" items="${requestScope.questionList}">
                    <%--一个问题--%>
                    <div class="col-xl-3 col-sm-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="preview-thumbnail">
                                        <c:if test="${(sessionScope.userKind==\"student\" && question.reply_state==1
                                         && question.check_state==1) || (sessionScope.userKind==\"teacher\"
                                         &&question.reply_state==1)}">
                                            <div class="preview-icon bg-primary"><%--学生：已回答且已查看 || 老师：已回答--%>
                                                <i class="mdi mdi-file-document"></i>
                                            </div>
                                        </c:if>
                                        <c:if test="${question.reply_state==0}">
                                            <div class="preview-icon bg-info"><%--未回答--%>
                                                <i class="mdi mdi-clock"></i>
                                            </div>
                                        </c:if>
                                        <c:if test="${sessionScope.userKind==\"student\" && question.reply_state==1
                                        && question.check_state==0}">
                                            <div class="preview-icon bg-danger"><%--学生：已回答且未查看--%>
                                                <i class="mdi mdi-email-open"></i>
                                            </div>
                                        </c:if>
                                    </div>

                                    <div class="col-9">
                                        <div class="d-flex align-items-center align-self-start">
                                            <h3 class="mb-0">${question.title}</h3> <%--问题title--%>
                                            <p class="text-success ml-2 mb-0 font-weight-medium">#${requestScope.courseNameMap[question.cid]}</p> <%--课程名称--%>
                                        </div>
                                    </div>
                                    <div class="col-9"><%--check按钮--%>
                                        <div><p> </p></div>
                                        <button type="button" class="btn btn-inverse-success btn-fw" onclick="window.location.href='/questionDetail.do?question_id=${question.id}'">Check</button><%--id=${question.id} onclick="check(id)"--%>
                                    </div>
                                </div>
                                <div><p> </p></div>
                                <h6 class="text-muted font-weight-normal">${requestScope.studentNameMap[question.sid]} | time: ${question.date} | score: ${question.score}</h6><%--提问人，提问时间，评分--%>
                            </div>
                        </div>
                    </div>
                    <%--第一个问题结束--%>
                    </c:forEach>
                </div>
            </div>
            <script type="text/javascript">
                function check(id) {
                    axios.get('/questionDetail.do?question_id=' + id
                    ).then(res => {
                        console.log(res.data);
                    }).catch(err => {
                        console.log(err);
                    });
                }
                function onloadFunction() {
                    $("#navSideDiv").load('navSide.jsp');
                    var createQue;
                    if(${sessionScope.userKind=="student"})
                        createQue=1;
                    else createQue=0
                    $("#navHeadDiv").load('navHead.jsp',{createQuestion:createQue, searchQuestion:"1" ,searchCourse:"0"});
                    $("#footerDiv").load('footer.html');
                }
            </script>
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
<script src="static/js/axios.min.js"></script>
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="static/js/off-canvas.js"></script>
<script src="static/js/hoverable-collapse.js"></script>
<script src="static/js/misc.js"></script>
<script src="static/js/settings.js"></script>
<script src="static/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page -->
<script src="static/js/dashboard.js"></script>
<!-- End custom js for this page -->
</body>
</html>
