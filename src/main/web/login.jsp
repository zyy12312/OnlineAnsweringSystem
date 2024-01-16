<%--
  User: zhengxiaozhu
  Date: 2022/12/19
  Time: 08:25
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
<body>
<div class="container-scroller">
  <div class="container-fluid page-body-wrapper full-page-wrapper">
    <div class="row w-100 m-0">
      <div class="content-wrapper full-page-wrapper d-flex align-items-center auth login-bg">
        <div class="card col-lg-4 mx-auto">
          <div class="card-body px-5 py-5">
            <h3 class="card-title text-left mb-3">Login</h3>
            <form>
              <div class="form-group">
                <label>User ID *</label>
                <input type="text" class="form-control p_input" id="ID">
              </div>
              <div class="form-group">
                <label>Password *</label>
                <input type="password" class="form-control p_input" id="Password">
              </div>
              <div class="form-group d-flex align-items-center justify-content-between">
                <div class="form-check">
                  <label class="form-check-label">
                    <input type="checkbox" class="form-check-input">Remember me </label>
                </div>
                <a href="#" class="forgot-pass">Forgot password</a>
              </div>
              <div class="text-center">
                <button type="button" class="btn btn-primary btn-block enter-btn" onclick="login()">Login </button>
              </div>
              <p class="sign-up" onclick="window.location.href='/register.jsp'">Don't have an Account?<a href="#"> Sign Up</a></p>
            </form>
            <script type="text/javascript">
              function login(){
                var id=document.getElementById("ID").value;
                var password = document.getElementById("Password").value;
                var url='/login.do?ID='+id+'&Password='+password;
                // console.log(url);
                window.location.href=url;
              }
            </script>
          </div>
        </div>
      </div>
      <!-- content-wrapper ends -->
    </div>
    <!-- row ends -->
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
<script src="static/js/axios.min.js"></script>
<!-- endinject -->
</body>
</html>
