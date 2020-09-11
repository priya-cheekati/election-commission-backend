package com.example.electionCom.entity;

public class Vote {
	private Long id;
	private Long voterId;
	private Long candidateId;
	private Long roleId;
	
	public Vote() {
		super();
	}
	
	public Vote(Long id, Long voterId, Long candidateId, Long roleId) {
		super();
		this.id = id;
		this.voterId = voterId;
		this.candidateId = candidateId;
		this.roleId = roleId;
	}
	
	public Vote( Long voterId, Long candidateId, Long roleId) {
		super();
		this.voterId = voterId;
		this.candidateId = candidateId;
		this.roleId = roleId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getVoterId() {
		return voterId;
	}
	public void setVoterId(Long voterId) {
		this.voterId = voterId;
	}
	public Long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	@Override
    public String toString() {
        return String.format("Vote [id=%s, voterId=%s, candidateId=%s, roleId=%s]", id, voterId, candidateId, roleId);
    }
	
}
