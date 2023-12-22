<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/22/2023
  Time: 8:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="card">
            <div class="card">
                <div class="card-header">
                    Thông tin chức vụ
                </div>
                <div class="card-body">
                    <form action="/update/chucVu?id=${chucVuDetail.id}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã</label>
                            <input type="text" class="form-control" value="${chucVuDetail.ma}" name="ma">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" value="${chucVuDetail.ten}" name="ten">
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-warning" type="submit">Update</button>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </div>
</body>
</html>
