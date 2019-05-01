package com.question.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.question.Question;
import com.question.QuestionRepository;
import com.question.QuestionService;
import com.quiz.Quiz;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {	
	@Mock
	QuestionRepository questionRepositoryMock;
	@InjectMocks
	QuestionService questionService;
	
	@Test
	public void validateQuestionValidTest() {
		Question question = new Question("question statement ??", new String[] {"choice1", "choice2", "choice3", "choice4"}, "choice1", new Quiz("title", "", 0, 0));
		assertTrue(questionService.validateQuestion(question));
	}
	
	@Test
	public void validateQuestionNotValidTest() {
		Question question = new Question("question statement ??", new String[] {"choice1", "choice2", "choice3", "choice4"}, "choice6", new Quiz("title", "", 0, 0));
		assertFalse(questionService.validateQuestion(question));
	}
}
