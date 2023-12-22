<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 11/28/2023
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<head>
    <title>Title</title>
</head>
<body>
<h1>Đăng nhập thành công</h1>
<div class="container">
    <div class="row">
        <c:forEach var="i" items="${lstSP}">
            <div class="col-md-4">
                <div class="thumbnail">
                    <a href="/w3images/lights.jpg">
                        <img src="https://product.hstatic.net/1000253775/product/160_ao_thun_1m-13_c969e65fd47d4cf6b1afa8ef152a70f4_grande.jpg"
                             alt="Lights" style="width:50%">
                        <div class="caption">
                            <p>${i.ten}</p>
                        </div>
                    </a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
