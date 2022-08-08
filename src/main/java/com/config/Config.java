package com.config;



public class Config {
    /**
     * 私钥
     */
    private static String privateKey;
    /**
     * url地址
     */
    private static String url;
    /**
     * abi
     */
    private static String abi;
    /**
     * 合约地址
     */
    private static String contractAddr;

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

    public static String getPrivateKey() {
        return privateKey;
    }

    public static String getUrl() {
        return url;
    }

    public static String getAbi() {
        return abi;
    }

    public static String getContractAddr() {
        return contractAddr;
    }
}
