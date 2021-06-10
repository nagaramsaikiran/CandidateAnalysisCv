package com.capgemini.personality.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.exception.NotFoundException;
import com.capgemini.personality.model.JobDetailsDTO;
import com.capgemini.personality.service.IJobDetailsService;
/*@author name:Aravind
 * date:07/06/2021
 * Description:It processes the incoming requests regarding JobDetails
 * Last modification date:09/06/2021
 */
@RestController
@RequestMapping("/apijobdetails")
public class JobDetailsController {

	@Autowired
	private IJobDetailsService jobDetailsService;
	
	Logger logger = LoggerFactory.getLogger(JobDetailsController.class);

	@RequestMapping("/listjobdetails")
	public List<JobDetailsDTO> getAllJobDetails() {
		List<JobDetailsDTO> jobDetails= jobDetailsService.getAllJobDetails();
		if(jobDetails.isEmpty()) {
			throw new NotFoundException("No jobs Found");
		}
		logger.info("Fetching All JobDetails");
		return jobDetails;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/getjobdetails/{jobId}")
	public Optional<JobDetailsDTO> getJobDetails(@PathVariable("jobId") Integer id) {
		Optional<JobDetailsDTO> jobDetails= Optional.ofNullable(jobDetailsService.getJobDetails(id));
		if(!jobDetails.isPresent()) {
			throw new NotFoundException("job id not found");
		}
		logger.info("Fetching JobDetail with Id");
		return jobDetails;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addjobdetails")
	public JobDetailsDTO addJobDetails(@RequestBody JobDetails jobDetails) {
		logger.info("JobDetail Added");
		return jobDetailsService.addJobDetails(jobDetails);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/updatejobdetails")
	public JobDetailsDTO updateCandidate(@RequestBody JobDetails jobDetails) {
		Optional<JobDetailsDTO> jobDetails1=  Optional.ofNullable(jobDetailsService.getJobDetails(jobDetails.getJobId()));
		if(!jobDetails1.isPresent()) {
			throw new NotFoundException("job id not found");
		}
		logger.info("JobDetail Updated");
		return jobDetailsService.updateJobDetails(jobDetails);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/deletejobdetails/{jobId}")
	public JobDetailsDTO deleteCandidate(@PathVariable("jobId") Integer id) {
		Optional<JobDetailsDTO> jobDetails= Optional.ofNullable(jobDetailsService.getJobDetails(id));
		if(!jobDetails.isPresent()) {
			throw new NotFoundException("job id not found");
		}
		return jobDetailsService.deleteJobDetails(id);
	}

}
