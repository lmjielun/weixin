package com.yzit.weixin.entity;

/**
 *  微信消息  链接实体类
 */
public class LinkMessage extends BaseMessage {

    private String Title; // 标题
    private String Description;//消息描述
    private String Url;//消息链接

    public LinkMessage(){

    }

    public LinkMessage(String title, String description, String url) {
        Title = title;
        Description = description;
        Url = url;
    }

    public LinkMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String title, String description, String url) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Title = title;
        Description = description;
        Url = url;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
