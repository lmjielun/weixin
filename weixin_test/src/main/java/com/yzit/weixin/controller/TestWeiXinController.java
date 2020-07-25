package com.yzit.weixin.controller;

import com.yzit.weixin.entity.AccessToken;
import com.yzit.weixin.uitls.HttpClientUtil;
import com.yzit.weixin.uitls.WeiXinUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWeiXinController {

    @GetMapping("/token")
    public AccessToken getToken(){
        // 直接调用写好的微信工具类
        AccessToken accessToekn = WeiXinUtil.getAccessToekn();
        return accessToekn;
    }

    /**
     *  创建自定义菜单
     */
    @GetMapping("/createMenu")
    public String createMenu(){
        // 创建菜单对象 字符串
        String menuStr = "{" +
                "     \"button\":[" +
                "     {" +
                "          \"type\":\"click\"," +
                "          \"name\":\"点击:关注我们\"," +
                "          \"key\":\"V1001_TODAY_MUSIC\"" +
                "      }," +
                "      {" +
                "           \"name\":\"今日头条\"," +
                "           \"sub_button\":[" +
                "           {" +
                "               \"type\":\"view\"," +
                "               \"name\":\"页面:搜索Baidu\"," +
                "               \"url\":\"http://www.baidu.com/\"" +
                "            }," +
                "            {" +
                "               \"type\":\"click\"," +
                "               \"name\":\"点击：赞一下\"," +
                "               \"key\":\"V1001_GOOD\"" +
                "            }]" +
                "       }]" +
                " }";
        // 调用微信工具类，获取token
        AccessToken token = WeiXinUtil.getAccessToekn();
        // 获取到token发送请求，创建菜单
        String url ="https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token.getAccess_token();
        // 调用httpClient的doPost方法，将menuStr转为json
        String s = HttpClientUtil.doPostJson(url, menuStr);
        // 返回
        return s;

    }

}
