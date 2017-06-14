package com.codeup.adlister.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * Created by daniel on 6/13/17.
 */
public class Password {
    static final int numberOfRounds = 12;

    public static String hashPassword(String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt(numberOfRounds));

    }

}
