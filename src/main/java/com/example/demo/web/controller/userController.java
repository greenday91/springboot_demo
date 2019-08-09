package com.example.demo.web.controller;

import com.example.demo.web.entity.SysUser;
import com.example.demo.web.service.SysUserService;
import com.example.demo.web.uitl.ResponseBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class userController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation("添加用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody SysUser sysUser){
        sysUserService.insertSysUser(sysUser);
        return "sessucs";
    }

}
