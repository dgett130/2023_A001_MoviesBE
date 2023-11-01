package com.github.dgett130.A001.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@PropertySource("classpath:application.properties")
@Component
public class TMDBConfig {

    @Value("${tmdb.api.key}")
    private String apiKey;

}
