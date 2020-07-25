package com.yzit.weixin.entity;

/**
 *  微信消息 音乐消息
 */
public class MusicMessage extends BaseMessage {
    private Music Music;//音乐

    public MusicMessage(){

    }

    public MusicMessage(com.yzit.weixin.entity.Music music) {
        Music = music;
    }

    public MusicMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, com.yzit.weixin.entity.Music music) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Music = music;
    }

    public com.yzit.weixin.entity.Music getMusic() {
        return Music;
    }

    public void setMusic(com.yzit.weixin.entity.Music music) {
        Music = music;
    }
}
