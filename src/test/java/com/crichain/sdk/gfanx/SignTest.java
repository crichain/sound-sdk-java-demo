package com.crichain.sdk.gfanx;

import org.junit.Test;


public class SignTest {

    /**
     * 签名
     */
    @Test
    public void sign(){
        String result = Sign.sign("b046347a995c3131c99fc5cf9e29ee4f7721e9b5ff06397df4eab597d08a9ef1", "123123");
        System.out.println(result);
    }
}
