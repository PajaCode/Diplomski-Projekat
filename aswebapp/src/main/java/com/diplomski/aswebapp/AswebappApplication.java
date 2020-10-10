package com.diplomski.aswebapp;

import com.diplomski.aswebapp.entities.User;
import com.diplomski.aswebapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.diplomski.aswebapp.repository"})
@ComponentScan({"com.dipolmski.aswebapp.services"})
@EntityScan("com.diplomski.aswebapp")
@EnableJpaRepositories({"com.diplomski.aswebapp.repository","com.dipolmski.aswebapp.services"})
public class AswebappApplication implements CommandLineRunner {
	@Autowired(required = true)
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(AswebappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		{
			User newAdmin = new User("admin@gmail.com", "Admin", "123456");
			userService.createAdmin(newAdmin);
		}
	}
}
