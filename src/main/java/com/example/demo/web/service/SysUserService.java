package com.example.demo.web.service;

import com.example.demo.web.dao.SysUserDao;
import com.example.demo.web.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserService {

    @Autowired
    private SysUserDao sysUserDao;


    public SysUser getByUserName(String username){
        return sysUserDao.getByUserName(username);
    }

    public void insertSysUser(SysUser sysUser){
        sysUserDao.insertSysUser(sysUser);
    }


}
