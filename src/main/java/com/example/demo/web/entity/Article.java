package com.example.demo.web.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@ApiModel
@TableName("article")
public class Article implements Serializable {


    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("title")
    private String title;

    @ApiModelProperty("content")
    private String content;

    @ApiModelProperty("autr")
    private String autr;

    @ApiModelProperty("createdate")
    private Date createdate;

    @ApiModelProperty("createby")
    private String createby;

    @ApiModelProperty("updatetime")
    private Date updatetime;

    @ApiModelProperty("updateby")
    private String updateby;
}
