package com.gfanx;

import com.alibaba.fastjson.JSONObject;
import com.config.Config;
import com.utils.AbiContractUtil;
import com.utils.HttpClientUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;


/**
 * 调用合约
 */
@Slf4j
public class Contract {

    /**
     * 销毁
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param args 参数数组
     * @return JSONObject
     */
    public static JSONObject burn(String contractAddr,String searchMethod,Object... args) {
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("txData", txCode);
        JSONObject result = HttpClientUtil.doPost(Config.url + "/chain/mint.json", params);
        log.info("销毁请求返回结果：{}",result);
        return result;
    }

    /**
     * 铸造
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param args 参数数组
     * @return JSONObject
     */
    public static JSONObject safeMint(String contractAddr,String searchMethod,Object... args) {
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
        //发送请求
        HashMap<String, Object> params = new HashMap<>();
        params.put("txData", txCode);
        JSONObject result = HttpClientUtil.doPost(Config.url + "/chain/mint.json", params);
        log.info("铸造请求返回结果：{}",result);
        return result;
    }


    /**
     * 获取TokenUri
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param args 形参数组
     */
    public static void tokenUrl(String contractAddr,String searchMethod,Object... args) {
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
    }

    /**
     * 添加白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param args 形参数组
     */
    public static void addWhiteList(String contractAddr,String searchMethod,Object... args) {
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
    }

    /**
     * 删除白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param args 形参数组
     */
    public static void delWhiteList(String contractAddr,String searchMethod,Object... args) {
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
    }

    /**
     * 转账
     * @param contractAddr 合约地址
     * @param searchMethod
     * @param args
     */
    public static void safeTransfer(String contractAddr,String searchMethod,Object... args){
        //获取txCode
        String txCode = AbiContractUtil.txCode(contractAddr, searchMethod, args);
    }

}
