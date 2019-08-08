package com.example.demo.web.dao;

import com.example.demo.web.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserDao {


    SysUser getByUserName(String username);

    void insertSysUser(SysUser sysUser);


}
