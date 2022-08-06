package com.gfanx;

import com.alibaba.fastjson.JSONObject;
import com.config.Config;
import com.utils.AbiContractUtil;
import com.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.HiChain;
import org.brewchain.sdk.model.TransferInfo;
import org.brewchain.sdk.util.CryptoUtil;


import java.math.BigInteger;
import java.util.HashMap;



@Slf4j
public class SafeTransfer {
    /**
     * 转账
     * @param toAddress 对方地址
     * @param amount 金额
     * @param exData exdata
     * @return JSONObjece
     */
    public static JSONObject safeTransfer(String toAddress,String amount,String exData){
        AbiContractUtil.encInstance();
        //根据私钥获取地址
        KeyPairs keyPairs = CryptoUtil.privatekeyToAccountKey(Config.privateKey);
        String address = keyPairs.getAddress();
        //创建实例并生成转账txData
        TransferInfo transferInfo = new TransferInfo(toAddress, amount);
        String transferToTx = HiChain.getTransferToTx(address,Account.getNonce(address), Config.privateKey, exData, transferInfo);
        log.info("转账txData:" + transferToTx);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("txData",transferToTx);
        JSONObject result = HttpClientUtil.doPost(Config.url + "/chain/transferCric.json", params);
        return result;
    }

    /**
     * 交易信息
     * @param hash hash值
     * @return JSONObject
     */
    public static JSONObject transferInfo(String hash) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("hash",hash);
        JSONObject result = HttpClientUtil.doGet(Config.url + "/chain/transaction.json", params);
        log.info("交易信息请求结果为：{}",result);
        return result;
    }

}
