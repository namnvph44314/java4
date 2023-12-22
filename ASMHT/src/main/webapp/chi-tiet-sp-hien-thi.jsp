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
                Thêm mới chi tiết SP
            </div>
            <form action="/add/chiTietSP" method="post">
                <div class="card-body">
                    <div class="mb-3">
                        <label class="form-label">Sản phẩm</label>
                        <select class="form-select" aria-label="Default select example" name="idSP">
                            <c:forEach var="i" items="${lstSP}">
                                <option value="${i.id}">${i.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nhà sản xuất</label>
                        <select class="form-select" aria-label="Default select example" name="idNSX">
                            <c:forEach var="i" items="${lstNSX}">
                                <option value="${i.id}">${i.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Màu sắc</label>
                        <select class="form-select" aria-label="Default select example" name="idMS">
                            <c:forEach var="i" items="${lstMS}">
                                <option value="${i.id}">${i.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Dòng sản phẩm</label>
                        <select class="form-select" aria-label="Default select example" name="idDSP">
                            <c:forEach var="i" items="${lstDSP}">
                                <option value="${i.id}">${i.ten}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Năm bảo hành</label>
                        <input type="number" class="form-control" name="namBaoHanh">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Mô tả</label>
                        <input type="text" class="form-control" name="moTa">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Số lượng tồn</label>
                        <input type="number" class="form-control" name="soLuongTon">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Giá nhập</label>
                        <input type="number" class="form-control" name="giaNhap">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Giá bán</label>
                        <input type="number" class="form-control" name="giaBan">
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
                Danh sách chi tiết SP
            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Tên SP</th>
                        <th scope="col">Tên Nsx</th>
                        <th scope="col">Tên Màu Sac</th>
                        <th scope="col">Tên DongSP</th>
                        <th scope="col">Năm bảo hành</th>
                        <th scope="col">Mô tả</th>
                        <th scope="col">Số lượng tồn</th>
                        <th scope="col">Giá nhập</th>
                        <th scope="col">Giá bán</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="i" items="${lstCTSP}">
                        <tr>
                            <td>${i.id}</td>
                            <td>${i.sanPham.ten}</td>
                            <td>${i.NSX.ten}</td>
                            <td>${i.mauSac.ten}</td>
                            <td>${i.dongSP.ten}</td>
                            <td>${i.namBaoHanh}</td>
                            <td>${i.moTa}</td>
                            <td>${i.soLuongTon}</td>
                            <td>${i.giaNhap}</td>
                            <td>${i.giaBan}</td>
                            <td>
                                <a href="/detail/chiTietSP?id=${i.id}" class="btn btn-warning">Detail</a>
                                <a href="/delete/chiTietSP?id=${i.id}" class="btn btn-danger">Delete</a>
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
