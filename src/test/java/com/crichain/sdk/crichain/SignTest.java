package com.crichain.sdk.crichain;

import com.crichain.sdk.config.Config;
import com.crichain.sdk.constant.Server;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.util.CryptoUtil;
import org.junit.Test;


public class SignTest {

    static {
        Config.init(Server.TEST);
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }

    /**
     * 签名
     */
    @Test
    public void sign() {
        String result = Sign.sign("b046347a995c3131c99fc5cf9e29ee4f7721e9b5ff06397df4eab597d08a9ef1", "123123");
        System.out.println(result);
    }
}
