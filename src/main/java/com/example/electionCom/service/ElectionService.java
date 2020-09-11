package com.example.electionCom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.electionCom.entity.Vote;
import com.example.electionCom.repository.ElectionJdbcRepository;

@Service
public class ElectionService {
	
	
	@Autowired
	ElectionJdbcRepository repository;
	
	
	public List<Vote> getAllVotes(){
		return repository.findAll();
	}
	
	public Vote getVote(Vote vote) {
		Vote existingVote = null;
		try {
			existingVote = repository.find(vote.getVoterId(), vote.getCandidateId());
			
		} catch (Exception e) {
			return null;
		}
		return existingVote;
	}
	
	public int getCount(Long candidateId) {
		int count = -1;
		try {
			count = repository.getVoteCount(candidateId);
		} catch (Exception e) {
			System.out.println("Error Occurred!!");
		}
		
		return count;
	}

	public void insertVote(Vote vote) {
		
		try {
			repository.insertPS(vote);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
