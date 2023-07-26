package com.coderscampus.AssignmentSubmission.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentStatusEnum {
	PENDING_SUMISSION("Pending Submission", 1), SUBMITTED("Submitted", 2), IN_REVIEW("In Review", 3),
	NEEDS_UPDATED("Needs Updated", 4), COMPLETED("Compledted", 5);

	private String status;
	private Integer step;

	AssignmentStatusEnum(String status, Integer step) {
		this.status = status;
		this.step = step;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

}
