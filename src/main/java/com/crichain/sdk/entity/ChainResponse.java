package com.crichain.sdk.entity;

import lombok.Data;

@Data
public class ChainResponse {

    private Integer code;

    private Boolean success;

    private String message;

    private ChainResponseData data;
}
