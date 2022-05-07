package com.rgbitsoft.exam.design.strategy.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.CharEncoding;
import org.apache.commons.codec.binary.Hex;

public class AES128Strategy implements EncryptionStrategy {
    private final String SECRET_KEY = "비밀키";
    private final String DEFAULT_CHARSET = CharEncoding.UTF_8;
    private SecretKeySpec byte16key;

    private AES128Strategy(){
        this.byte16key = generateAES128Key(SECRET_KEY, DEFAULT_CHARSET);
    }

    public static AES128Strategy getInstance(){
        return AES128Strategy.LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final AES128Strategy INSTANCE = new AES128Strategy();
    }

    private SecretKeySpec generateAES128Key(final String key, final String encoding) {
        try {
            final byte[] finalKey = new byte[16];
            int i = 0;
            for(byte b : key.getBytes(encoding)) {
                finalKey[i++ % 16] ^= b;
            }
            return new SecretKeySpec(finalKey, "AES");
        }catch(UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 암호화 mariadb : SELECT HEX(AES_ENCRYPT('text',@secretKey));
     */
    @Override
    public String encode(String rawText) {
        String encStr = null;
        try {
            final Cipher encryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            encryptCipher.init(Cipher.ENCRYPT_MODE, this.byte16key);
            encStr = new String(Hex.encodeHex(encryptCipher.doFinal(rawText.getBytes(DEFAULT_CHARSET)))).toUpperCase();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return encStr;
    }

    /**
     * 복호화 mariadb : SELECT CAST(AES_DECRYPT(UNHEX(encStr), @secretKey) AS CHAR);
     */
    @Override
    public String decode(String encodedText) {
        String decStr = null;
        try {
            final Cipher decryptCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, this.byte16key);
            decStr = new String(decryptCipher.doFinal(Hex.decodeHex(encodedText.toCharArray())), DEFAULT_CHARSET);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        return decStr;
    }

    @Override
    public boolean matches(String rawText, String encodedText) {
//        return decode(encodedText).equals(rawText);
        return encode(rawText).equals(encodedText);
    }

}
