package com.quiz.test;

import java.util.ArrayList;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.quiz.Quiz;
import com.quiz.QuizController;
import com.quiz.QuizService;

@RunWith(SpringRunner.class)
@WebMvcTest(QuizController.class)
public class QuizControllerTest {
	@MockBean
	QuizService quizService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void getAllQuizzesTest() throws Exception{
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		quizzes.add(new Quiz("quiz1", "skill1", 0, 0));
		quizzes.add(new Quiz("quiz2", "skill2", 0, 0));
		
		when(quizService.getAllQuizzes()).thenReturn(quizzes);
		mockMvc.perform(get("/quizzes"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("quizzes", hasItem(quizzes.get(0))))
		.andExpect(model().attribute("quizzes", hasItem(quizzes.get(1))))
		.andExpect(forwardedUrl("/WEB-INF/view/quizzes.jsp"));
	}
	
	@Test
	public void getAllbySkillTest() throws Exception{
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		quizzes.add(new Quiz("quiz1", "skill1", 0, 0));
		quizzes.add(new Quiz("quiz2", "skill1", 0, 0));
		
		when(quizService.getAllBySkill("skill1")).thenReturn(quizzes);
		mockMvc.perform(get("/quizzes/skill1"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("quizzes", hasItem(quizzes.get(0))))
		.andExpect(model().attribute("quizzes", hasItem(quizzes.get(1))))
		.andExpect(forwardedUrl("/WEB-INF/view/quizzes.jsp"));
	}
	
	@Test
	public void addQuizGetTest() throws Exception{
		mockMvc.perform(get("/quizzes/addQuiz"))
		.andExpect(forwardedUrl("/WEB-INF/view/addQuiz.jsp"));
	}
	
	@Test
	public void updateCounterTest() throws Exception{
		mockMvc.perform(get("/quizzes/title/counter"))
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("/quizzes"));
	}
	
	@Test
	public void addQuizPostTest() throws Exception{
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		quizzes.add(new Quiz("quiz1", "skill1", 0, 0));
		quizzes.add(new Quiz("quiz2", "skill1", 0, 0));
		
		mockMvc.perform(post("/quizzes?title=quizTitle&skill=quizSkill&passScore=0&duration=0"))
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("/quizzes"));
	}
}
