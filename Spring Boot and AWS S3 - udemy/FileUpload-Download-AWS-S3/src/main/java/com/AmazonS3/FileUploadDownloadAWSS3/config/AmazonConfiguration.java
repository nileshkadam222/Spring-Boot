package com.AmazonS3.FileUploadDownloadAWSS3.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties("amazon")
public class AmazonConfiguration {

    Map<String,String> credentials;
    Map<String,String> s3;

    public Map<String, String> getCredentials() {
        return credentials;
    }

    public void setCredentials(Map<String, String> credentials) {
        this.credentials = credentials;
    }

    public Map<String, String> getS3(String bucketName) {
        return s3;
    }

    public void setS3(Map<String, String> s3) {
        this.s3 = s3;
    }

    public String getCredentialsValue(String key){
       return this.credentials.get(key);
    }

    public String getS3Value(String key){
        return this.s3.get(key);
    }
}
