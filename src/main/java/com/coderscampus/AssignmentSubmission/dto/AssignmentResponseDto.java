package com.coderscampus.AssignmentSubmission.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coderscampus.AssignmentSubmission.domain.Assignment;
import com.coderscampus.AssignmentSubmission.enums.AssignmentEnum;
import com.coderscampus.AssignmentSubmission.enums.AssignmentStatusEnum;

public class AssignmentResponseDto {
	private Assignment assignment;
	private AssignmentEnum[] assignmentEnums = AssignmentEnum.values();
	private AssignmentStatusEnum[] statusEnum = AssignmentStatusEnum.values();

	public AssignmentResponseDto(Assignment assignment) {
		super();
		this.assignment = assignment;

	}

	public Assignment getAssignment() {
		return assignment;
	}

	public void setAssignment(Assignment assignment) {
		this.assignment = assignment;
	}

	public AssignmentEnum[] getAssignmentEnums() {
		return assignmentEnums;
	}

	public AssignmentStatusEnum[] getStatusEnum() {
		return statusEnum;
	}

}
