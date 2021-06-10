package com.capgemini.personality;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.capgemini.personality.model.SkillDTO;
@SpringBootApplication
public class SkillTest {
	RestTemplate restTemplate=new RestTemplate();

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	private SkillDTO getSkillDto() {
		 SkillDTO  skillDTO = new SkillDTO();
		 skillDTO.setSkillId(50);
		 skillDTO.setSkillName("java");
		 
		
		return skillDTO;
	}
	@Test
	void testFindSkillsById() {
		ResponseEntity<SkillDTO> response = restTemplate.getForEntity("http://localhost:9102/service/getskill/1",SkillDTO.class);
		int code = response.getStatusCodeValue();
		equals(200);
}
}
