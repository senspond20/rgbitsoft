package com.rgbitsoft.security.encryptor;

public interface PasswordEncryptor {

    /**
     * Encrypt a raw password
     * @param rawPassword
     * @return
     */
    String encrypt(String rawPassword);
}
