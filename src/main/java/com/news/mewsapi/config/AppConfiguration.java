package com.news.mewsapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    public AppConfiguration() {
    }

    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
