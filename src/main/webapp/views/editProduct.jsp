<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/28/2021
  Time: 9:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container">
    <h2> Edit Product</h2>
    <form method="post" >
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>IMG</th>
            </tr>
            <tr>
                <input type="hidden" name="action" value="edit">
                <td><input type="text" name="id" value="${products.id}" hidden></td>
                <td><input type="text" name="name" value="${products.name}" placeholder="${products.name}"></td>
                <td><input type="text" name="price" value="${products.price}" placeholder="${products.price}"></td>
                <td><input type="text" name="img" value="${products.img}" placeholder="${products.img}"></td>
            </tr>
        </table>
        <a href="/?action=edit"><input type="submit" value="EDIT"></a>
    </form>

</div>

</body>
</html>