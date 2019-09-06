package com.example.demo.model;

public enum RestCode {

    OK(200, "OK"),
    SERVER_500(500, "服务异常"),
    SERVER_404(404,"未找到请求地址"),
    SERVER_401(401,"请求异常"),
    ;

    RestCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int code;
    public String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
