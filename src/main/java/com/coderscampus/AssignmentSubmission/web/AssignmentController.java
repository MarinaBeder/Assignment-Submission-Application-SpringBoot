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
import com.coderscampus.AssignmentSubmission.dto.AssignmentResponseDto;
import com.coderscampus.AssignmentSubmission.enums.AuthorityEnum;
import com.coderscampus.AssignmentSubmission.service.AssignmentService;
import com.coderscampus.AssignmentSubmission.service.UserService;
import com.coderscampus.AssignmentSubmission.util.AuthorityUtil;

@RestController

@RequestMapping("api/assignments")
public class AssignmentController {

	@Autowired
	private AssignmentService assignmentService;
	@Autowired
	private UserService userService;

	@PostMapping("")
	public ResponseEntity<?> createAssignment(@AuthenticationPrincipal User user) {
		Long x = (long) 1;
		user.setId(x);
		Assignment newAssignment = assignmentService.save(user);
		return ResponseEntity.ok(newAssignment);
	}

	@GetMapping("")
	public ResponseEntity<?> getAssignment(@AuthenticationPrincipal User user) {

		Set<Assignment> assignmentByUser = assignmentService.findByUser(user);
		return ResponseEntity.ok(assignmentByUser);
	}

	@GetMapping("{assignmentId}")
	public ResponseEntity<?> getAssignment(@PathVariable Long assignmentId, @AuthenticationPrincipal User user) {

		Optional<Assignment> assignmentOpt = assignmentService.findById(assignmentId);
		AssignmentResponseDto response = new AssignmentResponseDto(assignmentOpt.orElse(new Assignment()));
		return ResponseEntity.ok(response);
	}

	@PutMapping("{assignmentId}")
	public ResponseEntity<?> getAssignment1(@PathVariable Long assignmentId, @RequestBody Assignment assignment,
			@AuthenticationPrincipal User user) {

		if (assignment.getCodeReviewer() != null) {

			User codeReviewer = assignment.getCodeReviewer();
			codeReviewer = userService.findUserByUsername(codeReviewer.getUsername()).orElse(new User());
			if (AuthorityUtil.hasRole(AuthorityEnum.ROLE_CODE_REVIEWER.name(), codeReviewer)) {
				assignment.setCodeReviewer(codeReviewer);

			}
		}
		Assignment updatAssignment = assignmentService.save(assignment);
		return ResponseEntity.ok(updatAssignment);
	}

}
