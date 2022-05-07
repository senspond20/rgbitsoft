package com.rgbitsoft.exam.design.strategy.encrypt;

public class Run {

    private static void print(Encryption enc, String title, String msg){
        String ss = enc.getEncoded(msg);
        System.out.println(String.format("[ %s ] ", title));
        System.out.println("원본 텍스트 : " + msg);
        System.out.println("암호화 : " + ss);
        String decoded = enc.getDecoded(ss);
        String result = (decoded == null) ? "불가능" : decoded;
        System.out.println("복호화 : " + result);
        System.out.println("Matched : " + enc.getMatched(msg, ss));
    }

    public static void main(String[] args) {

        final String MESSAGE = "안녕하세요@gmail.com";
        Encryption enc = new Encryption();

        enc.setStrategy(Base64Strategy.getInstance());
        print(enc, "BASE64", MESSAGE);

        enc.setStrategy(AES128Strategy.getInstance());
        print(enc, "AES128", MESSAGE);

        enc.setStrategy(Sha256Strategy.getInstance());
        print(enc, "SHA256", MESSAGE);

        enc.setStrategy(BcryptStrategy.getInstance());
        print(enc, "BCRYPT", MESSAGE);

//        System.out.println(BcryptStrategy.getInstance().match("안녕하세요@gmail.com", "$2a$10$OWN7rm9ZlL6Kpkn7jIjteunAc19/PBgbn1fpfA/lFHb94mOqdXSA6"));
    }
}
