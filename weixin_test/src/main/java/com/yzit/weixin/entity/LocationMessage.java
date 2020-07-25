package com.yzit.weixin.entity;
/**
 * 微信消息  地理位置
 * @author Administrator
 */
public class LocationMessage extends BaseMessage{

    private String Location_X;//地理位置维度
    private String Location_Y;//地理位置经度
    private String Scale;//地图缩放大小
    private String Label;//地理位置信息


    public LocationMessage(){}

    public LocationMessage(String location_X, String location_Y, String scale, String label) {
        Location_X = location_X;
        Location_Y = location_Y;
        Scale = scale;
        Label = label;
    }

    public LocationMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, String location_X, String location_Y, String scale, String label) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        Location_X = location_X;
        Location_Y = location_Y;
        Scale = scale;
        Label = label;
    }

    public String getLocation_X() {
        return Location_X;
    }

    public void setLocation_X(String location_X) {
        Location_X = location_X;
    }

    public String getLocation_Y() {
        return Location_Y;
    }

    public void setLocation_Y(String location_Y) {
        Location_Y = location_Y;
    }

    public String getScale() {
        return Scale;
    }

    public void setScale(String scale) {
        Scale = scale;
    }

    public String getLabel() {
        return Label;
    }

    public void setLabel(String label) {
        Label = label;
    }
}
