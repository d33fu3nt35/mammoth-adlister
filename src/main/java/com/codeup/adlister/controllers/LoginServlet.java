package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.utils.Password;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        // TODO: find a record in your database that matches the submitted password

        User userLogin = DaoFactory.getUsersDao().findByUsername(username);
        if(userLogin == null){
            request.setAttribute("usererror", "Username not found!");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
            return;
        }
        boolean attempt = BCrypt.checkpw(password, userLogin.getPassword());

        System.out.println(attempt);

//        System.out.println(userLogin.getPassword());

        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database

        if (attempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            request.setAttribute("passworderror", "Password incorrect!");
            request.getRequestDispatcher("/WEB-INF/login.jsp")
                    .forward(request, response);
//            response.sendRedirect("/login");
        }
    }
}
