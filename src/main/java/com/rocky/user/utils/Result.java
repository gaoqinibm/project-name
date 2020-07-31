package com.rocky.user.utils;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description: TODO
 * @Author Baizhen
 * @Date 2020/7/29 16:40
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -4585770075310807578L;

    /**
     * 响应业务状态
     */
    private String code;

    /**
     * 响应消息
     */
    private String msg;

    /**
     * 响应中的数据
     */
    private Object data;

    public Result() {
    }

    public Result(Object data) {
        this.code = "0";
        this.msg = "success";
        this.data = data;
    }

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}
