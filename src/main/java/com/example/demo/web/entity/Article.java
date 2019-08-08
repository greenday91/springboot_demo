package com.example.demo.web.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;

import java.io.Serializable;
import java.util.Date;

@ApiModel
public class Article implements Serializable {


    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("title")
    private String title;

    @ApiModelProperty("content")
    private String content;

    @ApiModelProperty("autr")
    private String autr;

    @ApiModelProperty("createDate")
    private Date createDate;

    @ApiModelProperty("createBy")
    private String createBy;

    @ApiModelProperty("updateTime")
    private Date updateTime;

    @ApiModelProperty("updateBy")
    private String updateBy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAutr() {
        return autr;
    }

    public void setAutr(String autr) {
        this.autr = autr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
}
