package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;
import com.capgemini.personality.repository.ICandidateRepository;
import com.capgemini.personality.utils.CandidateUtil;

/*@author name:M.Akhil And M.Rajitha
 * date:05/06/2021
 * Description:CandidateService  description
 * Last modification date:09/06/2021
 */
@Service
public class CandidateServiceImpl implements ICandidateService {

	@Autowired
	ICandidateRepository candRepo;
	@Autowired
	CandidateUtil cu;

	@Override
	public CandidateDTO getCandidate(int id) {
		Candidate candy = candRepo.getById(id);
		return cu.convertToCandidateDto(candy);
	}

	@Override
	public List<CandidateDTO> getAllCandidates() {
		List<Candidate> list = candRepo.findAll();
		return cu.convertToCandidateDtoList(list);
	}

	@Override
	public CandidateDTO addCandidate(Candidate candidate) {
		Candidate candy = candRepo.save(candidate);
		return cu.convertToCandidateDto(candy);
	}

	@Override
	public CandidateDTO updateCandidate(Candidate candidate) {

		Candidate candy = candRepo.saveAndFlush(candidate);
		return cu.convertToCandidateDto(candy);
	}

	@Override
	public CandidateDTO deleteCandidate(int id) {
		Candidate candy = candRepo.getById(id);
		candRepo.deleteById(id);
		return cu.convertToCandidateDto(candy);
	}

}
