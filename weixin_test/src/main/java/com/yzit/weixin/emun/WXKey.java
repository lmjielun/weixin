package com.yzit.weixin.emun;

public class WXKey {
    /**
     *  注册的时候，填写的的token令牌
     */
    public static final String WEIXIN_TOKEN = "liming";

    /**
     *  appId 商家的
     */
    public static final String APPID = "wx6be17c9313891e5d";

    /**
     * 商家秘钥
     */
    public static final String APPSECRET = "97196b167f1c4dc4385797cce365a664";

    /**
     *  获取Access_token的url地址
     */
    public static final String ACCESS_TOKEN_URL =
            "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

}
