package com.quiz.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.quiz.Quiz;
import com.quiz.QuizRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuizDatabaseTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private QuizRepository quizRepository;

	@Test
	public void findAllTest() {
		Quiz quiz1, quiz2, quiz3;
		quiz1 = new Quiz("title1", "skill1", 12, 15);
		quiz2 = new Quiz("title2", "skill2", 15, 20);
		quiz3 = new Quiz("title3", "skill1", 5, 14);
		entityManager.persist(quiz1);
		entityManager.persist(quiz2);
		entityManager.persist(quiz3);

		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		quizRepository.findAll().forEach(quizzes::add);
		assertTrue(quizzes.contains(quiz1));
		assertTrue(quizzes.contains(quiz2));
		assertTrue(quizzes.contains(quiz3));
	}

	@Test
	public void findAllBySkillTest() {
		Quiz quiz1, quiz2, quiz3;
		quiz1 = new Quiz("title1", "skill1", 12, 15);
		quiz2 = new Quiz("title2", "skill2", 15, 20);
		quiz3 = new Quiz("title3", "skill1", 5, 14);
		entityManager.persistAndFlush(quiz1);
		entityManager.persistAndFlush(quiz2);
		entityManager.persistAndFlush(quiz3);

		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		quizRepository.findAllBySkill("skill1").forEach(quizzes::add);
		assertEquals(quizzes.size(), 2);
		assertTrue(quizzes.contains(quiz1));
		assertTrue(quizzes.contains(quiz3));
	}

	@Test
	public void findByIdTest() {
		Quiz quiz1, quiz2, quiz3;
		quiz1 = new Quiz("title1", "skill1", 12, 15);
		quiz2 = new Quiz("title2", "skill2", 15, 20);
		quiz3 = new Quiz("title3", "skill1", 5, 14);
		entityManager.persistAndFlush(quiz1);
		entityManager.persistAndFlush(quiz2);
		entityManager.persistAndFlush(quiz3);

		Optional<Quiz> op = quizRepository.findById("title1");
		assertFalse(op.isEmpty());
		assertEquals(op.get(), quiz1);
	}
}
