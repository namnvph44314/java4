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
                    Thông tin chi tiết SP
                </div>
                <form action="/update/chiTietSP?id=${ctsp.id}" method="post">
                    <div class="card-body">
                        <div class="mb-3">
                            <label class="form-label">Sản phẩm</label>
                            <select class="form-select" aria-label="Default select example" name="idSP">
                                <c:forEach var="i" items="${lstSP}">
                                    <option value="${i.id}"<c:if test="${ctsp.sanPham.id==i.id}">selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Nhà sản xuất</label>
                            <select class="form-select" aria-label="Default select example" name="idNSX">
                                <c:forEach var="i" items="${lstNSX}">
                                    <option value="${i.id}"<c:if test="${ctsp.NSX.id==i.id}">selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Màu sắc</label>
                            <select class="form-select" aria-label="Default select example" name="idMS">
                                <c:forEach var="i" items="${lstMS}">
                                    <option value="${i.id}"<c:if test="${ctsp.mauSac.id==i.id}">selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Dòng sản phẩm</label>
                            <select class="form-select" aria-label="Default select example" name="idDSP">
                                <c:forEach var="i" items="${lstDSP}">
                                    <option value="${i.id}"<c:if test="${ctsp.dongSP.id==i.id}">selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Năm bảo hành</label>
                            <input type="number" class="form-control" name="namBaoHanh" value="${ctsp.namBaoHanh}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mô tả</label>
                            <input type="text" class="form-control" name="moTa" value="${ctsp.moTa}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số lượng tồn</label>
                            <input type="number" class="form-control" name="soLuongTon" value="${ctsp.soLuongTon}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giá nhập</label>
                            <input type="number" class="form-control" name="giaNhap"value="${ctsp.giaNhap}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giá bán</label>
                            <input type="number" class="form-control" name="giaBan" value="${ctsp.giaBan}">
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
