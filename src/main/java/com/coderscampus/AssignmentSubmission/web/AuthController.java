package com.coderscampus.AssignmentSubmission.web;

import java.lang.System.Logger.Level;
import java.net.http.HttpResponse;
import java.util.logging.Logger;

import org.apache.catalina.startup.UserDatabase;

import org.apache.commons.logging.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController
@RequestMapping("api/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authenticationManagerr;
	@Autowired
	private JwtUtil jwtUtili;

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody AuthCredentialsRequest request) {
		try {
			Authentication authenticate = authenticationManagerr.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

			User user = (User) authenticate.getPrincipal();
			user.setPassword(null);
			return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtUtili.generateToken(user)).body(user);
		} catch (BadCredentialsException ex) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<?> validateToken1(@RequestParam String token, @AuthenticationPrincipal User user)
			throws ExpiredJwtException, SignatureException {
		org.jboss.logging.Logger logger = LoggerFactory.logger(JwtUtil.class);

		try {
			Boolean isTokenValid = jwtUtili.vaildateToken(token, user);
			return ResponseEntity.ok(isTokenValid);
		}

		catch (SignatureException e) {
			Logger.getLogger(JwtUtil.class.getName()).log(null, "");
			return ResponseEntity.ok(false);
		} catch (ExpiredJwtException ex) {
			return ResponseEntity.ok(false);
		} catch (MalformedJwtException e) {
			logger.debug("token malformed" + e);

		} catch (UnsupportedJwtException e) {
			logger.debug("unsupported" + e);

		} catch (IllegalArgumentException e) {
			logger.debug("Illegal" + e);

		}
		return ResponseEntity.ok(false);

	}

}
