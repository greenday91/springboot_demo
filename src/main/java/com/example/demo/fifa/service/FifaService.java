package com.example.demo.fifa.service;

import com.example.demo.fifa.entity.Basics;
import com.example.demo.spider.util.JsoupUtil;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

/**
 * @author chenzy by
 */
@Service
public class FifaService {


    public Basics sofifaToBasics(String url){
        Document document = JsoupUtil.getDocument(url,20000);
        document.getElementsByClass("table table-hover persist-area");
        return null;
    }



}
