package com.sdzy.xiaomi.third.model;

import java.io.Serializable;

public class F4Store implements Serializable {
    private String id;

    private String tjbh;

    private Integer dwlb;

    private String mc;

    private String lxr;

    private String tel;

    private String addr;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTjbh() {
        return tjbh;
    }

    public void setTjbh(String tjbh) {
        this.tjbh = tjbh;
    }

    public Integer getDwlb() {
        return dwlb;
    }

    public void setDwlb(Integer dwlb) {
        this.dwlb = dwlb;
    }

    public String getMc() {
        return mc;
    }

    public void setMc(String mc) {
        this.mc = mc;
    }

    public String getLxr() {
        return lxr;
    }

    public void setLxr(String lxr) {
        this.lxr = lxr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tjbh=").append(tjbh);
        sb.append(", dwlb=").append(dwlb);
        sb.append(", mc=").append(mc);
        sb.append(", lxr=").append(lxr);
        sb.append(", tel=").append(tel);
        sb.append(", addr=").append(addr);
        sb.append("]");
        return sb.toString();
    }
}