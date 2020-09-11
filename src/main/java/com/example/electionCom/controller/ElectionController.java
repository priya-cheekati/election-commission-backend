package com.example.electionCom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.electionCom.entity.Vote;
import com.example.electionCom.service.ElectionService;
 
@RestController
@RequestMapping("/api/")
public class ElectionController {
	
	@Autowired
	ElectionService electionService;
	
	@GetMapping(path = "votes")
    public ResponseEntity<?> getVotes() {
        List<Vote> votes = electionService.getAllVotes();
        
        return ResponseEntity.ok(votes);
    }
	
	@PostMapping(path = "vote")
	public ResponseEntity<?> vote(@RequestBody Vote vote){

		
		Vote existingVote = electionService.getVote(vote);
		System.out.println(existingVote);
		if(existingVote==null)
			electionService.insertVote(vote);
		return ResponseEntity.ok("Success");
	}
	
	@GetMapping(path="count")
	public ResponseEntity<?> getCount(@RequestParam Long candidateId){
		
		int count = electionService.getCount(candidateId);
		return ResponseEntity.ok(count);
	}
}
