package com.example.demo.web.service;

import com.example.demo.util.ToKenUtil;
import com.example.demo.web.entity.SysUser;
import com.example.demo.web.uitl.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SystemService {

    @Autowired
    private RedisService redisService;

    public SysUser getLoginUser(){
        String userid = ToKenUtil.getTokenUserId();
        SysUser sysUser = (SysUser) redisService.get(userid);
        return sysUser;
    }

}
