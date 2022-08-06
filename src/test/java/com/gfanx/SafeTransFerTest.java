package com.gfanx;


import com.alibaba.fastjson.JSONObject;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SafeTransFerTest {

    /**
     * 转账
     */
    @Test
    public void safeTransfer(){
        JSONObject result = SafeTransfer.safeTransfer("61d4c124df65ba081992ff2a8c77c67a8b3cb77c", "1000000000000000", "");
        System.out.println(result);
    }
    /**
     * 交易信息
     */
    @Test
    public void transferInfo(){
        JSONObject result = SafeTransfer.transferInfo("0xd06dd4158823ea1514add2ee6779ec75cee16e1dfbbe5003124cbc2edb7076eb");
        System.out.println(result);
    }

    @Test
    public void Test01(){
        BigDecimal multiply = new BigDecimal("0.1").multiply(new BigDecimal("1000000000000000000"));
        String s = multiply.toString();
        System.out.println(s);
        BigInteger bigInteger = new BigInteger(s);
        System.out.println(bigInteger);
    }

}
