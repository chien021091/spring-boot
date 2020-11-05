package com.laptrinhjavaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.UserRepository;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	//CommandLineRunner Một interface của Spring cung cấp, có tác dụng thực hiện một nhiệm vụ khi Spring khởi chạy lần đầu.
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void run(String... args) throws Exception {
//		UserEntity user = new UserEntity();
//		user.setUserName("qchien.tran");
//		user.setPassword(passwordEncoder.encode("qchien.tran"));
//		userRepository.save(user);
//		
//		System.out.println(user);
	}
	
	
}
