package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import com.codeup.adlister.utils.Password;

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
    private String password;
    private String confirm;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        String confirm = request.getParameter("confirm");

        // if
        if (confirm.equals(password)) {

            User user = new User(
                    request.getParameter("username"),
                    request.getParameter("email"),
                    Password.hashPassword(password)
            );

            try {
                DaoFactory.getUsersDao().insertUser(user);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            response.sendRedirect("/register");
        }else{
            request.setAttribute("error", "Passwords do not match!");
            request.getRequestDispatcher("/WEB-INF/register.jsp")
                    .forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp")
                .forward(request, response);

    }
}
