//package com.codeup.adlister.dao;
//
//import java.sql.SQLException;
//
//public class UsersDaoFactory {
//    private static Users usersDao;
//
//    public static Users getUsersDao() throws SQLException {
//        if (usersDao == null) {
//            usersDao = new MySQLUsersDao();
//        }
//        return usersDao;
//    }
//}