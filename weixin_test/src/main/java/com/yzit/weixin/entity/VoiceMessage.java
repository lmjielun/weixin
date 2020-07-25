package com.yzit.weixin.entity;

/**
 *  微信消息  语音类型
 */
public class VoiceMessage extends BaseMessage{

    private String MediaId;//媒体ID
    private String Format;//语音格式

    public VoiceMessage(){

    }

    public VoiceMessage(String mediaId, String format) {
        MediaId = mediaId;
        Format = format;
    }

    public VoiceMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String mediaId, String format) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        MediaId = mediaId;
        Format = format;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
