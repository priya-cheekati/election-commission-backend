package com.example.electionCom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.electionCom.entity.Candidate;
import com.example.electionCom.service.CandidateService;

@RestController
@RequestMapping("/api/")
public class CandidateController {

	@Autowired
	CandidateService candidateService;
	
	@GetMapping(path = "candidates")
    public ResponseEntity<?> getCandidates() {
        List<Candidate> candidates = candidateService.getAllCandidates();
        
        return ResponseEntity.ok(candidates);
    }
		
	@PostMapping(path = "candidate")
	public ResponseEntity<?> create(@RequestBody Candidate candidate){

		
		Candidate existingCandidate = candidateService.getByStudentId(candidate);
		System.out.println(existingCandidate);
		System.out.println(candidate);
		if(existingCandidate == null)
			candidate.setStatus(0);
			candidateService.insertCandidate(candidate);
			
		return ResponseEntity.ok("Success");
	}
	
	@PutMapping(path = "candidate/approve")
	public ResponseEntity<?> approvateCandidate(@RequestParam Long id){
		Candidate existingCandidate = candidateService.getById(id);
		
		if(existingCandidate != null) {
			existingCandidate.setStatus(1);
			candidateService.updateCandidateStatus(existingCandidate);
		}
		
		
		return ResponseEntity.ok("Success");

		
	}
}
