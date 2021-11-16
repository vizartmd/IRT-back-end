package com.stefanini.irtbackend.config;


import java.security.SecureRandom;
import java.util.Random;

public class GenerateSecurePassword {
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String generatePassword(int passwordLength) {
        StringBuilder returnValue = new StringBuilder(passwordLength);
        for (int i = 0; i < passwordLength; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}