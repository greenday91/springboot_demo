package com.example.demo.fifa.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chenzy by
 */
@Data
public class Basics {

    //主键
    private String id;

    //编号
    private String number;

    //身高
    private String height;

    //体重
    private String weight;

    //惯用脚
    private String foot;

    //最高能力
    private String Supreme;

    //最佳位置
    private String bestPosition;

    //成长空间
    private String growthSpace;

    //入队时间
    private Date entryTime;

    //租借到期时间
    private Date leaseExpire;

    //身价
    private BigDecimal socialStatus;

    //周薪
    private BigDecimal weeklyPay;

    //违约金
    private BigDecimal liquidatedDamages;
}
