package com.rgbitsoft.exam.design.strategy.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256NoSaltEncoder implements PasswordEncoder {

    private MessageDigest messageDigest = null;

    public Sha256NoSaltEncoder(){
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encode(CharSequence rawPassword) {
        messageDigest.update(rawPassword.toString().getBytes());
        StringBuilder hexString = new StringBuilder();
        for(byte byteDatum : messageDigest.digest()) {
            String hex = Integer.toHexString(0xff&byteDatum);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword.toString()).equals(encodedPassword);
    }
}
