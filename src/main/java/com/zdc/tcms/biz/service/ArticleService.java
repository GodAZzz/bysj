package com.zdc.tcms.biz.service;

import com.zdc.tcms.biz.entity.Article;

import java.util.List;

/**
 * 体质养生文章
 */
public interface ArticleService {

    /**
     * 根据topic查找5个文章
     */
    List<Article> getFiveArtice();

    /**
     * 根据topic查询文章
     */
    Article getByTopic(String topic);
}
