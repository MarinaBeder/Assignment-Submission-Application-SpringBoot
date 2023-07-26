package com.coderscampus.AssignmentSubmission.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.coderscampus.AssignmentSubmission.domain.Comment;

public interface commentRepository extends JpaRepository<Comment, Long> {

	@Query(" select c from Comment c " + " where c.assignment.id = :assignmentId ")
	Set<Comment> findByAssignmentId(Long assignmentId);

}
