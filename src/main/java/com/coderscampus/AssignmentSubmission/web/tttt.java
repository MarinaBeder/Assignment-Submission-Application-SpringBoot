package com.coderscampus.AssignmentSubmission.web;

import org.apache.catalina.startup.UserDatabase;

import org.apache.commons.logging.Log;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.dto.AuthCredentialsRequest;
import com.coderscampus.AssignmentSubmission.service.AssignmentService;
import com.coderscampus.AssignmentSubmission.util.JwtUtil;
//import com.coderscampus.AssignmentSubmission.filter.JwtUtil;

//@Api(tags = "Authentication")
@RestController 
@Validated
///@Component
@RequestMapping( "api")
public class tttt {
	
    @PostMapping("view1")
    public String hhh() {
    	return "ffffffffffffffffffff";
    	
    }
	
}
