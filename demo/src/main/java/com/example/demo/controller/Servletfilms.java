package com.example.demo.controller;

import com.example.demo.model.Beanfilms;
import com.example.demo.model.Beanuser;
import com.example.demo.model.Daofilms;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Servletfilms", urlPatterns = {
        "/listmovie",
        "/view-film",

        "/createmovie",
        "/savemovie",
        "/delete-film",
        "/updatemovie"
})

public class Servletfilms extends HttpServlet {
    Beanfilms film;
    Daofilms daofilms = new Daofilms();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        switch (path) {
            case "/listmovie":
                List<Beanfilms> rs = daofilms.getAll();
                request.setAttribute("listFilm", rs);
                request.getRequestDispatcher("/WEB-INF/view/listmovie.jsp").forward(request, response);
                break;
            case "/createmovie":
                request.getRequestDispatcher("/WEB-INF/view/createmovie.jsp").forward(request, response);
                break;
            case "/view-film":
                int id = Integer.parseInt(request.getParameter("id"));
                Beanfilms resp = daofilms.getById(id);
                request.setAttribute("film", resp);
                request.getRequestDispatcher("/WEB-INF/view/viewfilm.jsp").forward(request, response);




                break;

            default:
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String path = request.getServletPath();
        switch (path) {
            case "/savemovie":
                try {
                    String name = request.getParameter("name");
                    String des = request.getParameter("description");
                    String dia = request.getParameter("publish_date");
                    String act = request.getParameter("actors");
                    int duration = Integer.parseInt(request.getParameter("duration"));
                    int ran = Integer.parseInt(request.getParameter("ranking"));
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dia);

                    film = new Beanfilms(name, des, date, act, duration, ran);
                    boolean rs = daofilms.insertfilm(film);
                    response.sendRedirect(  "listmovie?accion=" + (rs?"ok":"error") + "&msg=" + (rs?"Pelicula guardada correctamente":"Fallo") );

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "/updatemovie":
                try {
                    String id =request.getParameter("id");
                    String name = request.getParameter("name");
                    String des = request.getParameter("description");
                    String dia = request.getParameter("publish_date");
                    String act = request.getParameter("actors");
                    int duration = Integer.parseInt(request.getParameter("duration"));
                    int ran = Integer.parseInt(request.getParameter("ranking"));
                    Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dia);

                    film = new Beanfilms(name, des, date, act, duration, ran);
                    film.setId(Integer.parseInt(id));

                    boolean rs = daofilms.update(film);
                    response.sendRedirect(  "listmovie?accion=" + (rs?"ok":"error") + "&msg=" + (rs?"Pelicula actualizada correctamente":"Fallo") );

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;

            case "/delete-film":

                String id =request.getParameter("id");

                boolean result = daofilms.deleteById(Integer.parseInt(id));
                response.sendRedirect(  "listmovie?accion=" + (result?"ok":"error") + "&msg=" + (result?"Pelicula eliminada correctamente":"Fallo") );

                break;
            default:
        }
    }
}
