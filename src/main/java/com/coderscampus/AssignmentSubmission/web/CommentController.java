package com.coderscampus.AssignmentSubmission.web;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.AssignmentSubmission.domain.Comment;
import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.dto.CommentDto;
import com.coderscampus.AssignmentSubmission.service.CommentService;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	public CommentService commentService;

	@PostMapping("")
	public ResponseEntity<Comment> createComment(@RequestBody CommentDto commentDto,
			@AuthenticationPrincipal User user) {
		Comment comment = commentService.save(commentDto, user);

		System.out.println(commentDto);
		System.out.println(user);

		return ResponseEntity.ok(comment);
	}

	@PutMapping("{commentId}")
	public ResponseEntity<Comment> updateComment(@RequestBody CommentDto commentDto,
			@AuthenticationPrincipal User user) {
		Comment comment = commentService.save(commentDto, user);

		System.out.println(commentDto);
		System.out.println(user);

		return ResponseEntity.ok(comment);
	}

	@GetMapping("")
	public ResponseEntity<Set<Comment>> getCommentsByassignment(@RequestParam Long assignmentId) {
		Set<Comment> comments = commentService.getCommentByAssignmentId(assignmentId);
		return ResponseEntity.ok(comments);
	}

	@DeleteMapping("{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
		try {
			commentService.delete(commentId);
			return ResponseEntity.ok("Comment deleted");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
