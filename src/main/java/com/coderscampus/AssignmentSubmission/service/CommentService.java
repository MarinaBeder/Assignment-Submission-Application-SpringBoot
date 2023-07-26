package com.coderscampus.AssignmentSubmission.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.domain.Comment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.dto.CommentDto;
import com.coderscampus.AssignmentSubmission.repository.AssignmentRepository;
import com.coderscampus.AssignmentSubmission.repository.commentRepository;

@Service
public class CommentService {

	@Autowired
	private commentRepository commentRepo;
	@Autowired
	private AssignmentRepository assignmentRepo;

	public Comment save(CommentDto commentDto, User user) {

		Comment comment = new Comment();
		Assignment assignment = assignmentRepo.getById(commentDto.getAssignmentId());

		comment.setId(commentDto.getId());
		comment.setAssignment(assignment);
		comment.setText(commentDto.getText());
		comment.setCreatedBy(user);
		if (comment.getId() == null) {
			comment.setCreatedDate(ZonedDateTime.now());
		} else
			comment.setCreatedDate(commentDto.getCreatedDate());

		return commentRepo.save(comment);
	}

	public Set<Comment> getCommentByAssignmentId(Long assignmentId) {
		Set<Comment> comments = commentRepo.findByAssignmentId(assignmentId);

		return comments;
	}

	public void delete(Long commentId) {
		commentRepo.deleteById(commentId);

	}

}
