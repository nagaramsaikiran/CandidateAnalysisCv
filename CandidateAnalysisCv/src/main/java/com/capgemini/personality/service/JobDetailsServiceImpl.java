package com.capgemini.personality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;
import com.capgemini.personality.repository.IJobDetailsRepository;
import com.capgemini.personality.utils.JobDetailsUtil;
@Service
public class JobDetailsServiceImpl implements IJobDetailsService {
@Autowired
IJobDetailsRepository jobRepo;
@Autowired
JobDetailsUtil jdu;
	@Override
	public List<JobDetailsDTO> getAllJobDetails() {
		List<JobDetails> list=jobRepo.findAll();
		return jdu.convertToJobDetailsDtoList(list);
	}

	@Override
	public JobDetailsDTO getJobDetails(int id) {
		JobDetails jd=jobRepo.getById(id);
		return jdu.convertToJobDetailsDto(jd);
	}

	@Override
	public JobDetailsDTO addJobDetails(JobDetails jobDetails) {
		jobRepo.save(jobDetails);
		return jdu.convertToJobDetailsDto(jobDetails);
	}

	@Override
	public JobDetailsDTO updateJobDetails( JobDetails jobDetails) {
		jobRepo.saveAndFlush(jobDetails);
		return jdu.convertToJobDetailsDto(jobDetails);
	}

	@Override
	public JobDetailsDTO deleteJobDetails(int id) {
		JobDetails jd=jobRepo.getById(id);
		jobRepo.deleteById(id);
		return jdu.convertToJobDetailsDto(jd);
	}

}
