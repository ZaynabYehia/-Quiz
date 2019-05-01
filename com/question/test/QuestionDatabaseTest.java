package com.question.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.question.Question;
import com.question.QuestionRepository;
import com.quiz.Quiz;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuestionDatabaseTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	public void findAllByQuizTitleTest() {
		Quiz quiz1, quiz2;
		quiz1 = new Quiz("title1", "skill1", 12, 31);
		quiz2 = new Quiz("title2", "skill2", 11, 23);
		entityManager.persistAndFlush(quiz1);
		entityManager.persistAndFlush(quiz2);
		
		Question question1, question2, question3;
		question1 = new Question("question1 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice2",
				quiz1);
		question2 = new Question("question2 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice4",
				quiz2);
		question3 = new Question("question3 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice1",
				quiz2);
		entityManager.persistAndFlush(question1);
		entityManager.persistAndFlush(question2);
		entityManager.persistAndFlush(question3);

		List<Question> questions = questionRepository.findAllByQuizTitle("title2");
		assertEquals(questions.size(), 2);
		assertTrue(questions.contains(question2));
		assertTrue(questions.contains(question3));
	}

	@Test
	public void findByStatementTest() {
		Quiz quiz1, quiz2;
		quiz1 = new Quiz("title1", "skill1", 12, 31);
		quiz2 = new Quiz("title2", "skill2", 11, 23);
		entityManager.persistAndFlush(quiz1);
		entityManager.persistAndFlush(quiz2);
		
		Question question1, question2, question3;
		question1 = new Question("question1 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice2",
				quiz1);
		question2 = new Question("question2 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice4",
				quiz2);
		question3 = new Question("question3 ??", new String[] { "choice1, choice2, choice3, choice4" }, "choice1",
				quiz2);
		entityManager.persistAndFlush(question1);
		entityManager.persistAndFlush(question2);
		entityManager.persistAndFlush(question3);

		Question question = questionRepository.findByStatement("question2 ??");
		assertEquals(question, question2);
	}
}
