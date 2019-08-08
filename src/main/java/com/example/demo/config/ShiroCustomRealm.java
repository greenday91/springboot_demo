package com.example.demo.config;

import com.example.demo.web.entity.SysUser;
import com.example.demo.web.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * 描述：
 *
 * @author chenzy
 * @create 2019-01-27-13:57
 */
public class ShiroCustomRealm extends AuthorizingRealm {

    private static Logger log = LoggerFactory.getLogger(ShiroCustomRealm.class);

    @Autowired
    private SysUserService sysUserService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     *
     * private UserService userService;
     * <p>
     * 获取即将需要认证的信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-------身份认证方法--------");
        try{
            if(null != authenticationToken.getCredentials() && null != authenticationToken.getPrincipal()){

                String userName = (String) authenticationToken.getPrincipal();
                String userPwd = new String((char[]) authenticationToken.getCredentials());

                if (StringUtils.isEmpty(userName)|| StringUtils.isEmpty(userPwd)) {
                    throw new AccountException("用户名密码不能为空!");
                }

                SysUser sysUser = sysUserService.getByUserName(userName);

                if(null == sysUser){
                    throw new AccountException("用户名无效!");
                }

                if(!sysUser.getPassWord().equals(userPwd)){
                    throw new AccountException("密码无效!");
                }
                return new SimpleAuthenticationInfo(userName, sysUser.getPassWord(),getName());
            }
            throw new AccountException("账户密码不能为空!!");
        }catch (Exception e){
            log.info(e.getLocalizedMessage());
            throw new AccountException("验证失败:"+e.getMessage());
        }

    }
}
