package com.sdzy.xiaomi.report;

import java.io.Serializable;
import java.util.Collection;

public class JsonInfo implements Serializable {
    private Integer statusCode;
    private String msg;
    private Object data;
    private Collection rows;

    public static JsonInfo succ(Object data) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(200), "success", data);
        return jsonInfo;
    }

    public static JsonInfo succ(Collection rows) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(200), "success", rows);
        return jsonInfo;
    }

    public static JsonInfo succ(String msg, Object data) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(200), msg, data);
        return jsonInfo;
    }

    public static JsonInfo succ(String msg, Collection rows) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(200), msg, rows);
        return jsonInfo;
    }

    public static JsonInfo error(String msg, Object data) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(500), msg, data);
        return jsonInfo;
    }

    public static JsonInfo error(String msg, Collection rows) {
        JsonInfo jsonInfo = new JsonInfo(Integer.valueOf(500), msg, rows);
        return jsonInfo;
    }
    
    public JsonInfo(Integer statusCode, String msg, Object data) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.data = data;
    }

    public JsonInfo(Integer statusCode, String msg, Collection rows) {
        this.statusCode = statusCode;
        this.msg = msg;
        this.rows = rows;
    }

    public Collection getRows() {
        return this.rows;
    }

    public void setRows(Collection rows) {
        this.rows = rows;
    }

    public Integer getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data=data;
        
    }
}
