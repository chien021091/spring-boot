package com.laptrinhjavaweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.laptrinhjavaweb.jwt.JwtAuthenticationFilter;
import com.laptrinhjavaweb.service.impl.UserService;

//@EnableWebSecurity là 1 @configuration
//@Configuration là 1 antonation đánh dấu trên 1 class cho phép Spring boot biết đây là nơi định nghĩa các BEAN
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserService userService;
	
	//@Bean là 1 antonation được đánh dấu trên các method cho phép Spring boot biết được đây là Bean và sẽ thực hiện đưa Bean và context
	//@Bean sẽ chỉ nằm trong các class có đánh dấu @Configuration
	@Bean
	public JwtAuthenticationFilter jwtAuthenticationFilter() {
		return new JwtAuthenticationFilter();
	}
	
	@Bean(BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// Get AuthenticationManager bean
		return super.authenticationManagerBean();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// Password encoder, để Spring Security sử dụng mã hóa mật khẩu người dùng
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Cung cáp userservice cho spring security
		auth.userDetailsService(userService)
		.passwordEncoder(passwordEncoder());// cung cấp password encoder
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		
		// No session will be created or used by spring security
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http
		.cors()// Ngăn chặn request từ một domain khác
			.and()
		.authorizeRequests()
			.antMatchers("/api/login").permitAll() // Cho phép tất cả mọi người truy cập vào địa chỉ này (list tất cả các api cần get mà k cần đăng nhập)
			.antMatchers("/photos").permitAll()
			.antMatchers("/categorys").permitAll()
			.antMatchers("/api/register").permitAll()
			.anyRequest().authenticated(); // Tất cả các request khác đều cần phải xác thực mới được truy cập
		
		// Thêm một lớp Filter kiểm tra jwt
		http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
