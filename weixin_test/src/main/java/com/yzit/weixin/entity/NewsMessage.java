package com.yzit.weixin.entity;

import java.util.List;

/**
 * 多图文消息，
 * 单图文的时候 Articles 只放一个就行了
 */
public class NewsMessage extends BaseMessage {

    /**
     * 图文消息个数，限制为10条以内
     */
    private int ArticleCount;
    /**
     * 多条图文消息信息，默认第一个item为大图
     */
    private List<Article> Articles;

    public NewsMessage(){}

    public NewsMessage(int articleCount, List<Article> articles) {
        ArticleCount = articleCount;
        Articles = articles;
    }

    public NewsMessage(String toUserName, String fromUserName, long createTime, String msgType, long msgId, int articleCount, List<Article> articles) {
        super(toUserName, fromUserName, createTime, msgType, msgId);
        ArticleCount = articleCount;
        Articles = articles;
    }

    public int getArticleCount() {
        return ArticleCount;
    }

    public void setArticleCount(int articleCount) {
        ArticleCount = articleCount;
    }

    public List<Article> getArticles() {
        return Articles;
    }

    public void setArticles(List<Article> articles) {
        Articles = articles;
    }
}
