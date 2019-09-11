package com.example.demo.web.controller;


import com.example.demo.annotation.SecurityParameter;
import com.example.demo.annotation.VerificationUserToken;
import com.example.demo.web.entity.Article;
import com.example.demo.web.model.request.ArticelRequest;
import com.example.demo.web.service.ArticleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/article")
@Api
public class articleController {

    @Autowired
    private ArticleService articleService;


    @VerificationUserToken
    @ApiOperation("添加文章")
    @RequestMapping(value = "/addArticle",method = RequestMethod.POST)
    public Object getArticleById(@RequestBody Article article){
        article.setId(UUID.randomUUID().toString());
        article.setCreatedate(new Date());
        article.setUpdatetime(new Date());
        articleService.addArticle(article);
        return "ok";
    }


    @VerificationUserToken
    @SecurityParameter
    @ApiOperation("根据id获取文章")
    @RequestMapping(value = "/findArticleById/{id}",method = RequestMethod.POST)
    public Object findArticleById(@PathVariable String id){
        Article article = new Article();
        article.setId(id);
        return  articleService.findById(article);
    }

    @ApiOperation("条件查询")
    @RequestMapping(value = "/findByTime",method = RequestMethod.POST)
    public Object findArticleById(@RequestBody ArticelRequest articelRequest){
        return  articleService.findByStartAndEndTime(articelRequest);
    }


}
