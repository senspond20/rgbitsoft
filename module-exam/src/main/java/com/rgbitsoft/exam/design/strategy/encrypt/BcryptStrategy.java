package com.rgbitsoft.exam.design.strategy.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptStrategy implements EncryptionStrategy {

    private BCryptPasswordEncoder passwordEncoder;

    private BcryptStrategy(){
        passwordEncoder = new BCryptPasswordEncoder();
    }
    public static BcryptStrategy getInstance(){
        return BcryptStrategy.LazyHolder.INSTANCE;
    }
    private static class LazyHolder{
        private static final BcryptStrategy INSTANCE = new BcryptStrategy();
    }

    @Override
    public String encode(String rawText) {
        return passwordEncoder.encode(rawText);
    }

    @Override
    public String decode(String text) {
        return null;
    }

    @Override
    public boolean matches(String rawText, String encodedText) {
        return passwordEncoder.matches(rawText, encodedText);
    }


}
