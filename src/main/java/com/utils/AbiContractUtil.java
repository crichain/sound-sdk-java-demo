package com.utils;

import com.alibaba.fastjson.JSONObject;
import com.config.Config;
import com.gfanx.Account;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.HiChain;
import org.brewchain.sdk.util.CryptoUtil;

import java.math.BigDecimal;
import java.util.HashMap;

/**
 * @author admin
 */
@Slf4j
public class AbiContractUtil {

    /**
     * 获取data
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param args         参数数组
     * @return String
     */
    public static String getData(String contractAddr, String searchMethod, Object... args) {
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
        //通过私钥获取地址
        KeyPairs keyPairs = CryptoUtil.privatekeyToAccountKey(Config.privateKey);
        String address = keyPairs.getAddress();
        //组装查询bincode
        String functionBinCode = org.brewchain.sdk.util.ContractUtil.getFunctionBinCode(Config.abi, searchMethod, args);
        log.info(searchMethod + "-functionBinCode---" + functionBinCode);
        //执行合约
        String contractCallTx = HiChain.getContractCallTx(address, Account.getNonce(address), Config.privateKey, contractAddr, functionBinCode, "");
        log.info(searchMethod + "-contractCallTx---" + contractCallTx);
        return contractCallTx;
    }

    /**
     * 发送请求
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param args         参数数组
     * @return JSONObject
     */
    public static JSONObject sendData(String contractAddr, String searchMethod,String operateId,String functionType,Object... args ) {
        //获取data
        String data = AbiContractUtil.getData(contractAddr, searchMethod, args);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("method", searchMethod);
        params.put("data", data);
        params.put("functionType",functionType);
        params.put("contractCode", "NFT_A");
        params.put("operateId",operateId);
        return HttpClientUtil.doPost(Config.url + "/chain/callcontract.json", params);
    }

    /**
     * 创建实例
     */
    public static void encInstance() {
        //创建实例
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }

    /**
     * 金额转换
     *
     * @return String
     */
    public static String amountTransition(String amount) {
        BigDecimal bigDecimal = new BigDecimal(amount).multiply(new BigDecimal("1000000000000000000"));
        return bigDecimal.stripTrailingZeros().toPlainString();
    }
}
