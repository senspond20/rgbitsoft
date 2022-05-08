package com.rgbitsoft.exam.design.strategy.security;

import com.rgbitsoft.exam.design.strategy.encrypt.EncryptionStrategy;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Encoder {
    private PasswordEncoder passwordEncoder;
    public String getEncoded(String rawText){
        return this.passwordEncoder.encode(rawText);
    }

    public boolean getMatched(String rawText, String encodedText){
        return this.passwordEncoder.matches(rawText, encodedText);
    }

    public void setStrategy(PasswordEncoder encoder) {
        this.passwordEncoder = encoder;
    }
}
