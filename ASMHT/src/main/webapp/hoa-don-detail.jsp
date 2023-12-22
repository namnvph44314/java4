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
                    Thông tin Hóa đơn
                </div>
                <form action="/update/hoaDon?id=${hd.id}" method="post">
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
                            <input type="number" class="form-control" name="ma" value="${hd.ma}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày tạo</label>
                            <input type="date" class="form-control" name="ngayTao" value="${hd.ngayTao}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày thanh toán</label>
                            <input type="date" class="form-control" name="ngayThanhToan" value="${hd.ngayThanhToan}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày ship</label>
                            <input type="date" class="form-control" name="ngayShip" value="${hd.ngayShip}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày nhận</label>
                            <input type="date" class="form-control" name="ngayNhan"value="${hd.ngayNhan}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tình trạng</label>
                            <input type="date" class="form-control" name="tinhTrang"value="${hd.tinhTrang}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên người nhận</label>
                            <input type="date" class="form-control" name="tenNguoiNhan"value="${hd.tenNguoiNhan}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa chỉ</label>
                            <input type="date" class="form-control" name="diaChi"value="${hd.diaChi}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">SDT</label>
                            <input type="date" class="form-control" name="sdt" value="${hd.SDT}">
                        </div>
                        <div class="mb-3">
                            <button class="btn btn-success" type="submit">Submit</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
