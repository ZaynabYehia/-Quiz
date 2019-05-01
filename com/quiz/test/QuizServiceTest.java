package com.quiz.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.quiz.Quiz;
import com.quiz.QuizRepository;
import com.quiz.QuizService;

@RunWith(MockitoJUnitRunner.class)
public class QuizServiceTest {
	@Mock
	QuizRepository quizRepository;
	@InjectMocks
	QuizService quizService;
	
	@Test
	public void incrementTest() {
		Quiz quiz = new Quiz("title", "skill", 0, 0);
		Optional<Quiz> op = Optional.of(quiz);
		
		when(quizRepository.findById("title")).thenReturn(op);
		quizService.increment("title");
		assertEquals(Integer.valueOf(1), op.get().getNumberOfQuestion());
	}
}
