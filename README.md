##    sound-sdk-java-demo

### 术语说明

| 术语名称 | 说明                                                         |
| -------- | ------------------------------------------------------------ |
| 地址     | 区块链网络中的字符串标识，以'0x'开头                         |
| 钱包     | 每个地址都可以作为钱包地址                                   |
| 账户     | 地址金融维度，链上所有的地址也可以称为账户                   |
| 秘钥对   | 包含（公钥、私钥、地址）                                     |
| 私钥     | 私钥可以通过算法解析出对应的公钥和地址                       |
| 公钥     |                                                              |
| CRIC     | 国广链上的积分                                               |
| 合约     | 发布在链上的合约代码                                         |
| abi      | 类似api，json格式，用来描述合约中的方法名、请求参数、返回参数、方法类型等 |
| 铸造     | 凭空产生一个token或者代币                                    |
| 销毁     | 将一个token转入黑洞地址                                      |
| 黑洞地址 | 一般以一个无人知道私钥的的地址代表黑洞地址，比如0x0000000000000000000000000000000000000000 |
| owner    | 合约地址，合约所有者                                         |
| address  | 地址                                                         |
| from     | 转出地址                                                     |
| to       | 转入地址                                                     |
| index    | 下标                                                         |
| token    | 通证                                                         |
| tokenId  | 通证ID                                                       |
| metadata | 一组json数据                                                 |
| uri      | metadata对应的一个URL地址，http(s)协议，通过get请求可以拿到一组json数据 |
| baseUri  | 每个NFT标准合约设置的http（s）基础地址                       |

#### API说明

##### 初始化配置

```Java
/**
     * 初始化
     * @param privateKey 私钥
     * @param url 地址
     * @param abi abi合约
     * @param contractAddr 合约地址
     */
Config.init("be0883ca6649e4fc242d3ac593d9d97d27a96aa4f17c9f4a294fb73cc15d8ec5","http://test.open-api.crichain.cn","[
    {
      "inputs": [],
      "stateMutability": "nonpayable",
      "type": "constructor"
    },
    {
      "anonymous": false,
      "inputs": [
        {
          "indexed": true,
          "internalType": "address",
          "name": "owner",
          "type": "address"
        }]","0xce7e273ed4081e6309664734dc7a162e2e20e6cd")
```

##### 获取abi

```Java 
/**
     * 获取JSON文件中指定属性值
     *
     * @param path 文件路径
     * @param param 属性值
     * @return String
     */
String abi = ReadJsonUtil.getJson("src/main/resources/MyNft.json", "abi");
```

##### 获取opreateId

```Java
/**
     * 获取OpreateId
     * @return String
     */
String opreateId = AbiContractUtil.getOpreateId();
```

##### 获取密钥对

```Java
		KeyPairEntity keyPair = KeyPair.getKeyPair();
		//助记词
        String mnemonicWork = keyPair.getMnemonicWork();
		//私钥
        String privateKey = keyPair.getPrivateKey();
		//公钥
        String publicKey = keyPair.getPublicKey();
		//地址
        String address = keyPair.getAddress();
```

##### 签名

```Java
/**
     * 签名
     *
     * @param privateKey 私钥
     * @param text       文本
     */
String result = Sign.sign("b046347a995c3131c99fc5cf9e29ee4f7721e9b5ff06397df4eab597d08a9ef1", "123123");
```

##### 获取账户信息

```Java
 /**
     * 获取账户信息
     * @param address 地址
     * @return JSONObject
     */
JSONObject result = Account.accountInfo("514f2b69fc3102829a25dba16575680f049a0932");
```

##### 转账CRIC

```Java
/**
     * 转账
     *
     * @param toAddress 对方地址
     * @param amount    金额
     * @param exData    (拓展参数)
     * @return JSONObject
     */
JSONObject result = SafeTransfer.safeTransfer("61d4c124df65ba081992ff2a8c77c67a8b3cb77c", "0.01", "");
```

#### 调用合约

##### 铸造

```Java
/**
     * 铸造
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param contractCode 合约模板代码
     * @param args （参数数组）address、tokenID、url
     *【Biginteger 16进制】to 
     *【Biginteger】 tokenID 
     *【String】 url
     * @return JSONObject
     */
JSONObject result = Contract.safeMint("514f2b69fc3102829a25dba16575680f049a0932", "safeMint", "123132","NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932",16), new BigInteger("123123"), "https://ipfs.infura.io/ipfs/QmbApAkdkGj4jFu6Jr2thcNHraRBYJ7nEL7cvpabM7bLcK");
```

##### 销毁

```Java
/**
     * 铸造
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID 
     * @param contractCode 合约模板代码
     * @param args (参数数组) tokenID
     *【BigInteger】tokenID 
     * @return JSONObject
     */
JSONObject result = Contract.burn("514f2b69fc3102829a25dba16575680f049a0932", "burn","123132","NFT_A",new BigInteger("123123"));
```

##### 转账

```Java
/**
     * 转账
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID 
     * @param contractCode 合约模板代码
     * @param args （形参数组）from、to、tokenID
     *【Biginteger 16进制】from
     *【Biginteger 16进制】to
     *【Biginteger】tokenID
     * @return JSONObject
     */
JSONObject result = Contract.safeTransfer("0xce7e273ed4081e6309664734dc7a162e2e20e6cd", "safeTransfer","123132","NFT_A", new BigInteger("514f2b69fc3102829a25dba16575680f049a0932", 16), new BigInteger("61d4c124df65ba081992ff2a8c77c67a8b3cb77c", 16), new BigInteger("123123"));
```

##### TokenUrl地址

```Java
/**
     * 铸造
     * @param contractAddr 合约地址
     * @param searchMethod 方法
     * @param operateId 操作ID
     * @param contractCode 合约模板代码
     * @param args (参数数组) tokenID 
     *【BigInteger】 tokenID
     * @return JSONObject
     */
JSONObject result = Contract.tokenUrl("514f2b69fc3102829a25dba16575680f049a0932", "tokenURI","123132","NFT_A",new BigInteger("123123"));
```