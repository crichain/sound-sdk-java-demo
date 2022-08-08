package com.config;

import com.utils.ReadJsonUtil;

public class Config {
    /**
     * 私钥
     */
    public static String privateKey;
    /**
     * url地址
     */
    public static String url;
    /**
     * abi
     */
    public static String abi;
    /**
     * 合约地址
     */
    public static String contractAddr;

    private Config(){

    }
    /**
     * 初始化
     * @param privateKey 私钥
     * @param url 地址
     * @param abi abi合约
     * @param contractAddr 合约地址
     */
    public static void init(String privateKey,String url,String abi,String contractAddr){
        Config.init(privateKey,url,abi);
        Config.contractAddr = contractAddr;
    }

    /**
     * 初始化
     * @param privateKey 私钥
     * @param url 地址
     * @param abi abi合约
     */
    public static void init(String privateKey, String url, String abi) {
        init(privateKey, url);
        Config.abi = abi;
    }

    /**
     * 初始化
     * @param privateKey 私钥
     * @param url 地址
     */
    public static void init(String privateKey, String url) {
        init(privateKey);
        Config.url = url;
    }

    /**
     * 初始化
     * @param privateKey 私钥
     */
    public static void init(String privateKey) {
        Config.privateKey = privateKey;
    }
}
