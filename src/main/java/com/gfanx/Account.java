package com.gfanx;

import com.alibaba.fastjson.JSONObject;
import com.config.Config;
import com.utils.AbiContractUtil;
import com.utils.HttpClientUtil;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.util.CryptoUtil;

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
     * @return
     */
    public static JSONObject accountInfo(String address) {
        AbiContractUtil.encInstance();
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("address", address);
        JSONObject result = HttpClientUtil.doGet(Config.url + "/chain/account.json", params);
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
