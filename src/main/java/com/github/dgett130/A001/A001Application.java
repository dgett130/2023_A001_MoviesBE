package com.github.dgett130.A001;

import com.github.dgett130.A001.entity.TMDBConfig;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class A001Application {

	public static void main(String[] args) {
		SpringApplication.run(A001Application.class, args);
	}

}
