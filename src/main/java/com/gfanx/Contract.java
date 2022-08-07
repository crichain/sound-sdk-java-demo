package com.gfanx;

import com.alibaba.fastjson.JSONObject;
import com.utils.AbiContractUtil;
import lombok.extern.slf4j.Slf4j;



/**
 * 调用合约
 */
@Slf4j
public class Contract {

    /**
     * 销毁
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param operateId 操作ID
     * @param args 参数数组
     * @return JSONObject
     */
    public static JSONObject burn(String contractAddr,String searchMethod,String operateId,Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId,"tx",args);
        log.info("销毁请求返回结果：{}",result);
        return result;
    }

    /**
     * 铸造
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 参数数组
     * @return JSONObject
     */
    public static JSONObject safeMint(String contractAddr,String searchMethod,String operateId,Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod,operateId,"tx", args);
        log.info("铸造请求返回结果：{}",result);
        return result;
    }


    /**
     * 获取TokenUri
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject tokenUrl(String contractAddr,String searchMethod,String operateId,Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId,"view",args);
        log.info("获取TokenUri请求返回结果：{}",result);
        return result;
    }

    /**
     * 添加白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject addWhiteList(String contractAddr,String searchMethod,String operateId,Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod,operateId,"tx", args);
        log.info("添加白名单请求返回结果：{}",result);
        return result;
    }

    /**
     * 删除白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject delWhiteList(String contractAddr,String searchMethod,String operateId,Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod,operateId,"tx", args);
        log.info("删除白名单请求返回结果：{}",result);
        return result;
    }

    /**
     * 转账
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject safeTransfer(String contractAddr,String searchMethod,String operateId,Object... args){
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId,"tx",args);
        log.info("转账NFT请求返回结果：{}",result);
        return result;
    }
    /**
     * 设置许可
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject setApprovalForAll(String contractAddr,String searchMethod,String operateId,Object... args){
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod,operateId,"tx", args);
        log.info("设置许可请求返回结果：{}",result);
        return result;
    }

    /**
     * 获取白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject getWhiteList(String contractAddr,String searchMethod,String operateId,Object... args){
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod,operateId,"view", args);
        log.info("获取白名单请求返回结果：{}",result);
        return result;
    }

    /**
     * 是否在白名单
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param args 形参数组
     * @return JSONObject
     */
    public static JSONObject inWhiteList(String contractAddr,String searchMethod,String operateId,Object... args){
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId,"view",args);
        log.info("是否在白名单请求返回结果：{}",result);
        return result;
    }
}
