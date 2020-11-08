package com.laptrinhjavaweb.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.CustomUserDetails;
import com.laptrinhjavaweb.jwt.JwtTokenProvider;
import com.laptrinhjavaweb.payload.LoginRequest;
import com.laptrinhjavaweb.payload.LoginResponse;
import com.laptrinhjavaweb.payload.RandomStuff;
import com.laptrinhjavaweb.service.impl.UserService;

///api/login: Cho phép request mà không cần xác thực.
///api/random: Là một api bất kỳ nào đó, phải xác thực mới lấy được thông tin.

@RestController
@RequestMapping("/api")
public class AuthenticationAPI {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenProvider tokenProvider;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public LoginResponse authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		// Xác thực từ username và password.
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(),
						loginRequest.getPassword()
						)
				);
		
		// Nếu không xảy ra exception tức là thông tin hợp lệ
        // Set thông tin authentication vào Security Context
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// Trả về jwt cho người dùng.
		String jwt = tokenProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		Long userId = tokenProvider.getUserIdFromJWT(jwt);
		// Lấy thông tin người dùng từ id
		UserDetails userDetails = userService.loadUserById(userId);
		
		return new LoginResponse(jwt, userDetails);
	}
	
	@GetMapping("/random")
	public RandomStuff randomStuff() {
		return new RandomStuff("JWT Hợp lệ mới có thể thấy được message này");
	}

}
