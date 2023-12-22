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
                    Thông tin khách hàng
                </div>
                <form action="/update/khachHang?id=${kh.id}" method="post">
                    <div class="card-body">
                        <div class="mb-3">
                            <label class="form-label">Mã</label>
                            <input type="text" class="form-control" name="ma" value="${kh.ma}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" name="ten" value="${kh.ten}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên đệm</label>
                            <input type="text" class="form-control" name="tenDem" value="${kh.tenDem}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Họ</label>
                            <input type="text" class="form-control" name="ho" value="${kh.ho}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày sinh</label>
                            <input type="date" class="form-control" name="ngaySinh" value="${kh.ngaySinh}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <input type="text" class="form-control" name="sdt" value="${kh.SDT}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa chỉ</label>
                            <input type="text" class="form-control" name="diaChi" value="${kh.diaChi}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Thành phố</label>
                            <input type="text" class="form-control" name="thanhPho"value="${kh.thanhPho}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Quốc gia</label>
                            <input type="text" class="form-control" name="quocGia"value="${kh.quocGia}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="text" class="form-control" name="matKhau"value="${kh.matKhau}">
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-warning" type="submit">Update</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
