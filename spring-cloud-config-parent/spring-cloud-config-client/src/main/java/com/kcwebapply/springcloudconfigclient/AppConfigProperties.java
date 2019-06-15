package com.kcwebapply.springcloudconfigclient;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "system")
public class AppConfigProperties {


    private String url = "";

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
