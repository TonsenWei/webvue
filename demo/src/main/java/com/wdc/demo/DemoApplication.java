package com.wdc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.wdc.demo.dao")
@EntityScan("com.wdc.demo.pojo")
public class DemoApplication extends SpringBootServletInitializer {

	/**
	 * 部署到ubuntu tomcat增加的配置
	 */
	// @Override
	// protected SpringApplicationBuilder configure(SpringApplicationBuilder
	// application) {
	// return application.sources(DemoApplication.class);
	// }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
