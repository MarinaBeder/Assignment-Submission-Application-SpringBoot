package com.coderscampus.AssignmentSubmission.web;

import java.lang.System.Logger.Level;
import java.util.logging.Logger;

import org.apache.catalina.startup.UserDatabase;


import org.apache.commons.logging.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.dto.AuthCredentialsRequest;
import com.coderscampus.AssignmentSubmission.service.AssignmentService;
import com.coderscampus.AssignmentSubmission.util.JwtUtil;

import antlr.Token;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
//import com.coderscampus.AssignmentSubmission.filter.JwtUtil;

//@Api(tags = "Authentication")
@RestController 
@Validated
///@Component
@RequestMapping( "api/cauth")
public class AuthController  {
@Autowired
	private  AuthenticationManager authenticationManagerr ;
@Autowired   
private  JwtUtil jwtUtili;

   /* public AuthController(AuthenticationManager authenticationManager,JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }*/
   //@CrossOrigin
   @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody  AuthCredentialsRequest request) {
        try {
            Authentication authenticate = authenticationManagerr
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                    )
                );

            User user = (User) authenticate.getPrincipal();
 user.setPassword(null);//to donot show password in postman for security
            return ResponseEntity.ok()
                .header(
                    HttpHeaders.AUTHORIZATION,
                    jwtUtili.generateToken(user)
                )
                .body(user);
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
   
   // we will make function to get request for data "jwt" 
   //data like expiring 
   //7
   //localhost:8080/api/auth/validaye?token=blahblahblah
   //to test this 
   /*we should put Bearer token*/
   @GetMapping("/validate")
   public ResponseEntity<?> validateToken1(@RequestParam String token,@ AuthenticationPrincipal User user) throws ExpiredJwtException 
   {	//org.jboss.logging.Logger logger = LoggerFactory.logger(JwtUtil.class);

	   try {
	   Boolean isTokenValid= jwtUtili.vaildateToken(token, user);
        return ResponseEntity.ok(isTokenValid);
	   }
	  
   catch (ExpiredJwtException ex) {
	   return ResponseEntity.ok(false);
          } 

      


}
    //@CrossOrigin
    @GetMapping("view")
    public String hh() {
    	return "ffffffffffffffffffff";
    	
    }
	
  }




