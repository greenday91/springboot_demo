package com.example.demo.web.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.web.dao.ArticleDao;
import com.example.demo.web.entity.Article;
import com.example.demo.web.model.request.ArticelRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private static Logger log = LoggerFactory.getLogger(ArticleService.class);

    @Autowired
    private ArticleDao articleDao;


    public List<Article> findByStartAndEndTime(ArticelRequest articelRequest){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.ge("createdate",articelRequest.getStartDate());
        queryWrapper.le("createdate",articelRequest.getEndDate());
        return this.articleDao.selectObjs(queryWrapper);
    }

    public void addArticle(Article article){
        articleDao.insert(article);
    }


    public Article findById(Article article){
       return articleDao.selectById(article.getId());
    }


}
