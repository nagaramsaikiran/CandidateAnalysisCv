package com.capgemini.personality.service;

import java.util.List;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;

public interface ICandidateService {
	public CandidateDTO getCandidate(int id);
	
	public List<CandidateDTO> getAllCandidates();

	public CandidateDTO addCandidate(Candidate candidate);

	public CandidateDTO updateCandidate(Candidate candidate);

	public CandidateDTO deleteCandidate(int id);

}
