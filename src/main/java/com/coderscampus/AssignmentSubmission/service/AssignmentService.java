package com.coderscampus.AssignmentSubmission.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.repository.AssignmentRepository;

@Service
public class AssignmentService {
@Autowired
private AssignmentRepository assignmentRepo;
	
	public Assignment save(User user) {
		Assignment assignment = new Assignment();
		/* what do you put in the assignment set branch code review url githup ..*/
		assignment.setStatus("Needs to be submitted");
		assignment.setUser(user);
		return assignmentRepo.save(assignment);//will return assignment object
	}
	public Set<Assignment>findByUser(User user){
		return assignmentRepo.findByUser(user);
	}
	
	public Optional<Assignment> findById(Long assignmentId) {
		return assignmentRepo.findById(assignmentId);
	}
	public Assignment save(Assignment assignment) {
		
		return assignmentRepo.save(assignment);
	}
	

}
