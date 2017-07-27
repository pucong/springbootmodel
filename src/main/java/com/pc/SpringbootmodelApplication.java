package com.pc;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;


public class SpringbootmodelApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

    }
}
