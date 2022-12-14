package com.crichain.sdk.crichain;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.config.Config;
import com.crichain.sdk.utils.AbiContractUtil;
import com.crichain.sdk.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.sdk.HiChain;
import org.brewchain.sdk.model.TransferInfo;
import org.brewchain.sdk.util.CryptoUtil;


import java.util.HashMap;


@Slf4j
public class SafeTransfer {
    /**
     * 转账
     *
     * @param toAddress 对方地址
     * @param amount    金额
     * @param exData    拓展参数
     * @return JSONObject
     */
    public static JSONObject safeTransfer(String priKey, String toAddress, String amount, String exData) {
//        AbiContractUtil.encInstance();
        //金额转换
        amount = AbiContractUtil.amountTransition(amount);
        //根据私钥获取地址
        KeyPairs keyPairs = CryptoUtil.privatekeyToAccountKey(priKey);
        String address = keyPairs.getAddress();
        //创建实例并生成转账txData
        TransferInfo transferInfo = new TransferInfo(toAddress, amount);
        String transferToTx = HiChain.getTransferToTx(address, Account.getNonce(address), priKey, exData, transferInfo);
        Log.info(log, "转账txData:" + transferToTx);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("txData", transferToTx);
        JSONObject result = HttpClientUtil.doPost(Config.getUrl() + "/chain/transferCric.json", params);
        return result;
    }

    /**
     * 转账
     *
     * @param toAddress 对方地址
     * @param amount    金额
     * @param exData    拓展参数
     * @return JSONObject
     */
    public static JSONObject safeTransfer(String callerAddress, int nonce, String priKey, String toAddress, String amount, String exData) {
//        AbiContractUtil.encInstance();
        //金额转换
        amount = AbiContractUtil.amountTransition(amount);
        //创建实例并生成转账txData
        TransferInfo transferInfo = new TransferInfo(toAddress, amount);
        String transferToTx = HiChain.getTransferToTx(callerAddress, nonce, priKey, exData, transferInfo);
        Log.info(log, "转账txData:" + transferToTx);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("txData", transferToTx);
        JSONObject result = HttpClientUtil.doPost(Config.getUrl() + "/chain/transferCric.json", params);
        return result;
    }

    /**
     * 交易信息
     *
     * @param hash hash值
     * @return JSONObject
     */
    public static JSONObject transferInfo(String hash) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("hash", hash);
        JSONObject result = HttpClientUtil.doGet(Config.getUrl() + "/chain/transaction.json", params);
        Log.info(log, "交易信息请求结果为：{}", result);
        return result;
    }

}
