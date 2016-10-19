<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Диана и Глеб
  Date: 27.06.2016
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <title>Parser Sign In</title>
</head>
<body>
<jsp:include page="language.jsp"/>
    <div class="container text-center">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
            <form class="form-inline" method="POST" action="controller">
            <h2 class="form-signin-heading">Please sign in</h2>
            <input type="hidden" name="command" value="login"/>
            <div class="form-group">
            <label class="sr-only" for="exampleInputEmail3">Email address</label>
            <input type="text" name="login" value="" class="form-control" id="exampleInputEmail3" placeholder="Email">
            </div><br/>

            <div class="form-group">
            <label class="sr-only" for="exampleInputPassword3">Password</label>
            <input type="password" name="password" value="" class="form-control" id="exampleInputPassword3" placeholder="Password">
            </div><br/>
            <div class="checkbox">
        <label>
            <input type="checkbox"> Remember me
        </label>
    </div><br/>
            <button type="submit" class="btn btn-default" value="Log in">Sign in</button><br/>



            <c:if test="${not empty errorLoginPassMessage}">
            <div class="alert alert-danger" role="alert">
                ${errorLoginPassMessage}
            </div>
            </c:if>
                <c:if test="${wrongAction}">
            <div class="alert alert-danger" role="alert">
                    ${wrongAction}
            </div>
            </c:if>
                <c:if test="${nullPage}">
            <div class="alert alert-danger" role="alert">
                    ${nullPage}
            </div>
            </c:if>


            </form>
                <ctg:info-time/>
                <ctg:hello role="${ user }"/>
                <%--<ctg:table-revenue rows="${ rw.size }" head="Revenue">
                    ${ rw.revenue }
                </ctg:table-revenue >
                <br/>
                <ctg:table-revenue>5 rub BulbaComp</ctg:table-revenue >--%>
            </div>
        </div>
    </div>
</body>
</html>
