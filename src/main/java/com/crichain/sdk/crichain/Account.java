package com.crichain.sdk.crichain;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.config.Config;
import com.crichain.sdk.utils.AbiContractUtil;
import com.crichain.sdk.utils.HttpClientUtil;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * 账户
 * @author admin
 */
public class Account {


    /**
     * 获取账户信息
     * @param address 地址
     * @return JSONObject
     */
    public static JSONObject accountInfo(String address) {
        AbiContractUtil.encInstance();
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("address", address);
        JSONObject result = HttpClientUtil.doGet(Config.getUrl() + "/chain/account.json", params);
        System.out.println("账户信息：" + result);
        return result;
    }

    /**
     * 获取Nonce
     * @param address 地址
     * @return int
     */
    public static int getNonce(String address) {
        JSONObject jsonObject = accountInfo(address);
        JSONObject data = jsonObject.getJSONObject("data");
        String nonce = data.getString("nonce");
        BigInteger bigInteger = new BigInteger(nonce);
        return bigInteger.intValue();
    }
}
