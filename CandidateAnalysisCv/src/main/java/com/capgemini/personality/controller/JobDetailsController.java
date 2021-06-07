package com.capgemini.personality.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.personality.entity.JobDetails;
import com.capgemini.personality.model.JobDetailsDTO;
import com.capgemini.personality.service.IJobDetailsService;

@RestController
@RequestMapping("/apijobdetails")
public class JobDetailsController {


		@Autowired
		private IJobDetailsService jobDetailsService;

		@RequestMapping("/listjobdetails")
		public List<JobDetailsDTO> getAllJobDetails() {
			return jobDetailsService.getAllJobDetails();
		}

		@RequestMapping("/getjobdetails/{jobId}")
		public JobDetailsDTO getJobDetails(@PathVariable int id) {
			return jobDetailsService.getJobDetails(id);
			
		}

		@RequestMapping(method = RequestMethod.POST, value = "/addjobdetails")
		public JobDetailsDTO addJobDetails(@RequestBody JobDetails jobDetails) {
			return jobDetailsService.addJobDetails(jobDetails);
		}
		
		@RequestMapping(method = RequestMethod.PUT, value = "/updatejobdetails")
		public JobDetailsDTO updateCandidate(@RequestBody JobDetails jobDetails) {
			return jobDetailsService.updateJobDetails( jobDetails);
		}
		
		@RequestMapping(method = RequestMethod.DELETE, value = "/deletejobdetails/{jobId}")
		public JobDetailsDTO deleteCandidate(int id) {
			return jobDetailsService.deleteJobDetails(id);
		}

}
