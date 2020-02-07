package com.xinke.epidemic_prevention.realm;


import com.xinke.epidemic_prevention.bean.user.User;
import com.xinke.epidemic_prevention.dao.user.userRepository;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm
 * @author wang
 *
 */
public class UserRealm extends AuthorizingRealm{

    @Autowired
    userRepository ur;
    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        User user1 = ur.findByNumber(user.getNumber());
        //添加资源的授权字符串
        info.addStringPermission(user1.getPower());
        return info;
    }

   /* *
     * 执行认证逻辑*/

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证逻辑");
        //1.判断用户名
        UsernamePasswordToken token  =  (UsernamePasswordToken)authenticationToken;
       // System.out.println(token.getUsername());
        User user = ur.findByNumber(token.getUsername());
       // System.out.println(user);
        if(user==null){
            return  null;
            //shiro底层抛出unknown
        }
        //判断密码
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");

    }
}