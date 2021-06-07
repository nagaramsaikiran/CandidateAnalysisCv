package com.capgemini.personality.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.personality.entity.Candidate;
import com.capgemini.personality.model.CandidateDTO;
@Component
public class CandidateUtil {
	public static List<CandidateDTO> convertToCandidateDtoList(List<Candidate> list) {
		List<CandidateDTO> dtolist = new ArrayList<>();
		for (Candidate candidate : list)
			dtolist.add(convertToCandidateDto(candidate));
		return dtolist;
	}

	public static Candidate convertToCandidate(CandidateDTO candidatedto) {
		Candidate candidate = new Candidate();
		candidate.setName(candidatedto.getName());
		candidate.setCandidateId(candidatedto.getCandidateId());
		candidate.setSkills(candidatedto.getSkills());
		candidate.setExperience(candidatedto.getExperience());
		candidate.setAppliedJobs(candidatedto.getJobDetails());
		return candidate;
	}

	public static CandidateDTO convertToCandidateDto(Candidate candidate) {
		CandidateDTO candidateDTO = new CandidateDTO();
		candidateDTO.setName(candidate.getName());
		candidateDTO.setCandidateId(candidate.getCandidateId());
		candidateDTO.setSkills(candidate.getSkills());
		candidateDTO.setExperience(candidate.getExperience());
		candidateDTO.setJobDetails(candidate.getAppliedJobs());
		return candidateDTO;
	}

}
