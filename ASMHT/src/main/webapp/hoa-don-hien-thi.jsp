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
                Thêm mới hóa đơn
            </div>
            <form action="/add/gioHangChiTiet" method="post">
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label">Khách hàng</label>
                        <select class="form-select" aria-label="Default select example" name="idKH">
                            <c:forEach var="i" items="${lstKH}">
                                <option value="${i.id}">${i.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nhân viên</label>
                        <select class="form-select" aria-label="Default select example" name="idNV">
                            <c:forEach var="i" items="${lstNV}">
                                <option value="${i.id}">${i.ma}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Mã</label>
                        <input type="number" class="form-control" name="ma">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày tạo</label>
                        <input type="date" class="form-control" name="ngayTao">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngaày thanh toán</label>
                        <input type="date" class="form-control" name="ngayThanhToan">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày ship</label>
                        <input type="date" class="form-control" name="ngayShip">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Ngày nhận</label>
                        <input type="date" class="form-control" name="ngayNhan">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tình trạng</label>
                        <input type="date" class="form-control" name="tinhTrang">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Tên người nhận</label>
                        <input type="date" class="form-control" name="tenNguoiNhan">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Địa chỉ</label>
                        <input type="date" class="form-control" name="diaChi">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">SDT</label>
                        <input type="date" class="form-control" name="sdt">
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
                Danh sách hóa đơn
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Khách hàng</th>
                        <th scope="col">Nhân viên</th>
                        <th scope="col">Mã</th>
                        <th scope="col">Ngày tạo</th>
                        <th scope="col">Ngày thanh toán </th>
                        <th scope="col">Ngày ship</th>
                        <th scope="col">Ngày nhận</th>
                        <th scope="col">Tình trạng</th>
                        <th scope="col">Tên người nhận</th>
                        <th scope="col">Địa chỉ</th>
                        <th scope="col">SĐT</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${lstHD}">
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.khachHang.ma}</td>
                            <td>${i.nhanVien.ma}</td>
                            <td>${i.ma}</td>
                            <td>${i.ngayTao}</td>
                            <td>${i.ngayThanhToan}</td>
                            <td>${i.ngayShip}</td>
                            <td>${i.ngayNhan}</td>
                            <td>${i.tinhTrang}</td>
                            <td>${i.tenNguoiNhan}</td>
                            <td>${i.diaChi}</td>
                            <td>${i.SDT}</td>
                            <td>
                                <a href="/detail/hoaDon?idGH=${i.id}" class="btn btn-warning">Detail</a>
                                <a href="" class="btn btn-danger">Delete</a>
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
