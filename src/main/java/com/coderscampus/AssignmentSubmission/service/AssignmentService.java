package com.coderscampus.AssignmentSubmission.service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.enums.AssignmentStatusEnum;
import com.coderscampus.AssignmentSubmission.enums.AuthorityEnum;
import com.coderscampus.AssignmentSubmission.repository.AssignmentRepository;

@Service
public class AssignmentService {
	@Autowired
	private AssignmentRepository assignmentRepo;

	public Assignment save(User user) {
		Assignment assignment = new Assignment();

		assignment.setStatus(AssignmentStatusEnum.PENDING_SUMISSION.getStatus());
		assignment.setNumber(findNextAssignmentToSubmit(user));
		assignment.setUser(user);
		return assignmentRepo.save(assignment);
	}

	private Integer findNextAssignmentToSubmit(User user) {
		Set<Assignment> assignmentByUser = assignmentRepo.findByUser(user);
		if (assignmentByUser == null) {
			return 1;
		}
		Optional<Integer> nextAssignmentNumbOpt = assignmentByUser.stream().sorted((a1, a2) -> {
			if (a1.getNumber() == null)
				return 1;
			if (a2.getNumber() == null)
				return 1;
			return a2.getNumber().compareTo(a1.getNumber());
		}).map(assignment -> {

			if (assignment.getNumber() == null)
				return 1;

			return assignment.getNumber() + 1;
		}).findFirst();
		return nextAssignmentNumbOpt.orElse(1);
	}

	public Set<Assignment> findByUser(User user) {

		boolean hasCodeReviewRole = user.getAuthorities().stream()
				.filter(auth -> AuthorityEnum.ROLE_CODE_REVIEWER.name().equals(auth.getAuthority())).count() > 0;

		if (hasCodeReviewRole) {
			return assignmentRepo.findByCodeReviewer(user);
		} else {

			return assignmentRepo.findByUser(user);
		}
	}

	public Optional<Assignment> findById(Long assignmentId) {
		return assignmentRepo.findById(assignmentId);
	}

	public Assignment save(Assignment assignment) {

		return assignmentRepo.save(assignment);
	}

}
