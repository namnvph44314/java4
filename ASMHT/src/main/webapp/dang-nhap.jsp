<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/28/2023
  Time: 8:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
    <title>Đăng nhập</title>
</head>
<body>
    <div class="container">
        <form action="/dangNhap" method="get">
            <div class="mb-3">
                <label class="form-label">Số điện thoại</label>
                <input class="form-control" name="sdt">
            </div>
            <div class="mb-3">
                <label class="form-label">Mật khẩu</label>
                <input class="form-control" name="matKhau" type="password">
            </div>
            <div class="mb-3">
                <button class="btn btn-success">Đăng nhập</button>
            </div>
        </form>
    </div>
</body>
</html>
