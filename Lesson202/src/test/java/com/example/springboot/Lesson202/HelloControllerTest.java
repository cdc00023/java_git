package com.example.springboot.Lesson202;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
	/*
	 * MockMvc는 Spring Test에서 제공되며, 편리한 빌더 클래스 세트를 통해 
	 * HTTP Request를 DisparcherServlet으로 보내고 결과를 받아볼 수 있다.
	 * @AutoConfigureMockMvc와 @SpringBootTest를 사용하여 MockMvc인스턴스를 삽입.
	 */
	@Autowired
	private Mock mvc;
	
	@Test
	public void getHello() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpext(content().string(equalTo("Hi, Nice to meet you. from spring boot...")));
	}
	
}
