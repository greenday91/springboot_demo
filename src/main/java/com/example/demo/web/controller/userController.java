package com.example.demo.web.controller;

import com.example.demo.annotation.PassToken;
import com.example.demo.annotation.VerificationUserToken;
import com.example.demo.model.RestResponse;
import com.example.demo.web.entity.SysUser;
import com.example.demo.web.service.SysUserService;
import com.example.demo.web.uitl.ResponseBean;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/")
public class userController {

    @Autowired
    private SysUserService sysUserService;


    @PassToken
    @ApiOperation("获取token")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginSys(@RequestParam("name") String name,
                           @RequestParam("password") String password){
        String data = sysUserService.generateToken(name,password);
        return RestResponse.success(data);
    }



    @VerificationUserToken
    @ApiOperation("添加用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Object addUser(@RequestBody SysUser sysUser){
        sysUserService.insertSysUser(sysUser);
        return RestResponse.success();
    }


}
