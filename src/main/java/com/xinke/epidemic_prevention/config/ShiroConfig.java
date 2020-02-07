package com.xinke.epidemic_prevention.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.xinke.epidemic_prevention.realm.*;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置类
 * @author
 *
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean
     */
   /* @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //添加Shiro内置过滤器
        Map<String,String> filterMap = new LinkedHashMap<String,String>();


        //修改默认返回的登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/toLogin");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);

        return shiroFilterFactoryBean;
    }*/
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager)
    {
        ShiroFilterFactoryBean shiroFilterFactoryBean =new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /**
         * Shiro内置过滤器实现权限相关的拦截器
         * 常用的过滤器：
         *       anon:无需认证登录就可以访问
         *       authc:必须认证才能访问
         *      user:如果使用了RememberMe的功能可以直接访问
         *      prems：该角色必须得到资源权限才能访问
         *      role：该资源必须得到角色权限才能访问
         */
        Map<String,String> filterMap =new LinkedHashMap<String, String>();

        Map<String,String> filterMap2 =new LinkedHashMap<String, String>();
        filterMap.put("/user/tz", "anon");
        filterMap.put("/user/login", "anon");
        filterMap.put("/user/tz2", "authc");



        //授权过滤器
        //filterMap.put("/add", "perms[user:add]");
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/toLogin");
        System.out.println("无权限跳转");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/user/tz");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap2);
        return shiroFilterFactoryBean;
    }


    /**
     * 创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }
    /**
     * 创建Realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect,用于thymeleaf和shiro配合使用
     */
    @Bean(name = "shiroDialect")
    public ShiroDialect getShiroDialect()
    {
        return new ShiroDialect();
    }


}
