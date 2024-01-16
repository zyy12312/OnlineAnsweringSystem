<%--
  User: zhengxiaozhu
  Date: 2022/12/16
  Time: 08:10
  380
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
                <div class="row">
                    <div class="col-12 grid-margin">
                        <div class="card">
                            <div class="card-body">
                                <div class="d-flex flex-row justify-content-between">
                                    <h2 class="card-title">${requestScope.question.title}</h2><br>
                                    <c:if test="${requestScope.question.open==1}">
                                        <p class="text-muted mb-1 small">time: ${requestScope.question.date} | score: ${requestScope.question.score} | public</p>
                                    </c:if>
                                    <c:if test="${requestScope.question.open==0}">
                                        <p class="text-muted mb-1 small">time: ${requestScope.question.date} | score: ${requestScope.question.score} | private</p>
                                    </c:if>
                                </div>
                                <h4 class="card-title">${requestScope.question.content}</h4>
                                <%--图片（如果有的话）--%>
                                <c:if test="${requestScope.question.file_name!=null}">
                                    <img src="static/picture/${requestScope.question.file_name}" alt="image">
                                </c:if>
                                <div class="preview-list">
                                    <c:forEach var="reply" items="${requestScope.replyList}">
                                    <%--评论开始--%>
                                    <div class="preview-item border-bottom">
                                        <div class="preview-thumbnail"><%--头像--%>
                                            <c:if test="${reply.sender==1}">
                                                <img src="static/picture/face5.jpg" alt="image" class="rounded-circle">
                                            </c:if>
                                            <c:if test="${reply.sender==0}">
                                                <img src="static/picture/face15.jpg" alt="image" class="rounded-circle">
                                            </c:if>
                                        </div>
                                        <div class="preview-item-content d-flex flex-grow">
                                            <div class="flex-grow" >
                                                <div class="d-flex d-md-block d-xl-flex justify-content-between">
                                                    <%--<c:if test="${reply.sender==1}">
                                                    <h6 class="preview-subject">${requestScope.teacher.name}</h6>
                                                    </c:if>
                                                    <c:if test="${reply.sender==0}">
                                                        <h6 class="preview-subject">${requestScope.student.name}</h6>
                                                    </c:if>--%>
                                                    <c:if test="${reply.sender==1 && requestScope.canModify==1 && sessionScope.userKind=='teacher'}">
                                                    <h6 class="preview-subject">${requestScope.teacher.name} (me)</h6>
                                                    </c:if>
                                                    <c:if test="${reply.sender==1 && !(requestScope.canModify==1 && sessionScope.userKind=='teacher')}">
                                                    <h6 class="preview-subject">${requestScope.teacher.name} (teacher)</h6>
                                                    </c:if>
                                                    <c:if test="${reply.sender==0 && requestScope.canModify==1 && sessionScope.userKind=='student'}">
                                                        <h6 class="preview-subject">${requestScope.student.name} (me)</h6>
                                                    </c:if>
                                                    <c:if test="${reply.sender==0 && !(requestScope.canModify==1 && sessionScope.userKind=='student')}">
                                                        <h6 class="preview-subject">${requestScope.student.name} (student)</h6>
                                                    </c:if>
                                                    <p class="text-muted text-small">${reply.date}</p>
                                                </div>
                                                <h6 class="card-title" id="content">${reply.content}</h6>

                                                <c:if test="${(reply.sender==1 && requestScope.canModify==1 && sessionScope.userKind=='teacher')
                                                || (reply.sender==0 && requestScope.canModify==1 && sessionScope.userKind=='student')}"><%--是本人，才可以删除--%>
                                                    <form action="/deleteReply.do" method="post" id="deleteReplyForm"><%--删除按钮--%>
                                                        <input type="text" id="reply_id" name="reply_id" style="display:none">
                                                        <input type="text" id="question_id" name="question_id" style="display:none">
                                                        <button type="button" class="btn btn-outline-secondary btn-sm" onclick="deleteReply(${reply.reply_id})">delete</button>
                                                        <button type="button" class="btn btn-outline-secondary btn-sm">modify</button>
                                                    </form>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                    <%--一条评论结束--%>
                                    </c:forEach>
                                    <%--所有评论结束--%>
                                </div>
                                <div><p> </p></div>

                                <div id="add-a-reply" class="template-demo">
                                    <c:if test="${requestScope.canModify==1}">
                                        <%--增加评论--%>
                                        <button type="button" class="btn btn-primary btn-rounded btn-fw" onclick="add()">Add A Reply</button>
                                        <%--删除整个问题--%>
                                        <form method="post" action="deleteQuestion.do" id="deleteQuestionForm">
                                            <p>  </p>
                                            <input type="text" id="question_id2" name="question_id2" style="display:none">
                                            <button type="button" class="btn btn-danger btn-rounded btn-fw" onclick="deleteQuestion()">Delete This Question</button>
                                        </form>
                                    </c:if>
                                </div>
                                <div><p> </p></div>
                                <%--评分按钮--%>
                                <c:if test="${requestScope.canModify==1 && sessionScope.userKind=='student'}">
                                    <div id="score">
                                        <h4 class="card-title">score : </h4>
                                        <div class="btn-group" role="group" aria-label="Basic example">
                                            <button type="button" class="btn btn-outline-secondary" onclick="updateScore(1)">1</button>
                                            <button type="button" class="btn btn-outline-secondary" onclick="updateScore(2)">2</button>
                                            <button type="button" class="btn btn-outline-secondary" onclick="updateScore(3)">3</button>
                                            <button type="button" class="btn btn-outline-secondary" onclick="updateScore(4)">4</button>
                                            <button type="button" class="btn btn-outline-secondary" onclick="updateScore(5)">5</button>
                                        </div>
                                    </div>
                                </c:if>
                                <script type="text/javascript">
                                    function add() {
                                        document.getElementById("add-a-reply").innerHTML =
                                            "<form action=\"/addReply.do\" method=\"post\" id=\"newReplyForm\">"+
                                                "<input type=\"text\" id=\"question_id3\" name=\"question_id3\" style=\"display:none\">"+
                                                "<textarea class=\"form-control\" rows=\"1\" name=\"newReplyContent\" id=\"newReplyContent\"></textarea> <p>  </p>" +
                                                "<button type=\"button\" class=\"btn btn-primary btn-fw\" onclick=\"addReply()\" >Submit</button>"+
                                            "</form>"
                                    }
                                    function addReply(){
                                        $("#question_id3").val(${requestScope.question.id});
                                        document.getElementById("newReplyForm").submit();
                                    }
                                    function updateScore(score) {
                                        axios.get('/updateScore.do?course_id=' + ${requestScope.course_id} + "&score="
                                            +score + "&question_id=" + ${requestScope.question.id});
                                        document.getElementById("score").innerHTML = "score: "+score;
                                    }
                                    function deleteReply(reply_id){
                                        $("#reply_id").val(reply_id);
                                        $("#question_id").val(${requestScope.question.id});
                                        document.getElementById("deleteReplyForm").submit();
                                        alert("删除成功");
                                    }
                                    function deleteQuestion(){
                                        $("#question_id2").val(${requestScope.question.id});
                                        document.getElementById("deleteQuestionForm").submit();
                                        alert("删除成功");
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