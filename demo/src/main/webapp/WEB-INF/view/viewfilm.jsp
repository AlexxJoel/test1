<%@ page import="com.example.demo.model.Beanfilms" %><%--
  Created by IntelliJ IDEA.
  User: joelh
  Date: 27/08/2023
  Time: 02:24 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Beanfilms film = (Beanfilms) request.getAttribute("film");
%>


<html>
<head>

    <title>Ver pelicula</title>
    <jsp:include page="/WEB-INF/templates/head.jsp"/>
</head>
<body>

<div class="row-cols-3 row">
    <div class="col">
        <form action="updatemovie" method="post">

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">nombre</label>
                <div class="col-sm-10">
                    <input type="text" name="name" class="form-control" pattern="[a-zA-Z ]{3,}" required value="<%= film.getName()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">descripcion</label>
                <div class="col-sm-10">
                    <input type="text" name="description" maxlength="1000" class="form-control" value="<%= film.getDescription()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Fecha de publicacion</label>
                <div class="col-sm-10">
                    <input type="date" name="publish_date" class="form-control" value="<%= film.getPublish_date()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">actores</label>
                <div class="col-sm-10">
                    <input type="text" name="actors" class="form-control" value="<%= film.getActors()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Duracion</label>
                <div class="col-sm-10">
                    <input type="number" min="0" name="duration" class="form-control" required value="<%= film.getDuration()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Puntaje</label>
                <div class="col-sm-10">
                    <input type="number" min="0" max="5" name="ranking" class="form-control" value="<%= film.getRanking()%>">
                </div>
            </div>

            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Imagen</label>
                <div class="col-sm-10">
                    <input type="file" name="image" class="form-control" accept="image/png" value="<%= film.getImage()%>">
                </div>
            </div>

            <input type="hidden" value="<%= film.getId()%>" name="id" >

            <button type="submit" class="btn btn-primary">Guardar</button>

        </form>

    </div>


</div>




</body>
</html>
