package com.question.test;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.question.Question;
import com.question.QuestionController;
import com.question.QuestionService;
import com.quiz.Quiz;

@RunWith(SpringRunner.class)
@WebMvcTest(QuestionController.class)
public class QuestionControllerTest {
	
	@MockBean
	QuestionService questionService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void addQuestionTest() throws Exception{
		mockMvc.perform(get("/questions/quizTitle"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/view/addQuestion.jsp"))
		.andExpect(model().attribute("title", "quizTitle"));
	}
	
	@Test
	public void addValidQuestoinTest() throws Exception{
		Question question = new Question("question statemet ??", new String[] {"choice1 value", "choice2 value", "choice3 value", "choice4 value"}, "choice1 value", new Quiz("quizTitle", "", 0, 0));
		when(questionService.validateQuestion(question)).thenReturn(true);
		mockMvc.perform(post("/questions/quizTitle").param("statement", "question statemet ??")
				.param("choice1", "choice1 value")
				.param("choice2", "choice2 value")
				.param("choice3", "choice3 value")
				.param("choice4", "choice4 value")
				.param("correctChoice", "choice1 value"))
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("/quizzes/quizTitle/counter"));
	}
	
	@Test
	public void addNotValidQuestoinTest() throws Exception{
		Question question = new Question("question statemet ??", new String[] {"choice1 value", "choice2 value", "choice3 value", "choice4 value"}, "choice6 value", new Quiz("quizTitle", "", 0, 0));
		when(questionService.validateQuestion(question)).thenReturn(false);
		mockMvc.perform(post("/questions/quizTitle").param("statement", "question statemet ??")
				.param("choice1", "choice1 value")
				.param("choice2", "choice2 value")
				.param("choice3", "choice3 value")
				.param("choice4", "choice4 value")
				.param("correctChoice", "choice6 value"))
		.andExpect(status().isFound())
		.andExpect(redirectedUrl("/questions/quizTitle"));
	}
	
	@Test 
	public void takeQuizTest() throws Exception{
		Question question1, question2;
		question1 = new Question("questoin1 ??", new String[] {"choice1, choice2, choice3, choice4"}, "choice2", new Quiz("title", "", 0, 0));
		question2 = new Question("questoin2 ??", new String[] {"choice1, choice2, choice3, choice4"}, "choice3", new Quiz("title", "", 0, 0));
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(question1);
		questions.add(question2);
		
		when(questionService.findAllByQuiz("title")).thenReturn(questions);
		mockMvc.perform(get("/questions//takequiz/title"))
		.andExpect(status().isOk())
		.andExpect(model().attribute("questions", hasItem(question1)))
		.andExpect(model().attribute("questions", hasItem(question2)))
		.andExpect(model().attribute("quizTitle", "title"))
		.andExpect(forwardedUrl("/WEB-INF/view/takeQuiz.jsp"));
	}
}
