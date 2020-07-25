package com.yzit.weixin.entity;
import java.io.Serializable;

/**
 *  微信消息基类
 *  封装各类消息的共同属性
 */
public class BaseMessage implements Serializable{
    private String ToUserName;//开发者微信号
    private String FromUserName; // 发送方帐号（一个OpenID）
    private long CreateTime;//消息创建时间 （整型）
    private String MsgType;//消息类型 text、image、location、link
    private long MsgId;//消息id，64位整型

    public BaseMessage() {
    }

    public BaseMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId) {

        ToUserName = toUserName;
        FromUserName = fromUserName;
        CreateTime = createTime;
        MsgType = msgType;
        MsgId = msgId;
    }

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
