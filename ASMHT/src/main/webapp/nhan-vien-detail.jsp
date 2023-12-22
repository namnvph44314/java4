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
                    <form action="/update/nhanVien?id=${nv.id}" method="post">
                        <div class="mb-3">
                            <label class="form-label">Mã</label>
                            <input type="text" class="form-control" name="ma" value="${nv.ma}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên</label>
                            <input type="text" class="form-control" name="ten"value="${nv.ten}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Tên đệm</label>
                            <input type="text" class="form-control" name="tenDem"value="${nv.tenDem}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Họ</label>
                            <input type="text" class="form-control" name="ho"value="${nv.ho}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Giới tính</label>
                            <input class="form-check-input" type="radio" name="gioiTinh"value="Nam"<c:if test="${nv.gioiTinh=='Nam'}"> checked</c:if>>
                            <label class="form-check-label">
                                Nam
                            </label>
                            <input class="form-check-input" type="radio" name="gioiTinh" value="Nữ"<c:if test="${nv.gioiTinh=='Nữ'}"> checked</c:if>>
                            <label class="form-check-label">
                                Nữ
                            </label>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Ngày sinh</label>
                            <input type="date" id="start" class="form-control" name="ngaySinh" value="${nv.ngaySinh}"/>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Địa chỉ</label>
                            <input type="text" class="form-control" name="diaChi" value="${nv.diaChi}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Số điện thoại</label>
                            <input type="text" class="form-control" name="sdt" value="${nv.SDT}">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="text" class="form-control" name="matKhau" value="${nv.matKhau} ">
                        </div>
                        <div class="mb-3">
                            <select class="form-select" aria-label="Default select example">
                                <c:forEach var="i" items="${lstCH}">
                                    <option value=" ${i.id}" <c:if test="${nv.cuaHang.id==i.id}"> selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Chức vụ</label>
                            <select class="form-select" aria-label="Default select example">
                                <c:forEach var="i" items="${lstCV}">
                                    <option value=" ${i.id}"<c:if test="${nv.chucVu.id==i.id}"> selected</c:if>>${i.ten}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">IdGuiBC</label>
                            <select class="form-select" aria-label="Default select example">
                                <c:forEach var="i" items="${lstGuiBC}">
                                    <option value="${i.id}" <c:if test="${nv.nhanVien.id==i.id}"> selected</c:if>>${i.id}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Trạng thái</label>
                            <input type="text" class="form-control" name="trangThai" value="${nv.trangThai}">
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
