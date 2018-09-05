package com.apm29.yjw.redis_demo.domain;

import org.springframework.web.method.HandlerMethod;

import java.util.Arrays;

public class BaseResp<T> {
    private static final String DEFAULT_MSG = "成功";
    private int code;
    private String msg;
    private T data;

    public  static <T> BaseResp<T> ok(String msg, T data){
        return new BaseResp<>(200,msg ,data);
    }
    public  static <T> BaseResp<T> ok(T data){
        return ok(DEFAULT_MSG,data);
    }
    public  static <T> BaseResp<T> err(String msg,T data){
        return  new BaseResp<>(400,msg,data);
    }
    static class Err{
        private  String errMessage;
        private  String from;

        public String getErrMessage() {
            return errMessage;
        }

        public void setErrMessage(String errMessage) {
            this.errMessage = errMessage;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTraceStack() {
            return traceStack;
        }

        public void setTraceStack(String traceStack) {
            this.traceStack = traceStack;
        }

        private  String traceStack;

        @Override
        public String toString() {
            return "Err{" +
                    "errMessage='" + errMessage + '\'' +
                    ", from='" + from + '\'' +
                    ", traceStack='" + traceStack + '\'' +
                    '}';
        }
    }
    public  static  BaseResp<Err> internalErr(Exception ex, HandlerMethod method){
        Err data = new Err();
        data.errMessage = ex.getMessage();
        data.from = method.toString();
        data.traceStack = Arrays.toString(ex.getStackTrace());
        return new BaseResp<>(500, "服务器内部错误", data);
    }

    public BaseResp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResp{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
