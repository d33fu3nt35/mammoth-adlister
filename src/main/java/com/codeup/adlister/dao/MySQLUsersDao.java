package com.codeup.adlister.dao;
import com.codeup.adlister.models.User;
import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
    public Long insertUser(User user) throws SQLException {
        String userName = user.getUsername();
        String userEmail = user.getEmail();
        String userPassword = user.getPassword();

        Statement stmt = connection.createStatement();

        String query = "INSERT INTO users(username , email, password) VALUES";
        query += "('" + userName + "', '" + userEmail + "', '" + userPassword + "')";
        System.out.println(query);
        stmt.execute(query);

        return null;
    }
}