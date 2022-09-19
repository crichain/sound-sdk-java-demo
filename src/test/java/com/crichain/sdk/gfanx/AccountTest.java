package com.crichain.sdk.gfanx;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;



public class AccountTest {

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
