package com.crichain.sdk.config;


import com.crichain.sdk.constant.Server;

public class Config {
//    /**
//     * 私钥
//     */
//    private String privateKey;
    /**
     * url接口请求地址
     */
    private static String url = Server.TEST.url;
//    /**
//     * abi
//     */
//    private  String abi;
//    /**
//     * 合约地址
//     */
//    private  String contractAddr;

//    private Config() {
//
//    }

//    /**
//     * 初始化
//     *
//     * @param privateKey   私钥
//     * @param url          接口请求地址
//     * @param abi          abi合约
//     * @param contractAddr 合约地址
//     */
//    public void init(String privateKey, String url, String abi, String contractAddr) {
//        Config.init(privateKey, url, abi);
//        Config.contractAddr = contractAddr;
//    }

//    /**
//     * 初始化
//     *
//     * @param privateKey 私钥
//     * @param url        接口请求地址
//     * @param abi        abi合约
//     */
//    public void init(String privateKey, String url, String abi) {
//        init(privateKey, url);
//        Config.abi = abi;
//    }

//    /**
//     * 初始化
//     *
//     * @param privateKey 私钥
//     * @param server     服务器配置
//     */
//    public void init(String privateKey, Server server) {
//        init(server);
//        this.privateKey = privateKey;
//    }

    /**
     * 初始化
     *
     * @param server 服务器配置
     */
    public static void init(Server server) {
        Config.url = server.url;
    }

//    public String getPrivateKey() {
//        return privateKey;
//    }

    public static String getUrl() {
        return url;
    }

//    public  String getAbi() {
//        return abi;
//    }

//    public  String getContractAddr() {
//        return contractAddr;
//    }
}
