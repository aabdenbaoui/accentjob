package com.abdenan.jobportal;

import com.abdenan.jobportal.usermanagement.UserManagementController;
import com.abdenan.jobportal.usermanagement.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Map;

@SpringBootApplication
public class JobportalApplication {
	@Autowired
	UserManagementController userManagementController;
	public static void main(String[] args) {
		SpringApplication.run(JobportalApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {

		};
	}
}
