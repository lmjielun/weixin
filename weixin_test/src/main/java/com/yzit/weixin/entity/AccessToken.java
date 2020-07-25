package com.yzit.weixin.entity;

/**
 * 微信通用接口凭证实体类
 * 控制返回结果
 * 操作成功返回：{"access_token":"ACCESS_TOKEN","expires_in":7200}
 * 操作失败返回：{"access_token":"ACCESS_TOKEN","expires_in":7200}
 */
public class AccessToken {
    private String access_token ;//token
    private long expires_in;//有效时间
    private long  errcode;//错误编号
    private String errmsg ;//错误信息

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public long getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(long expires_in) {
        this.expires_in = expires_in;
    }

    public long getErrcode() {
        return errcode;
    }

    public void setErrcode(long errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
