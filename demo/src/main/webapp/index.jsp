<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <jsp:include page="/WEB-INF/templates/head.jsp"/>

</head>
<body>
<h1 class="text-center mt-4"><%= "Iniciar sesión" %>
</h1>
<br/>
<%--<a href="hello-servlet">Hello Servlet</a>--%>


<div class="container">

    <div class="row row-cols-3">
        <div class="col"></div>

        <div class="col">
            <form action="login" method="post">
                <div class="form-group">
                    <label >Correo-e</label>
                    <input type="email" class="form-control"   placeholder="Enter email" name="email">
                    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                </div>
                <div class="form-group">
                    <label >Contraseña</label>
                    <input type="password" class="form-control"  placeholder="Password" name="pwd">
                </div>

                <button type="submit" class="btn btn-primary">Submit</button>
            </form>

        </div>
        <div class="col"></div>

    </div>

</div>

</body>
</html>