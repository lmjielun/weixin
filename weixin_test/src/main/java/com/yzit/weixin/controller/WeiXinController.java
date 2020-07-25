package com.yzit.weixin.controller;
import com.yzit.weixin.entity.Article;
import com.yzit.weixin.entity.ImageMessage;
import com.yzit.weixin.entity.NewsMessage;
import com.yzit.weixin.entity.TextMessage;
import com.yzit.weixin.uitls.CheckUtil;
import com.yzit.weixin.uitls.MessageUtil;
import org.dom4j.DocumentException;
import org.springframework.core.codec.EncodingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  微信校验接口
 *  实现 微信 对 该接口的校验
 */
@RestController
public class WeiXinController {

    @GetMapping("/weixin")
    public void checkURL(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("***************微信校验******************");

        /**
         *  接收微信 传递 过来的 4个参数
         *  signature 微信加密签名 结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         *  timestamp 时间戳
         *  nonce 随机数
         *  echostr 随机字符串
         */
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        // 获取response输出流
        PrintWriter out = response.getWriter();
        // 校验加密签名是否正确
        if(CheckUtil.checkSignature(signature,timestamp,nonce)){
            //如果校验成功，将得到的随机字符串原路返回
            out.print(echostr);
        }
    }

    @PostMapping("/weixin")
    public void Message(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置字符编码。避免乱码
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/xml;charset=utf-8");
        PrintWriter out = response.getWriter();
        try {
            Map<String, String> map = MessageUtil.xmlToMap(request);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");

            String message = null;
            // 判断消息类型是 是否为event 事件类型
            if("event".equals(msgType)){
                // 获取事件内容
                // 这个Event是标签名称<Event><![CDATA[CLICK]]></Event>
                String event = map.get("Event");
                // 这个event是String event 事件内容
                if("subscribe".equals(event)){ // 如果是subscribe 就是订阅
                    // 返回普通文本消息
                    content = "感谢订阅";
                    TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                    message = MessageUtil.textMessageToXML(text);
                }
                if("unsubscribe".equals(event)){// 如是unsubscribe 就是取消订阅
                    // 返回普通文本消息
                    content = "您已取消订阅.02";
                    TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                    message = MessageUtil.textMessageToXML(text);
                }

                if("CLICK".equals(event)){//点击事件
                    String  EventKey  = map.get("EventKey");
                    // 通过click中的key值，来判断，返回消息内容，也就是菜单是哪一个
                    if("V1001_TODAY_MUSIC".equals(EventKey)){
                        content = "你点击了：【点击:关注我们】";
                        TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                        message = MessageUtil.textMessageToXML(text);
                    }
                    // 通过click中的key值，来判断，返回消息内容，也就是菜单是哪一个
                    if("V1001_GOOD".equals(EventKey)){
                        content = "谢谢，我们继续努力！！！";
                        TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                        message = MessageUtil.textMessageToXML(text);
                    }
                }


            }
            if ("text".equals(msgType)) {                // 对文本消息进行处理
                if("图文".equals(content)){
                    // 创建一个多图文对象
                    NewsMessage newsMessage = new NewsMessage();
                    // 设置多图文对象的 属性
                    newsMessage.setToUserName(fromUserName);
                    newsMessage.setFromUserName(toUserName);
                    newsMessage.setCreateTime(new Date().getTime());
                    newsMessage.setMsgType("news"); // 消息类型

                    // 文章list集合
                    List<Article> articleList = new ArrayList<>();

                    // 创建单独图文（一个图文对象）
                    Article article = new Article();
                    // 设置图文对象标题
                    article.setTitle("微信测试图文");
                    // 设置图文对象简介
                    article.setDescription("仅仅是一个测试");
                    // 设置图文对象的图片地址
                    article.setPicUrl("https://www.iteye.com/upload/logo/user/603624/2dc5ec35-073c-35e7-9b88-274d6b39d560.jpg");
                    // 设置图文对象的url地址
                    article.setUrl("http://youzhongit.com/");

                    // 将文章一个对象 存储到文章list集合中
                    articleList.add(article);


                    // 在创建单独图文（一个图文对象），套路同上
                    Article article1 = new Article();
                    // 设置图文对象标题
                    article1.setTitle("微信测试图文2");
                    // 设置图文对象简介
                    article1.setDescription("仅仅是一个测试2");
                    // 设置图文对象的图片地址
                    article1.setPicUrl("https://www.iteye.com/upload/logo/user/603624/2dc5ec35-073c-35e7-9b88-274d6b39d560.jpg");
                    // 设置图文对象的url地址
                    article1.setUrl("http://youzhongit.com/");

                    // 将文章一个对象 存储到文章list集合中
                    articleList.add(article1);


                    // 设置多图文对象的 图文消息个数
                    newsMessage.setArticleCount(articleList.size());
                    // 设置多图文消息的集合 包含的图文集合
                    newsMessage.setArticles(articleList);
                    // 将图文消息对象转换成xml字符串
                    message = MessageUtil.newsMessageToXml(newsMessage);
                }else {
                    TextMessage text = new TextMessage();
                    text.setFromUserName(toUserName);         // 发送和回复是反向的
                    text.setToUserName(fromUserName);
                    text.setMsgType("text");
                    text.setCreateTime(new Date().getTime());
                    text.setContent("你发送的消息是：" + content);
                    message = MessageUtil.textMessageToXML(text);
                    System.out.println(message);
                }
            }
            if("image".equals(msgType)){
                System.out.println("PicUrl  = "+map.get("PicUrl"));
                System.out.println("MediaId  = "+map.get("MediaId"));

                ImageMessage text = new ImageMessage();
                text.setFromUserName(toUserName); // 发送和回复是反向的
                text.setToUserName(fromUserName);
                text.setMsgType("image");
                text.setCreateTime(new Date().getTime());

                //text.setPicUrl("http://rwx43e.natappfree.cc/108.png");
                text.setPicUrl(map.get("PicUrl"));
                text.setMediaId(map.get("MediaId"));

                message = MessageUtil.imagesMessageToXML(text);
                System.out.println("响应的内容："+message);
            }
            if("link".equals(msgType)){
                TextMessage text = new TextMessage();
                text.setFromUserName(toUserName);         // 发送和回复是反向的
                text.setToUserName(fromUserName);
                text.setMsgType("text");
                text.setCreateTime(new Date().getTime());
                // 从map中拼接 返回信息
                String msg = "链接标题 ： "+map.get("Title")+"，链接详情："+map.get("Description")+"，链接地址"+map.get("Url");
                text.setContent("你发送的链接地址是：" + msg);
                message = MessageUtil.textMessageToXML(text);
                //System.out.println(message);
            }
            if("voice".equals(msgType)){
                // 从map中获取语音消息
                content = "Format:"+map.get("Format")+";MediaId="+map.get("MediaId");
                // 类里有构造器就用构造器，不适用Get  set了
                // 注意：这里的fromUserName 是用户，toUserName 是我们
                TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                message = MessageUtil.textMessageToXML(text);
            }
            if("location".equals(msgType)){
                // 从map中获取位置信息 获取x坐标 y坐标，然后获取label显示
                content = "位置消息：Location_X:"+map.get("Location_X")+";Location_Y="+map.get("Location_Y")+";Label="+map.get("Label");
                // 类里有构造器就用构造器，不适用Get  set了
                // 注意：这里的fromUserName 是用户，toUserName 是我们
                TextMessage text = new TextMessage(fromUserName,toUserName,System.currentTimeMillis(),"text",0,content);
                message = MessageUtil.textMessageToXML(text);
            }

            out.print(message);                            // 将回应发送给微信服务器

        } catch (DocumentException e) {
            e.printStackTrace();
        }finally{
            out.close();
        }

    }


}
