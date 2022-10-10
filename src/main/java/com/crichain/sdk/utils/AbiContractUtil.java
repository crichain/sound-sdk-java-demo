package com.crichain.sdk.utils;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.config.Config;
import com.crichain.sdk.crichain.Account;
import com.crichain.sdk.crichain.Log;
import com.crichain.sdk.entity.ContractParam;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.HiChain;
import org.brewchain.sdk.util.CryptoUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

/**
 * @author admin
 */
@Slf4j
public class AbiContractUtil {

    /**
     * 获取data
     *
     * @param callerAddress 调用者地址
     * @param nonce         链上nonce
     * @param priKey        私钥
     * @param param         合约配置
     * @param args          参数数组
     * @return String
     */
    private static String getData(String callerAddress, int nonce, String priKey, ContractParam param, String searchMethod, Object... args) {
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
        //组装查询bincode
        String functionBinCode = org.brewchain.sdk.util.ContractUtil.getFunctionBinCode(param.contractAbi.abi, searchMethod, args);
        Log.info(log,searchMethod + "-functionBinCode---" + functionBinCode);
        //执行合约
        String contractCallTx = HiChain.getContractCallTx(callerAddress, nonce, priKey, param.contractAddr, functionBinCode, "");
        Log.info(log,searchMethod + "-contractCallTx---" + contractCallTx);
        return contractCallTx;
    }

    /**
     * 发送请求
     *
     * @param callerAddress 调用者地址
     * @param nonce         链上nonce
     * @param priKey        私钥
     * @param param         合约配置
     * @param args          参数数组
     * @return JSONObject
     */
    public static JSONObject sendTxData(String callerAddress, int nonce, String priKey, ContractParam param, String searchMethod, String operateId, Object... args) {
        //获取data
        String data = AbiContractUtil.getData(callerAddress, nonce, priKey, param, searchMethod, args);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("method", searchMethod);
        params.put("data", data);
        params.put("functionType", "tx");
        params.put("contractCode", param.contractAbi.name());
        params.put("operateId", operateId);

        return HttpClientUtil.doPost(Config.getUrl() + "/chain/callcontract.json", params);
    }

    /**
     * 发送请求
     *
     * @param callerAddress 调用者地址
     * @param nonce         链上nonce
     * @param priKey        私钥
     * @param param         合约配置
     * @param args          参数数组
     * @return JSONObject
     */
    public static JSONObject sendViewData(String callerAddress, int nonce, String priKey, ContractParam param, String searchMethod, String operateId, Object... args) {
        //获取data
        String data = AbiContractUtil.getData(callerAddress, nonce, priKey, param, searchMethod, args);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("method", searchMethod);
        params.put("data", data);
        params.put("functionType", "view");
        params.put("contractCode", param.contractAbi.name());
        params.put("operateId", operateId);

        params.put("contractAddress", param.contractAddr);
        params.put("params", args);

        return HttpClientUtil.doPost(Config.getUrl() + "/chain/callcontract.json", params);
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

    /**
     * 获取OpreateId
     *
     * @return String
     */
    public static String getOpreateId() {
        //获取当前时间
        String currentTime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
        //随机数
        String random = sevenDigitRandomNumber();
        return currentTime + random;
    }

    /**
     * 七位随机数
     *
     * @return String
     */
    public static String sevenDigitRandomNumber() {
        Random random = new Random();
        String num = random.nextInt(9999999) + "";
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 7 - num.length(); i++) {
            sb.append("0");
        }
        return sb.toString() + num;
    }
}
