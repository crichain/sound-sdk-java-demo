package com.crichain.sdk.crichain;

import com.alibaba.fastjson.JSONObject;
import com.develop.mnemonic.utils.Numeric;
import com.crichain.sdk.utils.AbiContractUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;


/**
 * 调用合约
 */
@Slf4j
public class Contract {

    /**
     * 销毁
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         参数数组
     * @return JSONObject
     */
    public static JSONObject burn(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("销毁请求返回结果：{}", result);
        return result;
    }

    /**
     * 铸造
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         参数数组
     * @return JSONObject
     */
    public static JSONObject safeMint(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("铸造请求返回结果：{}", result);
        return result;
    }

    /**
     * 铸造
     *
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param address      铸造地址
     * @param tokenId      tokenId
     * @param uri          uri
     * @return result
     */
    public static JSONObject safeMint(String contractAddr, String operateId, String address, String tokenId, String uri) {
        Object[] args = new Object[]{
                new BigInteger(Numeric.cleanHexPrefix(address), 16),
                new BigInteger(tokenId), uri};

        String contractCode = "NFT_A";
        String searchMethod = "safeMint";
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("铸造请求返回结果：{}", result);
        return result;
    }


    /**
     * 获取TokenUri
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject tokenUrl(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "view", args);
        log.info("获取TokenUri请求返回结果：{}", result);
        return result;
    }

    /**
     * 添加白名单
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject addWhiteList(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("添加白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 删除白名单
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject delWhiteList(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("删除白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 转账
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject safeTransfer(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("转账NFT请求返回结果：{}", result);
        return result;
    }

    /**
     * 设置许可
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject setApprovalForAll(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
        log.info("设置许可请求返回结果：{}", result);
        return result;
    }

    /**
     * 获取白名单
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject getWhiteList(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "view", args);
        log.info("获取白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 是否在白名单
     *
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId    操作ID
     * @param contractCode 合约模板代码
     * @param args         形参数组
     * @return JSONObject
     */
    public static JSONObject inWhiteList(String contractAddr, String searchMethod, String operateId, String contractCode, Object... args) {
        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "view", args);
        log.info("是否在白名单请求返回结果：{}", result);
        return result;
    }
}