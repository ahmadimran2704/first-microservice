package com.example.response;

public class TestResponse {
    public String value;
    public int errorCode;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public TestResponse(String value, int errorCode) {
        this.value = value;
        this.errorCode = errorCode;
    }

    public TestResponse() {
    }
}
