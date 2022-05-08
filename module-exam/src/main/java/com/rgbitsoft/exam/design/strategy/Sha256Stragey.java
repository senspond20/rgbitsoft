package com.rgbitsoft.exam.design.strategy;

import com.rgbitsoft.exam.design.signleton.LazyHolderSingleton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Stragey implements EncodingStrategy {
    private MessageDigest messageDigest;

    private Sha256Stragey(){
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static Sha256Stragey getInstance(){
        return Sha256Stragey.LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final Sha256Stragey INSTANCE = new Sha256Stragey();
    }

    @Override
    public String encode(String text) {
        messageDigest.update(text.getBytes());
        StringBuilder hexString = new StringBuilder();
        for(byte byteDatum : messageDigest.digest()) {
            String hex = Integer.toHexString(0xff&byteDatum);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
