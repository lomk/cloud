package net.elyland.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = {"net.elyland.cloud.repositories"})
@ComponentScan(basePackages = {
        "net.elyland.cloud",
        "net.elyland.cloud.domain",
        "net.elyland.cloud.repositories",
        "net.elyland.cloud.services",
        "net.elyland.cloud.validator" })
@EntityScan(basePackages = {"net.elyland.cloud.domain"})
public class SpringBootMvcJspApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcJspApplication.class, args);
	}
}
