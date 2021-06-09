package com.capgemini.personality.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.exception.ConstraintValidationException;
import com.capgemini.personality.exception.NotFoundException;
import com.capgemini.personality.model.CandidateDTO;
import com.capgemini.personality.service.ICandidateService;

@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	private ICandidateService candidateService;

	@RequestMapping("/listcandidates")
	public List<CandidateDTO> getAllCandidates() {
		List<CandidateDTO> candidates= candidateService.getAllCandidates();
		if(candidates.isEmpty()) {
			throw new NotFoundException("No candidates Found");
		}
		return candidates;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getcandidates/{candidateId}")
	public Optional<CandidateDTO> getCandidate(@PathVariable("candidateId") int id) throws NotFoundException {
		Optional<CandidateDTO> result = Optional.ofNullable(candidateService.getCandidate(id));
		if (!result.isPresent()) {
			throw new NotFoundException("Candidate Not Found");
		}
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcandidate")
	public CandidateDTO addCandidate(@RequestBody Candidate candidate) throws DataIntegrityViolationException {
		try {
			return candidateService.addCandidate(candidate);
		} catch (DataIntegrityViolationException e) {
			throw new ConstraintValidationException("Constraint Validation Exception" + e);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updatecandidate")
	public CandidateDTO updateCandidate(@RequestBody Candidate candidate) throws NotFoundException {
		Optional<CandidateDTO> result = Optional.ofNullable(candidateService.getCandidate(candidate.getCandidateId()));
		if (!result.isPresent()) {
			throw new NotFoundException("Candidate Not Found");
		}
		return candidateService.updateCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecandidate/{candidateId}")
	public CandidateDTO deleteCandidate(int id) throws NotFoundException {
		Optional<CandidateDTO> result = Optional.ofNullable(candidateService.getCandidate(id));
		if (!result.isPresent()) {
			throw new NotFoundException("Candidate Not Found");
		}
		return candidateService.deleteCandidate(id);
	}
}
