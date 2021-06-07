package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;
import com.capgemini.personality.service.ICandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {
	
	@Autowired
	private ICandidateService candidateService;

	@RequestMapping("/listcandidates")
	public List<CandidateDTO> getAllCandidates() {
		return candidateService.getAllCandidates();
	}

	@RequestMapping("/{candidateId}")
	public CandidateDTO getCandidate(@PathVariable int id) {
		return candidateService.getCandidate(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcandidate")
	public CandidateDTO addCandidate(@RequestBody Candidate candidate) {
		return candidateService.addCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updatecandidate")
	public CandidateDTO updateCandidate( @RequestBody Candidate candidate) {
		return candidateService.updateCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecandidate/{candidateId}")
	public CandidateDTO deleteCandidate(int id) {
		return candidateService.deleteCandidate(id);
	}
}


