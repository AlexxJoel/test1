package com.example.demo.controller;

import com.example.demo.model.Beanuser;
import com.example.demo.model.Daouser;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "Servletuser", urlPatterns = {
        "/login",
        "/sesion"
})
public class Servletuser extends HttpServlet {

    Beanuser user;
    Daouser daouser = new Daouser();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String path= request.getServletPath();
        switch (path){
            case "/sesion":
                request.getRequestDispatcher("/index.jsp").forward(request,response);
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
            case "/login":
                String email = request.getParameter("email");
                String pwd = request.getParameter("pwd");
                   user= new Beanuser(email,pwd);

                   user  = daouser.userlogin(user);
                if (user.getId()!=0){
                    response.sendRedirect("listmovie");
                }else{
                    response.sendRedirect("sesion");
                }
                break;
            default:
        }
    }
}
