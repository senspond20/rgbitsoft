package com.rgbitsoft.exam.design.strategy.encrypt;

import java.util.Base64;

public class Base64Strategy implements EncryptionStrategy {

    private Base64Strategy(){}
    public static Base64Strategy getInstance(){
        return Base64Strategy.LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final Base64Strategy INSTANCE = new Base64Strategy();
    }
    @Override
    public String encode(String rawText) {
        return Base64.getEncoder().encodeToString(rawText.getBytes());
    }

    @Override
    public String decode(String encodedText) {
        byte[] binary = Base64.getDecoder().decode(encodedText.getBytes());
        return new String(binary);
    }

    @Override
    public boolean matches(String rawText, String encodedText) {
//        return decode(encodedText).equals(rawText);
        return encode(rawText).equals(encodedText);
    }
}
