<%--
  Created by IntelliJ IDEA.
  User: win8
  Date: 22.12.2017
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>W TRY MIGA </title>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">


    <link rel="icon" type="image/png" sizes="32x32" href="../images/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="96x96" href="../images/favicon-96x96.png">
    <link rel="icon" type="image/png" sizes="16x16" href="../images/favicon-16x16.png">

    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <meta http-equiv="Content-Type" contentType="text/html; charset=iso-8859-2" pageEncoding="windows-1250">

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
        <div class="col-sm">
            <div class="headerText">
                <div>
                    Z WYDARZENIA NA WYDARZENIE
                </div>
            </div>
            <div class="logo">
                <img src="../images/logo1.png">
            </div>
            <div class="blackshape">
                <br> <br>
                <h1>Wybierz </h1>
                <form class="form-signin" method="post" action="/main-menu">
                    <div class="center-in_column">
                        <button class="button-ms" name="button1" type="submit" value="1">Wydarzenia</button>
                    </div>
                    <div class="center-in_column">
                        <button class="button-ms" name="button2" type="submit" value="1">Rozkład jazdy</button>
                    </div>
                    <div class="center-in_column">
                        <button class="button-ms" name="button3" type="submit" value="1">O Autorach</button>
                    </div>
                </form>

            </div>
        </div>
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
    </div>
</div>
</body>
</html>
