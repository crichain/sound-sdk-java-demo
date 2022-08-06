package com.gfanx;

import com.entity.KeyPairEntity;
import org.junit.Test;


public class KeyPairTest {

    /**
     * 获取密钥对
     */
    @Test
    public void keyPair(){
        KeyPairEntity keyPair = KeyPair.getKeyPair();
        String mnemonicWork = keyPair.getMnemonicWork();
        String privateKey = keyPair.getPrivateKey();
        String publicKey = keyPair.getPublicKey();
        String address = keyPair.getAddress();
        System.out.println("助记词："+mnemonicWork);
        System.out.println("私钥："+privateKey);
        System.out.println("公钥："+publicKey);
        System.out.println("地址：："+address);
    }
}
