package com.capgemini.personality;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.personality.model.JobDetailsDTO;
@SpringBootApplication
public class JobDetailsTest {
	RestTemplate restTemplate=new RestTemplate();

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	private JobDetailsDTO getJobDetailsDto() {
		JobDetailsDTO jobDetailsDto = new JobDetailsDTO();
		jobDetailsDto.setJobId(50);
		jobDetailsDto.setRole("java developer");
		jobDetailsDto.setExperience(5);
		
		return jobDetailsDto;
	}
	@Test
	void testFindJobDetailsById() {
		ResponseEntity<JobDetailsDTO> response = restTemplate.getForEntity("http://localhost:9102/apijobdetails/getjobdetails/16",JobDetailsDTO.class);
		int code = response.getStatusCodeValue();
		equals(200);
	}

}
