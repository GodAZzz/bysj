package com.zdc.tcms.biz.service.impl;

import com.zdc.tcms.biz.entity.Article;
import com.zdc.tcms.biz.mapper.ArticleMapper;
import com.zdc.tcms.biz.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<Article> getFiveArtice() {
        List<Article> fiveArticle = articleMapper.getFiveArticle();
        return fiveArticle;
    }

    @Override
    public Article getByTopic(String topic) {
        Article byTopic = articleMapper.getByTopic(topic);
        return byTopic;
    }
}
