package com.flipkart.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class UserAuth {

    private static final HashMap<Integer, String> tokenHashMap = new HashMap<Integer, String>();

    private static String generateToken(String input) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(input.getBytes(StandardCharsets.UTF_8));
        return String.valueOf(hash);
    }

    public static String getToken(int userID) {
        if (tokenHashMap.get(userID) != null) {
            return tokenHashMap.get(userID);
        }
        String token = "";
        try {
            token = generateToken(String.valueOf(userID));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (!token.equals("")) {
            tokenHashMap.put(userID, token);
        }
        return token;
    }

    public static boolean verifyToken(int userID, String token) {
        return token.equals(tokenHashMap.get(userID));
    }

}
