package com.nibm.eadcw.loginandregis.encryption;

public interface Crypto {
    byte [] encrypt(byte[] data);

    byte [] decrypt(byte[] data);
}
