package com.example.demo.web.service;

import com.example.demo.util.ToKenUtil;
import com.example.demo.web.dao.SysUserDao;
import com.example.demo.web.entity.SysUser;
import com.example.demo.web.uitl.RedisService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private RedisService redisService;

    @Value("${article.sys.tokentime}")
    private Integer tokenTimeOut;


    public SysUser getByUserName(String username){
        return sysUserDao.getByUserName(username);
    }

    public void insertSysUser(SysUser sysUser){
        sysUserDao.insertSysUser(sysUser);
    }

    public String generateToken(String name,String password){
        SysUser sysUser = this.getByUserName(name);
        if (null != sysUser) {
            if(sysUser.getPassWord().equals(password)){
                //缓存中不为空直接返回,避免重复生成
                String token_string = "";
                token_string = (String)redisService.get(sysUser.getId()+"_token");
                if(StringUtils.isNotEmpty(token_string)){
                    return token_string;
                }
                token_string = ToKenUtil.generateTokenByUser(sysUser);
                //缓存token
                redisService.set(sysUser.getId()+"_token",token_string);
                //缓存用户
                redisService.set(sysUser.getId(),sysUser);
                //设置token和user缓存过期时间
                redisService.expire(sysUser.getId()+"_token",tokenTimeOut);
                redisService.expire(sysUser.getId(),tokenTimeOut);
                return token_string;
            }
        }
        return "用户名密码错误";
    }


}
