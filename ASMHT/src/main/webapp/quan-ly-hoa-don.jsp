<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/30/2023
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
<head>
    <title>Title</title>
</head>
<body class="bg-light">
<nav class="navbar navbar-expand-lg navbar-light bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand text-light" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active text-light" aria-current="page" href="/trangChu/hienThi">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-light" href="/hien-thi-tat-ca/hoa-don">Quản lý hóa đơn</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-light" href="#" id="navbarDropdown" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">
                        Dropdown
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#">Action</a></li>
                        <li><a class="dropdown-item" href="#">Another action</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                    </ul>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled text-light" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <a href="/hienThi/gioHangChiTiet" class="btn btn-primary mx-3">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart4"
                     viewBox="0 0 16 16">
                    <path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5M3.14 5l.5 2H5V5zM6 5v2h2V5zm3 0v2h2V5zm3 0v2h1.36l.5-2zm1.11 3H12v2h.61zM11 8H9v2h2zM8 8H6v2h2zM5 8H3.89l.5 2H5zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0m9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2m-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0"/>
                </svg>
            </a>
            <form class="d-flex mt-3">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-success text-light" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container mt-5">
    <form action="/loc/hoa-don" method="get">
        <select class="form-select" aria-label="Default select example" name="loc">
            <option value="Tất cả">Tất cả</option>
            <option value="1">Đang giao hàng</option>
            <option value="2">Đã thanh toán</option>
            <option value="3">Đã hủy</option>
        </select>
        <button class="btn btn-primary" type="submit">Lọc</button>
    </form>
    <form>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Mã</th>
                <th scope="col">Nhân viên</th>
                <th scope="col">Khách hàng</th>
                <th scope="col">Địa chỉ</th>
                <th scope="col">Số điện thoại</th>
                <th scope="col">Ngày tạo</th>
                <th scope="col">Ngày thanh toán</th>
                <th scope="col">Ngày ship</th>
                <th scope="col">Ngày nhận</th>
                <th scope="col">Tình trạng</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="i" items="${lstHD}">
                <tr>
                    <td>${i.ma}</td>
                    <td>${i.nhanVien.ten}</td>
                    <td>${i.khachHang.ten}</td>
                    <td>${i.diaChi}</td>
                    <td>${i.SDT}</td>
                    <td>${i.ngayTao}</td>
                    <td>${i.ngayThanhToan}</td>
                    <td>${i.ngayShip}</td>
                    <td>${i.ngayNhan}</td>
                    <td>${i.getTinhTrang(i.tinhTrang)}</td>
                    <td>
                        <a href="/detail/hoa-don?id=${i.id}" class="btn btn-primary">Detail</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </form>

</div>
</body>
</html>
