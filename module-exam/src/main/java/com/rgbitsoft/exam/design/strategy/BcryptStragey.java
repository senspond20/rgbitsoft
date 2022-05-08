package com.rgbitsoft.exam.design.strategy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class BcryptStragey implements EncodingStrategy{

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public BcryptStragey(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public String encode(String text) {
        return bCryptPasswordEncoder.encode(text);
    }
}
