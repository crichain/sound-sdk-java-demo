package com.crichain.sdk.open;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.utils.AbiContractUtil;
import com.develop.mnemonic.utils.Numeric;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class Crichain {

//    /**
//     * 铸造
//     *
//     * @param contractAddr 合约地址
//     * @param operateId    操作Id
//     * @param toAddress      铸造地址
//     * @param tokenId      tokenId
//     * @param uri          uri
//     * @return result
//     */
//    public static JSONObject safeMint(String contractAddr, String operateId, String toAddress, String tokenId, String uri) {
//        Object[] args = new Object[]{
//                new BigInteger(Numeric.cleanHexPrefix(toAddress), 16),
//                new BigInteger(tokenId), uri};
//
//        String contractCode = "NFT_A";
//        String searchMethod = "safeMint";
//        JSONObject result = AbiContractUtil.sendData(contractAddr, searchMethod, operateId, contractCode, "tx", args);
//        log.info("铸造请求返回结果：{}", result);
//        return result;
//    }


}
