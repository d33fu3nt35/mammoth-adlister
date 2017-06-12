package com.codeup.adlister.dao;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 6/9/17.
 */
public class MySQLUsersDao implements Users {

    Connection connection = null;

    public MySQLUsersDao() throws SQLException {
        Config config = new Config();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        DriverManager.registerDriver(new Driver());
        connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUsername(),
                config.getPassword()
        );
    }

    @Override
    public Long insertUser(User user) {
//        String userName = user.getUsername();
//        String userEmail = user.getEmail();
//        String userPassword = user.getPassword();
//
//        Statement stmt = connection.createStatement();
//
//        String query = "INSERT INTO users(username , email, password) VALUES";
//        query += "('" + userName + "', '" + userEmail + "', '" + userPassword + "')";
//        System.out.println(query);
//        stmt.execute(query);

        try {
            PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO users(username , email, password) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("password")
        );
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            users.add(extractUser(rs));
        }
        return users;
    }
}