package com.capgemini.personality.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
/*@author name:Akhil and Rajitha
 * date:07/06/2021
 * Description:It processes the incoming requests regarding candidates
 * Last modification date:09/06/2021
 */
@RestController
@RequestMapping("/api")
public class CandidateController {

	@Autowired
	private ICandidateService candidateService;
	Logger logger = LoggerFactory.getLogger(CandidateController.class);


	@RequestMapping("/listcandidates")
	public List<CandidateDTO> getAllCandidates() {
		List<CandidateDTO> candidates= candidateService.getAllCandidates();
		if(candidates.isEmpty()) {
			throw new NotFoundException("No candidates Found");
		}
		logger.info("Fetching All Candidates");
		return candidates;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getcandidate/{candidateId}")
	public Optional<CandidateDTO> getCandidate(@PathVariable("candidateId") Integer id) throws NotFoundException {
		Optional<CandidateDTO> result = Optional.ofNullable(candidateService.getCandidate(id));
		if (!result.isPresent()) {
			throw new NotFoundException("Candidate Not Found");
		}
		logger.info("Fetching candidate by Id");
		return result;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcandidate")
	public CandidateDTO addCandidate(@RequestBody Candidate candidate) throws DataIntegrityViolationException {
		logger.info("Candidate Added");
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
		logger.info("Updating the Candidate");
		return candidateService.updateCandidate(candidate);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletecandidate/{candidateId}")
	public CandidateDTO deleteCandidate(@PathVariable("candidateId") Integer id) throws NotFoundException {
		Optional<CandidateDTO> result = Optional.ofNullable(candidateService.getCandidate(id));
		if (!result.isPresent()) {
			throw new NotFoundException("Candidate Not Found");
		}
		logger.info("Deleting the Candidate ");
		return candidateService.deleteCandidate(id);
	}
}
