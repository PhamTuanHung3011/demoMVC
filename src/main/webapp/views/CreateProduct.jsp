<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/27/2021
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <h2> Crate Product</h2>
    <form method="post" >
        <table class="table table-striped">
            <tr>
                <th>ID</th>
                <th>Product Name</th>
                <th>Price</th>
                <th>IMG</th>
            </tr>
            <tr>
                <input type="hidden" name="action" value="create">
<%--                <td><input type="text" name="id" placeholder="Enter ID"></td>--%>
                <td><input type="text" name="name" placeholder="Enter name"></td>
                <td><input type="text" name="price" placeholder="Enter price"></td>
                <td><input type="text" name="img" placeholder="Enter img"></td>
            </tr>
        </table>
        <a href="/?action=create"><input type="submit" value="Create"></a>
    </form>

</div>

</body>
</html>
