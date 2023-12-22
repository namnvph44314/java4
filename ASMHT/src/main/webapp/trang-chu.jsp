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
                    <a class="nav-link active text-light" aria-current="page" href="#">Home</a>
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
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
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
<h5>Chào mừng ${kh.ten}</h5>
<div class="container mt-5">
    <div class="row py-3">
        <div class="col-8">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                            class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                            aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                            aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://www.shopcongngheso.vn/Upload/SlideShow/2019/04/09/03/27/23/hq-official-banner-1920x550-landing-page-1-1.jpg?v=1"
                             class="d-block w-100" alt="Lights" style="width:100%; height: 340px">
                    </div>
                    <div class="carousel-item">
                        <img src="https://phucanhcdn.com/media/news/4630_30516583_1281597018651869_7989533494420176896_n.jpg"
                             class="d-block w-100" alt="Lights" style="width:100%; height: 340px">
                    </div>
                    <div class="carousel-item">
                        <img src="https://laptopbaominh.com/wp-content/uploads/2015/08/banner-n05.jpg"
                             class="d-block w-100" alt="Lights" style="width:100%; height: 340px">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                        data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class="col-4">
            <div class="row">
                <img src="https://truonggiang.vn/wp-content/uploads/2021/07/banner-laptop-sinh-vien-scaled.jpg"
                     class="d-block w-100" alt="Lights" style="width:100%; height: 160px">
            </div>
            <div class="row mt-3">
                <img src="https://nguyenlam.com/wp-content/uploads/2021/04/Banner-Consumer_690x300.jpg"
                     class="d-block w-100" alt="Lights" style="width:100%; height: 160px">
            </div>
        </div>
    </div>
    <div class="bg-secondary text-white text-center">
        <h1 class="p-2">Tất cả sản phẩm</h1>
    </div>
    <div class="row">
        <c:forEach var="i" items="${lstCTSP}">
            <div class="col-md-2">
                <div class="thumbnail bg-white">
                    <a href="/thongTin/sanPham?id=${i.id}" style="text-decoration: none; color: white">
                        <img src="https://laptop88.vn/media/product/pro_poster_8317.jpg"
                             alt="Lights" style="width:100%">
                        <div class="caption">
                            <p class="text-dark">${i.sanPham.ten}</p>
                        </div>
                        <label class="text-danger"><b>${i.giaBan}</b></label>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
