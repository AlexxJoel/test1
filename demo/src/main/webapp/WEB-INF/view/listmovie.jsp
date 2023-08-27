<%@ page import="java.util.List" %>
<%@ page import="com.example.demo.model.Beanfilms" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String accion = request.getParameter("accion");
    String msg = request.getParameter("msg");
    List<Beanfilms> list = (List<Beanfilms>) request.getAttribute("listFilm");
    int index = 0;
%>

<html>
<head>
    <jsp:include page="/WEB-INF/templates/head.jsp"/>
    <title>Peliculas</title>
</head>
<body>
<div class="container">
    <a href="createmovie" class="btn btn-primary">Insertar pelicula</a>
</div>


<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">First</th>
        <th scope="col">Last</th>
        <th scope="col">Handle</th>
    </tr>
    </thead>
    <tbody>
    <% for (Beanfilms film:list) {
       index++;%>

    <tr>

        <th scope="row"><%=index%></th>
        <td><%= film.getName()%></td>
        <td><%= film.getDescription()%></td>
        <td><%= film.getPublish_date()%></td>
        <td><%= film.getActors()%></td>
        <td><%= film.getDuration()%></td>
        <td><%= film.getRanking()%></td>
        <td><%= film.getImage()%></td>
        <td>
            <a href="view-film?id=<%=film.getId()%>" class="btn btn-info">🖋️</a>

            <form action="delete-film" method="post" id="a">
                <input type="hidden" value="<%=film.getId()%>" name="id">
                <button type="submit" class="btn btn-danger">Accion eliminar</button>
            </form>

        </td>


    </tr>


    <%}


    %>


    </tbody>
</table>




<% if (accion != null ){
    if (accion.equals("ok")){ %>
        <div class="alert alert-success" role="alert">
            <%=msg%>
        </div>
    <% }else{ %>
        <div class="alert alert-danger" role="alert">
            <%=msg%>
        </div>
    <%}
}%>

<script >




        document.getElementById('a').addEventListener('submit', (e) => {
            e.preventDefault()

                //Ingresamos un mensaje
                var mensaje = confirm("¿Te gusta Desarrollar con JavaScript?");
                //Verificamos si el usuario acepto el mensaje
                if (mensaje) {
                    alert("¡Gracias por confirmar!");
                    document.getElementById('a').submit()
                }
                //Verificamos si el usuario denegó el mensaje
                else {
                    alert("¡Haz denegado el mensaje!");
                }

        })


</script>
</body>
</html>
