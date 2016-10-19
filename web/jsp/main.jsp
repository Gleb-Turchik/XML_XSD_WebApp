<%--
  Created by IntelliJ IDEA.
  User: Диана и Глеб
  Date: 27.06.2016
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Main</title>
</head>
<body>
<div class="container text-center">
<div class="row">
    <div class="col-sm-8 col-sm-offset-2">
        <h2 class="form-signin-heading">Welcome</h2>
        <hr/>Choose parser!<hr/>
        <form name="parser" method="POST" action="controller">
            <input type="hidden" name="command" value="dom"/>
            <input class="btn btn-primary" type="submit" value="DOM"/>
        </form>
        <form name="parser" method="POST" action="controller">
            <input type="hidden" name="command" value="sax"/>
            <input class="btn btn-primary" type="submit" value="SAX"/>
        </form>
        <form name="parser" method="POST" action="controller">
            <input type="hidden" name="command" value="stax"/>
            <input class="btn btn-primary" type="submit" value="StAX"/>
        </form>
        <form name="loginForm" method="POST" action="controller">
            <input type="hidden" name="command" value="logout"/>
            <input class="btn btn-default" type="submit" value="Logout"/>
        </form>
    </div>
</div>
</div>
</body>
</html>
