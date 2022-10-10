package com.crichain.sdk.crichain;


import com.crichain.sdk.utils.AbiContractUtil;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.sdk.util.CryptoUtil;

import java.math.BigInteger;

/**
 * @author admin
 */
@Slf4j
public class Sign {

    /**
     * 签名
     *
     * @param privateKey 私钥
     * @param text       文本
     */
    public static String sign(String privateKey, String text) {
        AbiContractUtil.encInstance();
        //数据签名
        String signHex = CryptoUtil.signHex(privateKey, new BigInteger(text, 16).toByteArray());
        Log.info(log, "数据签名：{}", signHex);
        return signHex;
    }
}
