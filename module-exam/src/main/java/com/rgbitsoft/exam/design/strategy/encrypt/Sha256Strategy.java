package com.rgbitsoft.exam.design.strategy.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256Strategy implements EncryptionStrategy {
    private MessageDigest messageDigest;

    private Sha256Strategy(){
        try {
            this.messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static Sha256Strategy getInstance(){
        return LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final Sha256Strategy INSTANCE = new Sha256Strategy();
    }

    @Override
    public String encode(String rawText) {
        this.messageDigest.update(rawText.getBytes());
        StringBuilder hexString = new StringBuilder();
        for(byte byteDatum : messageDigest.digest()) {
            String hex = Integer.toHexString(0xff&byteDatum);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    @Override
    public String decode(String encodedText) {
        // 단반향 알고리즘 - 복호화 불가능
        return null;
    }

    @Override
    public boolean matches(String rawText, String encodedText) {
        return encode(rawText).equals(encodedText);
    }
}
