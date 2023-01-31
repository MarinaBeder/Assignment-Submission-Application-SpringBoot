package com.coderscampus.AssignmentSubmission.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.coderscampus.AssignmentSubmission.domain.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>  {
	

}
