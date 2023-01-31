package com.coderscampus.AssignmentSubmission.web;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;

import com.coderscampus.AssignmentSubmission.service.AssignmentService;

@RestController 
@Validated
///@Component
@RequestMapping( "api/assignments")
public class AssignmentController {
	/* the code in the controller shouldnot do anything special
      the code in controller should just call a service
       AssignmentServices get the data back from the service 
       and send it to the front end*/
 
   
    //}
	
	@Autowired 
  	private AssignmentService assignmentService;
   
 	//return to response ResponseEntity
 //to check if user has authentication or not "@AuthenticationPrinciple User user"
  	private User user;
	
   
   /* @PostMapping("assignment/add")//post to itself
 public ResponseEntity<?>createAssignment(@AuthenticationPrincipal @RequestBody User user ){
    	Long x=(long) 1;
    	user.setId(x);
     	Assignment newAssignment = assignmentService.save(user);
     	return ResponseEntity.ok(newAssignment);//back new assignment to user 	
}*/
  	@PostMapping("")//post to itself
  	 public ResponseEntity<?>createAssignment(@AuthenticationPrincipal User user ){
  	    	//Long x=(long) 1;
  	    	//user.setId(x);
  	     	Assignment newAssignment = assignmentService.save(user);
  	     	return ResponseEntity.ok(newAssignment);//back new assignment to user 	
  	}
}
