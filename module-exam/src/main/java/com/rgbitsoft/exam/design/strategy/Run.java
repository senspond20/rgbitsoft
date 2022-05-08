package com.rgbitsoft.exam.design.strategy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.NoSuchAlgorithmException;

/**
 * 전략 패턴 , 객체지향의 꽃
 * 유사한 행위들을 캡슐화 하여, 객체의 행위를 바꾸고 싶은 경우 직접 변경하는 것이 아닌 전략만 변경
 * 유연하게 확장하는 패턴 SOLID중에서 개방폐쇄 원칙(OCP)와 의존 역전 원칙(DIP)를 따른다
 */
public class Run {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        Encoder encoder = new Encoder();

        // Base64
        EncodingStrategy base64 = new Base64Strategy();
        // noraml
        EncodingStrategy normal = new NormalStrategy();

        String msg = "hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(msg);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(msg);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(msg);

        encoder.setEncodingStrategy(new BcryptStragey(new BCryptPasswordEncoder()));
        String bcryptResult = encoder.getMessage(msg);

        encoder.setEncodingStrategy(Sha256Stragey.getInstance());


        String sha256 = encoder.getMessage(msg);

        System.out.println(base64Result);
        System.out.println(normalResult);
        System.out.println(appendResult);
        System.out.println(bcryptResult);
        System.out.println(sha256);
    }
}
