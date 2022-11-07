package com.pragma.challenge.clean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

/*@SpringBootApplication(scanBasePackages = {"test"} , exclude = JpaRepositoriesAutoConfiguration.class)*/
@SpringBootApplication
public class CleanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CleanApplication.class, args);
	}

}
