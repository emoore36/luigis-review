package com.luigis.luigisreview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.luigis.luigisreview"})
public class LuigisReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(LuigisReviewApplication.class, args);
	}

}
