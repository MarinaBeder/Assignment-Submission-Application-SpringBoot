package com.coderscampus.AssignmentSubmission.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Assignment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer number;
	private String status;
	@Column(updatable = true)
	private String githupUrl;
	@Column(updatable = true)
	private String branch;

	private String codeReviewVideoUrl;
	@ManyToOne(optional = false)

	private User user;

	@ManyToOne // many student have one codereviewer
	private User codeReviewer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGithupUrl() {
		return githupUrl;
	}

	public void setGithupUrl(String githupUrl) {
		this.githupUrl = githupUrl;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCodeReviewVideoUrl() {
		return codeReviewVideoUrl;
	}

	public void setCodeReviewVideoUrl(String codeReviewVideoUrl) {
		this.codeReviewVideoUrl = codeReviewVideoUrl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public User getCodeReviewer() {
		return codeReviewer;
	}

	public void setCodeReviewer(User codeReviewer) {
		this.codeReviewer = codeReviewer;
	}

}
