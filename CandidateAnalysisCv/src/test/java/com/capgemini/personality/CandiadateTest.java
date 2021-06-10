package com.capgemini.personality;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.personality.model.CandidateDTO;

@SpringBootTest
public class CandiadateTest {
	RestTemplate restTemplate=new RestTemplate();

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	private CandidateDTO getCandidateDto() {
		CandidateDTO candidateDto = new CandidateDTO();
		candidateDto.setCandidateId(10);
		candidateDto.setName("veera");
		candidateDto.setMobileNum("1234567890");
		candidateDto.setEmailId("veera2345@gmail.com");
		return candidateDto;
	}
	@Test
	void testFindCandidateById() {
		ResponseEntity<CandidateDTO> response = restTemplate.getForEntity("http://localhost:9102/api/getcandidate/41",CandidateDTO.class);
		int code = response.getStatusCodeValue();
		equals(200);
	}

}
