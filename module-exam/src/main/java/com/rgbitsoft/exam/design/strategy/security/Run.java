package com.rgbitsoft.exam.design.strategy.security;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class Run {
    public static void main(String[] args) {

        Encoder encoder = new Encoder();

        final String rawText = "안녕하세요";

        // BCryptPasswordEncoder 전략사용 : Spring security
        encoder.setStrategy(new BCryptPasswordEncoder());
        System.out.println("BCryptPasswordEncoder 전략");
        System.out.println(encoder.getEncoded(rawText));
        System.out.println(encoder.getMatched(rawText,"$2a$10$An4znK8iDFYMNyl3WRyAAu.OB37PpT4nAOWZGey.Rshq3qnokzCnG"));

        // 전략 변경 -> Pbkdf2PasswordEncoder : Spring security
        encoder.setStrategy(new Pbkdf2PasswordEncoder());
        System.out.println("\nPbkdf2PasswordEncoder 전략");
        System.out.println(encoder.getEncoded(rawText));
        System.out.println(encoder.getMatched(rawText, "25c4e1fb5050b986769e484c9e3a2df0c09611fff4bffa93761d67e036ea9679d9b220753c801cd9"));


        // 전략 변경 -> Sha256NoSaltEncoder : My Custom
        encoder.setStrategy(new Sha256NoSaltEncoder());
        System.out.println("\nSha256NoSaltEncoder 전략");
        System.out.println(encoder.getEncoded(rawText));
        System.out.println(encoder.getMatched(rawText, "2c68318e352971113645cbc72861e1ec23f48d5baa5f9b405fed9dddca893eb4"));

    }
}
