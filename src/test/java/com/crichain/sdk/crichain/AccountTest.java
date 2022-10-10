package com.crichain.sdk.crichain;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.config.Config;
import com.crichain.sdk.constant.Server;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.util.CryptoUtil;
import org.junit.Test;


public class AccountTest {

    static {
        Config.init(Server.TEST);
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }

    /**
     * 获取账户信息
     */
    @Test
    public void accountInfo() {
        JSONObject result = Account.accountInfo("514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(result);
    }

    /**
     * 获取用户nonce
     */
    @Test
    public void getNonce() {
        int nonce = Account.getNonce("514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(nonce);
    }
}
