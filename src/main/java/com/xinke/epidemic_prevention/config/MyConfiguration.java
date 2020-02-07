package com.xinke.epidemic_prevention.config;

/**
 * @Author:jlz
 * @Date: 2020/2/6
 * 路径： com.xinke.epidemic_prevention.config
 * 功能描述：
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration extends WebMvcConfigurerAdapter {
    //2/7wrr添加
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){

        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/").addResourceLocations("file:/data/annimalscience/java/jdk1.8.0_231/bin/static/");
        //addResourceHandler是指定的虚拟路径，addResourceLocations是自己的物理路径，
        registry.addResourceHandler("/file/**").addResourceLocations("file:D:/");
        super.addResourceHandlers(registry);
    }


}