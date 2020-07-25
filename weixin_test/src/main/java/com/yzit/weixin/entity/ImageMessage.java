package com.yzit.weixin.entity;

/**
 *  图片消息实体类
 */
public class ImageMessage extends BaseMessage {

    private String PicUrl; // 图片Url
    private String  MediaId;//媒体编号

    public ImageMessage(){

    }

    public ImageMessage(String picUrl, String mediaId) {
        PicUrl = picUrl;
        MediaId = mediaId;
    }

    public ImageMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String picUrl, String mediaId) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        PicUrl = picUrl;
        MediaId = mediaId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
