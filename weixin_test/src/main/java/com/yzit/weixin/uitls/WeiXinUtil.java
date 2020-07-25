package com.yzit.weixin.uitls;

import com.yzit.weixin.entity.AccessToken;
import sun.net.www.http.HttpClient;

public class WeiXinUtil {

    // 商家的appId
    private static  String  APPID    ="wx6be17c9313891e5d";
    // 商家的秘钥
    private static  String APPSECRET = "97196b167f1c4dc4385797cce365a664";

    public static synchronized AccessToken getAccessToekn(){
        // 先定义该对象为null
        AccessToken accessToken = null;

        // 调用服务接口，获取token
        String  url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
        // 使用httpClient工具类，调用doPost，传递Url获取accessToken对象
        String result = HttpClientUtil.doPost(url);
        // 将result转为java对象
        accessToken = FastJsonUtil.toBean(result, AccessToken.class);
        // 返回结果
        return  accessToken;

    }

}
