package com.example.demo.web.service;

import com.example.demo.web.dao.ArticleDao;
import com.example.demo.web.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    @Autowired
    private ArticleDao articleDao;

    public Article getById(String id){
        return articleDao.getById(id);
    }

    public void addArticle(Article article){
        articleDao.insertArticle(article);
    }


}
