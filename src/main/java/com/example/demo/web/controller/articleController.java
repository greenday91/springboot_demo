package com.example.demo.web.controller;

import com.example.demo.web.entity.Article;
import com.example.demo.web.service.ArticleService;
import com.example.demo.web.uitl.RedisUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
public class articleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/getById/{id}")
    public Object getArticleById(@PathVariable("id") String id){
        if(redisUtil.hasKey(id)){
            return redisUtil.get(id);
        }
        Article articler = articleService.getById(id);
        if(null == articler){
            redisUtil.set(id,articler);
        }else{
            redisUtil.set(id,articler);
        }
        return articler;
    }

    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public Object getArticleById(@RequestBody Article article){
        article.setId(UUID.randomUUID().toString());
        article.setCreateDate(new Date());
        article.setUpdateTime(new Date());
        articleService.addArticle(article);
        return "ok";
    }



}
