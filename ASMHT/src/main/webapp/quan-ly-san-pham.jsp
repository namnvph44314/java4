<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/20/2023
  Time: 2:35 PM
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
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Link</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
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
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
            <form class="d-flex">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>

<div class="container">

    <ul class="nav nav-tabs" id="myTab" role="tablist">
        <li class="nav-item" role="presentation">
            <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home" type="button"
                    role="tab" aria-controls="home" aria-selected="true">Home
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile" type="button"
                    role="tab" aria-controls="profile" aria-selected="false">Profile
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="contact-tab" data-bs-toggle="tab" data-bs-target="#contact" type="button"
                    role="tab" aria-controls="contact" aria-selected="false">Contact
            </button>
        </li>
        <li class="nav-item" role="presentation">
            <button class="nav-link" id="new-tab" data-bs-toggle="tab" data-bs-target="#new" type="button" role="tab"
                    aria-controls="new" aria-selected="false">New
            </button>
        </li>
    </ul>

    <div class="card">
        <div class="card-header">
            Giỏ hàng chi tiết
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID giỏ hàng</th>
                    <th scope="col">ID chi tiết sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Đơn giá</th>
                    <th scope="col">Đơn giá khi giảm</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstGHCT}">
                    <tr>
                        <td>${i.gioHang.id}</td>
                        <td>${i.chiTietSanPham.id}</td>
                        <td>${i.soLuong}</td>
                        <td>${i.donGia}</td>
                        <td>${i.donGiaKhiGiam}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <div class="card">
        <div class="card-header">
            Dòng sản phẩm
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstDSP}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ten}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Giỏ hàng
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">IdKH</th>
                    <th scope="col">IdNV</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Ngày thanh toán</th>
                    <th scope="col">Tên người nhận</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col"> Số điện thoại</th>
                    <th scope="col">Tình trạng</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstGH}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.khachHang.id}</td>
                        <td>${i.nhanVien.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ngayTao}</td>
                        <td>${i.ngayThanhToan}</td>
                        <td>${i.tenNguoiNhan}</td>
                        <td>${i.diaChi}</td>
                        <td>${i.SDT}</td>
                        <td>${i.tinhTrang}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Hóa đơn chi tiết
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id hóa đơn</th>
                    <th scope="col">Id chi tiết sản phẩm</th>
                    <th scope="col">Số lượng</th>
                    <th scope="col">Đơn giá</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstHDCT}">
                    <tr>
                        <td>${i.hoaDon.id}</td>
                        <td>${i.chiTietSanPham.id}</td>
                        <td>${i.soLuong}</td>
                        <td>${i.donGia}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Hóa đơn
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">IdKH</th>
                    <th scope="col">IdNV</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Ngày tạo</th>
                    <th scope="col">Ngày thanh toán</th>
                    <th scope="col">Ngày Ship</th>
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
                        <td>${i.khachHang.id}</td>
                        <td>${i.nhanVien.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ngayTao}</td>
                        <td>${i.ngayThanhToan}</td>
                        <td>${i.ngayShip}</td>
                        <td>${i.ngayNhan}</td>
                        <td>${i.tinhTrang}</td>
                        <td>${i.tenNguoiNhan}</td>
                        <td>${i.diaChi}</td>
                        <td>${i.SDT}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Khách hàng
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Tên đệm</th>
                    <th scope="col">Họ</th>
                    <th scope="col">Ngày sinh</th>
                    <th scope="col">SĐT</th>
                    <th scope="col">Địa chỉ</th>
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
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Màu sắc
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstMS}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ten}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            NSX
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstNSX}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ten}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Sản phẩm
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstSP}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ten}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="card">
        <div class="card-header">
            Nhân viên
        </div>
        <div class="card-body">
            <table class="table">
                <thead>
                <tr>
                    <th scope="col">Id</th>
                    <th scope="col">Mã</th>
                    <th scope="col">Tên</th>
                    <th scope="col">Tên đệm</th>
                    <th scope="col">Họ</th>
                    <th scope="col">Giới tính</th>
                    <th scope="col">Ngày sinh</th>
                    <th scope="col">Địa chỉ</th>
                    <th scope="col">SĐT</th>
                    <th scope="col">Mật khẩu</th>
                    <th scope="col">IdCH</th>
                    <th scope="col">IdCV</th>
                    <th scope="col">IdGuiBC</th>
                    <th scope="col">Trạng thái</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="i" items="${lstNV}">
                    <tr>
                        <td>${i.id}</td>
                        <td>${i.ma}</td>
                        <td>${i.ten}</td>
                        <td>${i.tenDem}</td>
                        <td>${i.ho}</td>
                        <td>${i.gioiTinh}</td>
                        <td>${i.ngaySinh}</td>
                        <td>${i.diaChi}</td>
                        <td>${i.SDT}</td>
                        <td>${i.matKhau}</td>
                        <td>${i.chucVu.id}</td>
                        <td>${i.cuaHang.id}</td>
                        <td>${i.nhanVien.id}</td>
                        <td>${i.trangThai}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
