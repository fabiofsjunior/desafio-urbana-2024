package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class config {
    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
