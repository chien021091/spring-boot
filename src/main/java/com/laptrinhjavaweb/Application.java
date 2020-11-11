package com.laptrinhjavaweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.repository.UserRepository;

//Nhiệm vụ chính của Spring là tạo ra 1 container chứa các Dependency 

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Application implements CommandLineRunner {
	public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(Application.class, args); //tạo ra container , sau đó nó tìm toàn bộ Dependency trong project và injecter vào
        //Spring đặt tên cho container là ApplicationContext
        //Các dependency là Bean
        
        //Cách để Spring biết đâu là dependency =>> thông qua @Component
        
        //Khái niệm Dependency Injection
        //là việc các Object nên phụ thuộc vào các Abstract class và thể hiện chi tiết của nó sẽ được inject vào lúc runtime
        
        //IOC: Inversion of Control: Định nghĩa trước các dependency, mô tả nó và chuyển nó vào trong 1 framework quản lý.
        //Bất kỳ các class khi khởi tạo, cần dependency gì, framework sẽ tự tìm trong kho và inject vào
	}

	//CommandLineRunner Một interface của Spring cung cấp, có tác dụng thực hiện một nhiệm vụ khi Spring khởi chạy lần đầu.
	//Autowired: đơn giản chỉ là khi Spring boot gặp antonation này, nó sẽ tạo ra 1 instance mới(bean) và đặt vào (injecter) khi khởi tạo class hiện tại =>> = new UserRepository()
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired 
	CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
//		//add an user to table
//		UserEntity user = new UserEntity();
//		user.setUserName("qchien.tran");
//		user.setPassword(passwordEncoder.encode("qchien.tran"));
//		user.setStatus(UserEntity.STAT_ACTIVE);
//		userRepository.save(user);
//		
//		
//		//add category to tab
//		String[] codeCat = {"technology", "education", "nature", "animals", "styles"};
//		String[] nameCat = {"Technology", "Education", "Nature", "Animals", "Styles"}; 
//		for(int i = 0; i< 5; i++) {
//			CategoryEntity cat = new CategoryEntity();
//			cat.setCode(codeCat[i]);
//			cat.setName(nameCat[i]);
//			
//			categoryRepository.save(cat);
//		}
		
		
	}
	
	
}
