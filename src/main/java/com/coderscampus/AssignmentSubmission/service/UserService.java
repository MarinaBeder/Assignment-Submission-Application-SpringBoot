package com.coderscampus.AssignmentSubmission.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderscampus.AssignmentSubmission.domain.User;
import com.coderscampus.AssignmentSubmission.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public Optional<User> findUserByUsername(String username) {
		return userRepo.findByUsername(username);
	}
}
