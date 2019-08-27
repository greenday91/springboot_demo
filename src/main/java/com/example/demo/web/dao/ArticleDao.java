package com.example.demo.web.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.web.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {


}
