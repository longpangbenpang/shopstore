package com.shop.shopstore.common.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageConfig {

    //@Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum", "true");
        properties.setProperty("rowBoundsWithCount", "true");
        properties.setProperty("reasonable", "true");
        properties.setProperty("dialect", "Mysql");    //配置mysql数据库的方言
        pageHelper.setProperties(properties);
        return pageHelper;
    }
}
