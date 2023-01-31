package com.coderscampus.AssignmentSubmission.web;

import java.util.Optional;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;

import com.coderscampus.AssignmentSubmission.service.AssignmentService;

@RestController 
@Validated
///@Component
//@CrossOrigin("http://localhost:3030")
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
  	//this to create assignment for user with id =1
  	@CrossOrigin
  	@PostMapping("")//post to itself
  	 public ResponseEntity<?>createAssignment( @AuthenticationPrincipal /*@RequestBody */ User user ){
  	    	//Long x=(long) 1;
  	    	//user.setId(x);
  	     	Assignment newAssignment = assignmentService.save(user);
  	     	return ResponseEntity.ok(newAssignment);//back new assignment to user 	
  	}
  	//this to show all assignment of user using id =1
  	@GetMapping("")//post to itself
 	 public ResponseEntity<?>getAssignment(@AuthenticationPrincipal /*@RequestBody */ User user ){
 	    	//Long x=(long) 1;
 	    	//user.setId(x);
 	     	Set<Assignment>assignmentByUser=assignmentService.findByUser(user);
 	     	return ResponseEntity.ok(assignmentByUser);	}
  	
  	@GetMapping("{assignmentId}")//the two assignment id has the same thing
	 public ResponseEntity<?>getAssignment(@PathVariable Long assignmentId,@AuthenticationPrincipal User user ){
	    	//Long x=(long) 1;
	    	//user.setId(x);
	     	Optional<Assignment>assignmentOpt=assignmentService.findById(assignmentId);
	     	return ResponseEntity.ok(assignmentOpt.orElse(new Assignment()));	}
  	
  	//we will recieve the updata data from frontend
  	@PutMapping("{assignmentId}")
  	public ResponseEntity<?> getAssignment1(
  			@PathVariable Long assignmentId,
  			@RequestBody Assignment assignment,
  			@AuthenticationPrincipal User user
  		 ){
  		//User user =new User();
    	//Long x=(long) 1;
    	//user.setId(x);
    	//user.setUsername("m");
    	//user.setAuthorities("ROLE_STUDENT");
    	//user.setCohortStartDate("2022-01-01");
     	Assignment updatAssignment = assignmentService.save(assignment);
     	return ResponseEntity.ok(updatAssignment);	}
	
}




/*way write json  put method
 * {
    "id": 56,
    "status": "Needs to be submitted",
    "githupUrl": null,
    "branch": null,
    "codeReviewVideoUrl": null,
    "user": {
        "id": 1,
        "cohortStartDate": null,
        "username": "m",
        "accountNonExpired": true,
        "credentialsNonExpired": true,
        "accountNonLocked": true,
        "enabled": true
    }
}
 */
 
 /*way write get post
  {
   
   
        "id": 1,
        "cohortStartDate": null,
        "username": "m",
        "password":"asdfasdf",
        "enabled": true,
        "accountNonLocked": true,
        "accountNonExpired": true,
     "credentialsNonExpired": true
    
}
  */