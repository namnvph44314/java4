<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/22/2023
  Time: 8:27 PM
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
                Thêm mới khách hàng
            </div>
            <form action="/add/khachHang" method="post">
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label">Mã</label>
                        <input type="text" class="form-control" name="ma">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tên</label>
                        <input type="text" class="form-control" name="ten">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tên đệm</label>
                        <input type="text" class="form-control" name="tenDem">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Họ</label>
                        <input type="text" class="form-control" name="ho">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày sinh</label>
                        <input type="date" class="form-control" name="ngaySinh">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số điện thoại</label>
                        <input type="text" class="form-control" name="sdt">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Địa chỉ</label>
                        <input type="text" class="form-control" name="diaChi">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Thành phố</label>
                        <input type="text" class="form-control" name="thanhPho">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Quốc gia</label>
                        <input type="text" class="form-control" name="quocGia">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Mật khẩu</label>
                        <input type="text" class="form-control" name="matKhau">
                    </div>
                    <div class="mb-3">
                        <button class="btn btn-success" type="submit">Submit</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="card">
        <div class="card">
            <div class="card-header">
                Danh sách khách hàng
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Mã</th>
                        <th scope="col">Tên</th>
                        <th scope="col">Tên đệm</th>
                        <th scope="col">Họ</th>
                        <th scope="col">Ngày sinh</th>
                        <th scope="col">SDT</th>
                        <th scope="col">địa chỉ</th>
                        <th scope="col">Thành phố</th>
                        <th scope="col">Quốc gia</th>
                        <th scope="col">Mật khẩu</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${lstKH}">
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.ma}</td>
                            <td>${i.ten}</td>
                            <td>${i.tenDem}</td>
                            <td>${i.ho}</td>
                            <td>${i.ngaySinh}</td>
                            <td>${i.SDT}</td>
                            <td>${i.diaChi}</td>
                            <td>${i.thanhPho}</td>
                            <td>${i.quocGia}</td>
                            <td>${i.matKhau}</td>
                            <td>
                                <a href="/detail/khachHang?id=${i.id}" class="btn btn-warning">Detail</a>
                                <a href="/delete/khachHang?id=${i.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
