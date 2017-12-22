<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="pl-PL">
<head>

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
    <title>W TRY MIGA </title>

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

                <form class="form-signin"   method="post" action="/main-menu">
                    <h2 class="form-signin-heading">REJESTRACJA</h2>
                    <label for="inputEmail" class="sr-only">Email </label>
                    <input type="email" id="inputEmail" class="form-control" placeholder="Email address" autofocus>
                    <br>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" id="inputPassword" class="form-control" placeholder="Hasło" >
                    <div class="checkbox">
                        <label>
                            <input type="checkbox" value="remember-me"> zapamiętaj
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Zapisz</button>
                    <br>
                </form>

            </div> <!-- /container -->
          <%--  <form class="form-signin"  method="post" action="/main-menu" >
            <div class="center-element-col">
                <button class="btn btn-lg btn-primary" type="submit">Rozkład jazdy</button>
            </div>
            </form>--%>
        </div>
        <div class="col-sm">
            <%--One of three columns--%>
        </div>
    </div>
</div>


</body>
</html>