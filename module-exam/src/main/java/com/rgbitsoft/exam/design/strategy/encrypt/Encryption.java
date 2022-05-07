package com.rgbitsoft.exam.design.strategy.encrypt;

public class Encryption {
    private EncryptionStrategy strategy;

    public String getEncoded(String rawText){
        return this.strategy.encode(rawText);
    }

    public String getDecoded(String encodedText){
        return this.strategy.decode(encodedText);
    }

    public boolean getMatched(String rawText, String encodedText){
        return this.strategy.matches(rawText, encodedText);
    }

    public void setStrategy(EncryptionStrategy strategy) {
        this.strategy = strategy;
    }

}
