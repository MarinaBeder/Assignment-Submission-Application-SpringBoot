package com.coderscampus.AssignmentSubmission.service;

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

}
