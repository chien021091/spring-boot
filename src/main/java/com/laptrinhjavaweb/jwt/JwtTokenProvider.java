package com.laptrinhjavaweb.jwt;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.entity.CustomUserDetails;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

//@Component: Springboot sẽ hiểu đây là 1 Bean (dependency) và sẽ được Spring boot quản lý
//Khi khởi chạy ứng dụng, tìm thấy @Component, Spring Boot sẽ tạo ra 1 instance và đưa vào trong Application context để quản lý
@Component
@Slf4j
public class JwtTokenProvider {
	// Đoạn JWT_SECRET này là bí mật, chỉ có phía server biết
	@Value("${jwt.secret}")
    private String JWT_SECRET;
    
  //Thời gian có hiệu lực của chuỗi jwt
	@Value("${jwt.refreshExpirationDateInMs}")
    private long JWT_EXPIRATION;
    
 // Tạo ra jwt từ thông tin user
    public String generateToken(CustomUserDetails userDetails) {
    	Date now = new Date();
    	Date expiryDate = new Date(now.getTime() +  JWT_EXPIRATION);
    	
    	return Jwts.builder()
    			.setSubject(Long.toString(userDetails.getUser().getId()))
    			.setIssuedAt(now)
    			.setExpiration(expiryDate)
    			.signWith(SignatureAlgorithm.HS512, JWT_SECRET)
    			.compact();
    }
    
    
 // Lấy thông tin user từ jwt
    public Long getUserIdFromJWT(String token) {
    	Claims claims = Jwts.parser()
    			.setSigningKey(JWT_SECRET)
    			.parseClaimsJws(token)
    			.getBody();
    	
    	return Long.parseLong(claims.getSubject());
    }
    
    public boolean validateToken(String token) {
    	try {
    		Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token);
    		return true;
    	} catch (MalformedJwtException ex) {
            log.error("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims string is empty.");
        }
    	return false;
    }
    
}
