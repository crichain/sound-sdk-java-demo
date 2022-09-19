package com.crichain.sdk.gfanx;

import com.crichain.sdk.entity.KeyPairEntity;
import com.crichain.sdk.utils.AbiContractUtil;
import lombok.extern.slf4j.Slf4j;
import org.brewchain.mcore.crypto.KeyPairs;
import org.brewchain.sdk.util.WalletUtil;


/**
 * @author admin
 */
@Slf4j
public class KeyPair {

    /**
     * 获取密钥对
     */
    public static KeyPairEntity getKeyPair() {
        AbiContractUtil.encInstance();
        //生成助记词
        String words = WalletUtil.getMnemonic();
        //助记词生成公私钥地址对
        KeyPairs kp = WalletUtil.getKeyPair(words);
        log.info("助记词：{}",words);
        log.info("地址：{}","0x"+kp.getAddress());
        log.info("公钥：{}",kp.getPubkey());
        log.info("私钥：{}",kp.getPrikey());
        return new KeyPairEntity(words,kp.getPrikey(),kp.getPubkey(),"0x"+kp.getAddress());
    }
}
