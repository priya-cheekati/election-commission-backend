package com.example.electionCom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electionCom.entity.Candidate;
import com.example.electionCom.entity.Vote;
import com.example.electionCom.repository.CandidateJdbcRepository;

@Service
public class CandidateService {
	
	@Autowired
	CandidateJdbcRepository repository;
	
	public List<Candidate> getAllCandidates(){
		return repository.findAll();
	}
	
	public void insertCandidate(Candidate candidate) {
		
		try {
			System.out.println(candidate);
			repository.insertPS(candidate);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	
	public Candidate getById(long id) {
		
		return repository.findById(id);
	}
	
	public Candidate getByStudentId(Candidate candidate) {
		try {
			Candidate existingCandidate = repository.findByStudentId(candidate.getStudentId());
			return existingCandidate;
		}catch(Exception ex) {
			return null;
			
		}
		
	}
	
	public int updateCandidateStatus(Candidate candidate) {
		int res = 0;
		try {
			res = repository.updateStatus(candidate);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}
}
