package com.crichain.sdk.crichain;

import com.alibaba.fastjson.JSONObject;
import com.crichain.sdk.constant.ContractAbi;
import com.crichain.sdk.entity.ContractParam;
import com.develop.mnemonic.utils.Numeric;
import com.crichain.sdk.utils.AbiContractUtil;
import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;


/**
 * 调用合约
 */
@Slf4j
public class Contract {

    private final ContractAbi contractAbi;

    public Contract(ContractAbi ca) {
        this.contractAbi = ca;
    }

    /**
     * 销毁
     *
     * @param priKey       持有者私钥
     * @param contractAddr 合约地址
     * @param operateId    操作id
     * @param tokenId      tokenId
     */
    public JSONObject burn(String priKey, String contractAddr, String operateId, String tokenId) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "burn", operateId, new BigInteger(tokenId));
        log.info("销毁请求返回结果：{}", result);
        return result;
    }

    /**
     * 铸造 (自增合约)
     *
     * @param priKey       铸造白名单私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param toAddress    入账地址
     * @param uri          metadata地址
     */
    public JSONObject safeMint(String priKey, String contractAddr, String operateId, String toAddress, String uri) {
        ContractParam param = new ContractParam(contractAddr, ContractAbi.NFT_B);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "safeMint", operateId,
                new BigInteger(Numeric.cleanHexPrefix(toAddress), 16), uri);
        log.info("铸造请求返回结果：{}", result);
        return result;
    }

    /**
     * 铸造 (非自增合约)
     *
     * @param priKey       铸造白名单私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param toAddress    入账地址
     * @param tokenId      tokenId
     * @param uri          metadata地址
     */
    public JSONObject safeMint(String priKey, String contractAddr, String operateId, String toAddress, String tokenId, String uri) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "safeMint", operateId,
                new BigInteger(Numeric.cleanHexPrefix(toAddress), 16), new BigInteger(tokenId), uri);
        log.info("铸造请求返回结果：{}", result);
        return result;
    }

    /**
     * 获取TokenUri
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param tokenId      tokenId
     * @return JSONObject
     */
    public JSONObject tokenUrl(String priKey, String contractAddr, String operateId, String tokenId) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendViewData(priKey, param, "tokenURI", operateId, new BigInteger(tokenId));
        log.info("获取TokenUri请求返回结果：{}", result);
        return result;
    }

    /**
     * 添加白名单
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param whiteAddress 白名单
     * @return JSONObject
     */
    public JSONObject addWhiteList(String priKey, String contractAddr, String operateId, String whiteAddress) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "addWhiteList", operateId, new BigInteger(whiteAddress, 16));
        log.info("添加白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 删除白名单
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param whiteAddress 白名单
     * @return JSONObject
     */
    public JSONObject delWhiteList(String priKey, String contractAddr, String operateId, String whiteAddress) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "delWhiteList", operateId, new BigInteger(whiteAddress, 16));
        log.info("删除白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 转账
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param fromAddress  发送地址
     * @param toAddress    接收地址
     * @param tokenId      tokenId
     * @return JSONObject
     */
    public JSONObject safeTransfer(String priKey, String contractAddr, String operateId, String fromAddress, String toAddress, String tokenId) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "safeTransfer", operateId
                , new BigInteger(Numeric.cleanHexPrefix(fromAddress), 16)
                , new BigInteger(Numeric.cleanHexPrefix(toAddress), 16)
                , new BigInteger(tokenId));
        log.info("转账NFT请求返回结果：{}", result);
        return result;
    }

    /**
     * 设置许可
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param address      地址
     * @param approval     授权或撤销授权
     * @return JSONObject
     */
    public JSONObject setApprovalForAll(String priKey, String contractAddr, String operateId, String address, boolean approval) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendTxData(priKey, param, "setApprovalForAll", operateId,
                new BigInteger(address, 16), approval);
        log.info("设置许可请求返回结果：{}", result);
        return result;
    }

    /**
     * 获取白名单
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param address      查询的地址
     * @return JSONObject
     */
    public JSONObject getWhiteList(String priKey, String contractAddr, String operateId, String address) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendViewData(priKey, param, "getWhiteList", operateId, new BigInteger(address, 16));
        log.info("获取白名单请求返回结果：{}", result);
        return result;
    }

    /**
     * 地址是否在白名单
     *
     * @param priKey       私钥
     * @param contractAddr 合约地址
     * @param operateId    操作Id
     * @param address      查询的地址
     * @return JSONObject
     */
    public JSONObject inWhiteList(String priKey, String contractAddr, String operateId, String address) {
        ContractParam param = new ContractParam(contractAddr, contractAbi);
        JSONObject result = AbiContractUtil.sendViewData(priKey, param, "inWhiteList", operateId, new BigInteger(address, 16));
        log.info("是否在白名单请求返回结果：{}", result);
        return result;
    }
}
