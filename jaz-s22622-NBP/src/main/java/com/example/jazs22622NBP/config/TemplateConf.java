package com.example.jazs22622NBP.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class TemplateConf {

    @Bean
    RestTemplate restTemplate() {return new RestTemplate(); }
}
