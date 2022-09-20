package com.crichain.sdk.crichain;


import com.alibaba.fastjson.JSONObject;

import com.crichain.sdk.constant.ContractAbi;
import com.develop.mnemonic.utils.Numeric;
import org.junit.Test;

import java.math.BigInteger;


public class ContractTest {

    Contract contract = new Contract(ContractAbi.NFT_A);

    String priKey = "UserPriKey";

    /**
     * 铸造
     */
    @Test
    public void safeMint() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.safeMint(priKey, "0x514f2b69fc3102829a25dba16575680f049a0932", operateId, "0x514f2b69fc3102829a25dba16575680f049a0932", "6000012", "https://ipfs.infura.io/ipfs/QmbApAkdkGj4jFu6Jr2thcNHraRBYJ7nEL7cvpabM7bLcK");
        System.out.println(result);
    }

    /**
     * 销毁
     */
    @Test
    public void burn() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.burn(priKey, "0x514f2b69fc3102829a25dba16575680f049a0932", operateId, "6000012");
        System.out.println(result);
    }

    /**
     * TokenUrl地址
     */
    @Test
    public void tokenUrl() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.tokenUrl(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "6000012");
        System.out.println(result);
    }

    /**
     * 添加白名单
     */
    @Test
    public void addWhiteList() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.addWhiteList(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(result);
    }

    /**
     * 删除白名单
     */
    @Test
    public void delWhiteList() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.delWhiteList(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(result);
    }

    /**
     * 转账
     */
    @Test
    public void safeTransfer() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.safeTransfer(priKey, "0x06e81b2bc890f56d496e9938f1a8769518496d24", operateId, "514f2b69fc3102829a25dba16575680f049a0932", "06e81b2bc890f56d496e9938f1a8769518496d24", "6000012");
        System.out.println(result);
    }

    /**
     * 设置许可
     */
    @Test
    public void setApprovalForAll() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.setApprovalForAll(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "514f2b69fc3102829a25dba16575680f049a0932", true);
        System.out.println(result);
    }

    /**
     * 获取白名单
     */
    @Test
    public void getWhiteList() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.getWhiteList(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(result);
    }

    /**
     * 是否在白名单
     */
    @Test
    public void inWhiteList() {
        String operateId = "" + System.currentTimeMillis();
        JSONObject result = contract.inWhiteList(priKey, "0xce7e273ed4081e6309664734dc7a162e2e20e6cd", operateId, "514f2b69fc3102829a25dba16575680f049a0932");
        System.out.println(result);
    }

}
