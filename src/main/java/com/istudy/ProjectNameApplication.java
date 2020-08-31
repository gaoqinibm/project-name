package com.istudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@MapperScan("com.rocky.*.mapper")
@ComponentScan({"com.istudy", "com.rocky"})
public class ProjectNameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectNameApplication.class, args);
	}

}
