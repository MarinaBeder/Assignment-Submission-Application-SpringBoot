package com.coderscampus.AssignmentSubmission.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.User;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>  {
	Set<Assignment>findByUser(User user);

}
