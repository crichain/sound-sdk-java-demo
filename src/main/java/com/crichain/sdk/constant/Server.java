package com.crichain.sdk.constant;

public enum Server {

    TEST(Constants.OPEN_API_TEST),

    PROD(Constants.OPEN_API_PROD),
    ;
    public String url;

    Server(String url) {
        this.url = url;
    }
}
