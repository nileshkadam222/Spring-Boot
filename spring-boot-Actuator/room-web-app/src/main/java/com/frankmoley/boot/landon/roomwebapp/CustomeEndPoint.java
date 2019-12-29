package com.frankmoley.boot.landon.roomwebapp;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomeEndPoint implements Endpoint<Map<String,String>> {
    @Override
    public String getId() {
        return "test";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public Map<String, String> invoke() {
        Map<String,String> endpointData = new HashMap<>();
        endpointData.put("room","a");
        endpointData.put("ee","ee");
        return endpointData;
    }
}
