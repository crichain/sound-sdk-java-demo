package com.crichain.sdk.crichain;


import com.alibaba.fastjson.JSONObject;

import com.crichain.sdk.config.Config;
import com.crichain.sdk.constant.ContractAbi;
import com.crichain.sdk.constant.Server;
import com.develop.mnemonic.utils.Numeric;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.util.CryptoUtil;
import org.junit.Test;

import java.math.BigInteger;


public class ContractTest {

    Contract contract = new Contract(ContractAbi.NFT_A);

    String priKey = "UserPriKey";

    static {
        Config.init(Server.TEST);
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }

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
        JSONObject result = contract.tokenUrl("0x139922924c83b4262bea490cb90279701b733bd8", "1001111680");
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

//    /**
//     * 获取白名单
//     */
//    @Test
//    public void getWhiteList() {
//        JSONObject result = contract.getWhiteList("0xd857520f2f7e6b933b23a9eba47831b687813361", "0");
//        System.out.println(result);
//    }

    /**
     * 是否在白名单
     */
    @Test
    public void inWhiteList() {
        JSONObject result = contract.inWhiteList("0xd857520f2f7e6b933b23a9eba47831b687813361", "0x95aba0fdff121a98dd8007c96d3324f64b8db467");
        System.out.println(result);
    }

}
