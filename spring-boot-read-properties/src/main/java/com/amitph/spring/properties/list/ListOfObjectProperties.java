package com.amitph.spring.properties.list;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static java.util.stream.Collectors.joining;

@Data
@Configuration
@ConfigurationProperties(prefix = "config")
public class ListOfObjectProperties {
    private List<Service> services;

    @Data
    public static class Service {
        private String name;
        private String url;

        @Override
        public String toString() {
            return "name: " + name
                    + ", url: " + url;
        }
    }

    @Override
    public String toString() {
        return "services: \n\t"
                + services.stream()
                .map(Object::toString)
                .collect(joining("\n\t"));
    }
}