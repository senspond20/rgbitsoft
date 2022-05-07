package com.rgbitsoft.exam.design.strategy.encrypt;

public interface EncryptionStrategy {
    String encode(String rawText);
    String decode(String encodedText);
    boolean matches(String rawText, String encodedText);
}
