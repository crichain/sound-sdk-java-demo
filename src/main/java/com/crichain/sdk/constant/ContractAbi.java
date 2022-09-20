package com.crichain.sdk.constant;

public enum ContractAbi {

    NFT_A(Abi.NFT_A),

    NFT_B(Abi.NFT_B),
    ;
    public String abi;

    ContractAbi(String abi) {
        this.abi = abi;
    }

}
