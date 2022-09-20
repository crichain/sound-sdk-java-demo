package com.crichain.sdk.entity;

import com.crichain.sdk.constant.ContractAbi;

public class ContractParam {

    public String contractAddr;
    public ContractAbi contractAbi;

    public ContractParam(String contractAddr, ContractAbi contractAbi) {
        this.contractAddr = contractAddr;
        this.contractAbi = contractAbi;
    }

}
