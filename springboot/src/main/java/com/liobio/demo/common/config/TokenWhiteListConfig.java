package com.liobio.demo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author LIOBIO
 * @version 1.0.0
 * @ClassName TokenWhiteListConfig.java
 * @createTime 2022/03/10/01:05:00
 * @Description
 */
@Configuration
@ConfigurationProperties(prefix = "system")
public class TokenWhiteListConfig {

    private List<String> whiteList;

    public List<String> getWhiteList() {
        return whiteList;
    }
    public void setWhiteList(List<String> whiteList) {
        this.whiteList = whiteList;
    }
}
