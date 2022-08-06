package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author admin
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class KeyPairEntity {
    /**
     * 助记词
     */
    private String mnemonicWork;
    /**
     * 私钥
     */
    private String privateKey;
    /**
     * 公钥
     */
    private String publicKey;
    /**
     * 地址
     */
    private String address;
}
