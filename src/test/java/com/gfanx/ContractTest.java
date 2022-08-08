package com.gfanx;


import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.math.BigInteger;


public class ContractTest {

    /**
     * 铸造
     */
    @Test
    public void safeMint() {
        JSONObject result = Contract.safeMint("514f2b69fc3102829a25dba16575680f049a0932", "safeMint", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16), new BigInteger("123123"), "https://ipfs.infura.io/ipfs/QmbApAkdkGj4jFu6Jr2thcNHraRBYJ7nEL7cvpabM7bLcK");
        System.out.println(result);
    }

    /**
     * 销毁
     */
    @Test
    public void burn() {
        JSONObject result = Contract.burn("514f2b69fc3102829a25dba16575680f049a0932", "burn", "123123", "NFT_A", new BigInteger("123123"));
        System.out.println(result);
    }

    /**
     * TokenUrl地址
     */
    @Test
    public void tokenUrl() {
        JSONObject result = Contract.tokenUrl("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "tokenURI", "123123", "NFT_A", new BigInteger("123123"));
        System.out.println(result);
    }

    /**
     * 添加白名单
     */
    @Test
    public void addWhiteList() {
        JSONObject result = Contract.addWhiteList("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "addWhiteList", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16));
        System.out.println(result);
    }

    /**
     * 删除白名单
     */
    @Test
    public void delWhiteList() {
        JSONObject result = Contract.delWhiteList("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "delWhiteList", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16));
        System.out.println(result);
    }

    /**
     * 转账
     */
    @Test
    public void safeTransfer() {
        JSONObject result = Contract.safeTransfer("06e81b2bc890f56d496e9938f1a8769518496d24", "safeTransfer", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16), new BigInteger("06e81b2bc890f56d496e9938f1a8769518496d24", 16), new BigInteger("123123"));
        System.out.println(result);
    }

    /**
     * 设置许可
     */
    @Test
    public void setApprovalForAll() {
        JSONObject result = Contract.setApprovalForAll("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "setApprovalForAll", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16), true);
        System.out.println(result);
    }

    /**
     * 获取白名单
     */
    @Test
    public void getWhiteList() {
        JSONObject result = Contract.getWhiteList("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "getWhiteList", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16));
        System.out.println(result);
    }

    /**
     * 是否在白名单
     */
    @Test
    public void inWhiteList() {
        JSONObject result = Contract.inWhiteList("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "inWhiteList", "123123", "NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16));
        System.out.println(result);
    }

}
