package com.bizTrack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan("com")
public class BizTrackApplication {

	public static void main(String[] args) {

		SpringApplication.run(BizTrackApplication.class, args);

	}

}
