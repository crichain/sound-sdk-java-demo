package com.config;

import com.utils.ReadJsonUtil;

public class Config {

    public static String privateKey = "be0883ca6649e4fc242d3ac593d9d97d27a96aa4f17c9f4a294fb73cc15d8ec5";
    public static String url = "http://test.open-api.crichain.cn";
    public static String abi = ReadJsonUtil.getJson("src/main/resources/MyNft.json", "abi");
    public static String contractAddr = "0xce7e273ed4081e6309664734dc7a162e2e20e6cd";

    public static void init(String privateKey,String url,String abi,String contractAddr){
        Config.init(privateKey,url,abi);
        Config.contractAddr = contractAddr;
    }
    public static void init(String privateKey, String url, String abi) {
        init(privateKey, url);
        Config.abi = abi;
    }

    public static void init(String privateKey, String url) {
        init(privateKey);
        Config.url = url;
    }

    public static void init(String privateKey) {
        Config.privateKey = privateKey;
    }
}
