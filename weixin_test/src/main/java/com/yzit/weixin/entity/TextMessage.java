package com.yzit.weixin.entity;
/**
 * 信息实体类，与xml格式保持，标签名称保持一致
 * <xml>
 <ToUserName><![CDATA[toUser]]></ToUserName>
 <FromUserName><![CDATA[fromUser]]></FromUserName>
 <CreateTime>1348831860</CreateTime>
 <MsgType><![CDATA[text]]></MsgType>
 <Content><![CDATA[this is a test]]></Content>
 <MsgId>1234567890123456</MsgId>
 </xml>
 */
public class TextMessage extends BaseMessage{

    private String Content;

    // 无参构造
    public TextMessage() {

    }
    // 一个参数的构造
    public TextMessage(String content) {
        Content = content;
    }
    // 继承父类的全参构造
    public TextMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String content) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Content = content;
    }

    // get - set
    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
