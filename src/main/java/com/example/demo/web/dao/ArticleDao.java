package com.example.demo.web.dao;

import com.example.demo.web.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao {

    Article getById(String id);

    void insertArticle(Article article);

}
