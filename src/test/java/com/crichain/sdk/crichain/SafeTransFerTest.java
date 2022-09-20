package com.crichain.sdk.crichain;


import com.alibaba.fastjson.JSONObject;


import org.junit.Test;

public class SafeTransFerTest {

    String priKey = "UserPriKey";

    /**
     * 转账
     */
    @Test
    public void safeTransfer() {
        JSONObject result = SafeTransfer.safeTransfer(priKey, "61d4c124df65ba081992ff2a8c77c67a8b3cb77c", "0.01", "");
        System.out.println(result);
    }

    /**
     * 交易信息
     */
    @Test
    public void transferInfo() {
        JSONObject result = SafeTransfer.transferInfo("0xd06dd4158823ea1514add2ee6779ec75cee16e1dfbbe5003124cbc2edb7076eb");
        System.out.println(result);
    }

}
