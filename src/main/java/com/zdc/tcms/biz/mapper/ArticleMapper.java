package com.zdc.tcms.biz.mapper;

import com.zdc.tcms.biz.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {

    /**
     * 随机查找五篇文章
     */
    List<Article> getFiveArticle();

    /**
     * 根据topic查找文章
     */
    Article getByTopic(@Param("topic") String topic);
}
