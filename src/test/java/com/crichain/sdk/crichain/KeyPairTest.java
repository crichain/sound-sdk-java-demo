package com.crichain.sdk.crichain;

import com.crichain.sdk.config.Config;
import com.crichain.sdk.constant.Server;
import com.crichain.sdk.entity.KeyPairEntity;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.util.CryptoUtil;
import org.junit.Test;


public class KeyPairTest {

    static {
        Config.init(Server.TEST);
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }

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
