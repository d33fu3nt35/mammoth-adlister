package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.UsersDaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by daniel on 6/9/17.
 */
@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                1, // for now we'll hardcode the user id
                request.getParameter("username"),
                request.getParameter("email"),
                request.getParameter("password")
        );
        try {
            UsersDaoFactory.getUsersDao().insertUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/register");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);

    }
}
