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
        JSONObject jsonObject = Contract.safeMint("514f2b69fc3102829a25dba16575680f049a0932", "safeMint", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932",16), new BigInteger("123123"), "https://ipfs.infura.io/ipfs/QmbApAkdkGj4jFu6Jr2thcNHraRBYJ7nEL7cvpabM7bLcK");
        System.out.println(jsonObject);
    }

    /**
     * 销毁
     */
    @Test
    public void burn(){
        JSONObject burn = Contract.burn("514f2b69fc3102829a25dba16575680f049a0932", "burn",new BigInteger("123123"));
        System.out.println(burn);
    }

    /**
     * TokenUrl地址
     */
    @Test
    public void tokenUrl() {
        Contract.tokenUrl("514f2b69fc3102829a25dba16575680f049a0932", "tokenURI",new BigInteger("123123"));
    }

    /**
     * 添加白名单
     */
    @Test
    public void addWhiteList(){
        Contract.addWhiteList("514f2b69fc3102829a25dba16575680f049a0932", "addWhiteList",new BigInteger("514f2b69fc3102829a25dba16575680f049a0932",16));
    }

    /**
     * 删除白名单
     */
    @Test
    public void delWhiteList(){
        Contract.delWhiteList("514f2b69fc3102829a25dba16575680f049a0932", "addWhiteList",new BigInteger("514f2b69fc3102829a25dba16575680f049a0932",16));
    }
}
