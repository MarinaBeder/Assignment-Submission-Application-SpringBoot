package com.coderscampus.AssignmentSubmission.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum AssignmentEnum {
	// CONSTRUCTOR WITH ARGUMENT
	ASSIGNMENT_1(1, "HTML Assignment"), ASSIGNMENT_2(2, "Gussing Game"), ASSIGNMENT_3(3, "User Login"),
	ASSIGNMENT_4(4, "Student Course List"), ASSIGNMENT_5(5, "Custom Array List "),
	ASSIGNMENT_6(6, "Reports with Streams"), ASSIGNMENT_7(7, "Unit Testing"), ASSIGNMENT_8(8, "Multi-Threading"),
	ASSIGNMENT_9(9, "Spring MVC"), ASSIGNMENT_10(10, "RESTFUL Service"), ASSIGNMENT_11(11, "Full-Stack with Thymeleaf"),
	ASSIGNMENT_12(12, "Reporst with SQL"), ASSIGNMENT_13(13, "Online Bank"), ASSIGNMENT_14(14, "Chating with JS");

	private int assignmentNum;
	private String assignmentName;

	AssignmentEnum(int assignmentNum, String assignmentName) {
		this.assignmentNum = assignmentNum;
		this.assignmentName = assignmentName;
	}

	public int getAssignmentNum() {
		return assignmentNum;
	}

	public void setAssignmentNum(int assignmentNum) {
		this.assignmentNum = assignmentNum;
	}

	public String getAssignmentName() {
		return assignmentName;
	}

	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

}
