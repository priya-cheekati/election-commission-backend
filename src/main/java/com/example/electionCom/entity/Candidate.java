package com.example.electionCom.entity;

public class Candidate {
	
	private Long id;
	private Long studentId;
	private String description;
	private int status;
	
	public Candidate() {
		super();
	}
	
	public Candidate(Long id, Long studentId, String description, int status) {
		super();
		this.id = id;
		this.studentId = studentId;
		this.description = description;
		this.status = status;
	}
	
	public Candidate(Long studentId, String description, int status) {
		super();
		this.studentId = studentId;
		this.description = description;
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		return String.format("Candidate [id=%s, studentId=%s, description=%s, status=%s]", id, studentId, description, status);
	}
}
