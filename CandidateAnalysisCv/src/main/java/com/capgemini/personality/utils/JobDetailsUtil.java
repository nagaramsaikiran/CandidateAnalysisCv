package com.capgemini.personality.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;
@Component
public class JobDetailsUtil {
	public static List<JobDetailsDTO> convertToJobDetailsDtoList(List<JobDetails> list) {
		List<JobDetailsDTO> dtolist = new ArrayList<>();
		for (JobDetails jobdetails : list)
			dtolist.add(convertToJobDetailsDto(jobdetails));
		return dtolist;
	}

	public static JobDetails convertToJobDetails(JobDetailsDTO jobDetailsDTO) {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setRole(jobDetailsDTO.getRole());
		jobDetails.setJobId(jobDetailsDTO.getJobId());
		jobDetails.setSkills(jobDetailsDTO.getSkills());
		jobDetails.setExperience(jobDetailsDTO.getExperience());
		jobDetails.setAppliedCandidates(jobDetailsDTO.getAppliedCandidates());
		return jobDetails;
	}

	public static JobDetailsDTO convertToJobDetailsDto(JobDetails jobDetails) {
		JobDetailsDTO jobdetailsDTO = new JobDetailsDTO();
		jobdetailsDTO.setRole(jobDetails.getRole());
		jobdetailsDTO.setJobId(jobDetails.getJobId());
		jobdetailsDTO.setSkills(jobDetails.getSkills());
		jobdetailsDTO.setExperience(jobDetails.getExperience());
		jobdetailsDTO.setAppliedCandidates(jobDetails.getAppliedCandidates());
		return jobdetailsDTO;
	}

}


