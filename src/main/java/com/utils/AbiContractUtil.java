package com.utils;

import com.config.Config;
import com.gfanx.Account;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.mcore.crypto.impl.EncInstance;
import org.brewchain.sdk.HiChain;
import org.brewchain.sdk.util.CryptoUtil;

/**
 * @author admin
 */
@Slf4j
public class AbiContractUtil {

    /**
     * 获取txCode
     * @param contractAddr 合约地址
     * @param searchMethod 方法名
     * @param args 参数数组
     * @return
     */
    public static String txCode(String contractAddr,String searchMethod,Object... args){
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
        //通过私钥获取地址
        KeyPairs keyPairs = CryptoUtil.privatekeyToAccountKey(Config.privateKey);
        String address = keyPairs.getAddress();
        //组装查询bincode
        String functionBinCode = org.brewchain.sdk.util.ContractUtil.getFunctionBinCode(Config.abi, searchMethod,args);
        log.info(searchMethod+"-functionBinCode---" + functionBinCode);
        //执行合约
        String contractCallTx = HiChain.getContractCallTx(address, Account.getNonce(address), Config.privateKey, contractAddr, functionBinCode, "");
        log.info(searchMethod+"-contractCallTx---" + contractCallTx);
        return contractCallTx;
    }

    /**
     * 创建实例
     */
    public static void encInstance(){
        //创建实例
        EncInstance encInstance = new EncInstance();
        encInstance.startup();
        CryptoUtil.crypto = encInstance;
    }
}
