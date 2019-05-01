package com.quiz;

import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuizService {
	private final QuizRepository quizRepository;
	
	public QuizService(QuizRepository quizRepo) {
		quizRepository = quizRepo;
	}
	
	public List<Quiz> getAllQuizzes(){
		List<Quiz> list = new ArrayList<Quiz>();
		quizRepository.findAll().forEach(list::add);
		return list;
	}
	public List<Quiz>getAllBySkill(String skill){
		List<Quiz>list = quizRepository.findAllBySkill(skill);
		return list;
	}
	public void increment(String title) {
		Quiz quiz = quizRepository.findById(title).get();
		quiz.setNumberOfQuestion(quiz.getNumberOfQuestion() + 1);
		quizRepository.save(quiz);
	}
	public Quiz getQuiz(String title) {
		return quizRepository.findById(title).orElse(null);
	}
	public void addQuiz(Quiz quiz) {
		quizRepository.save(quiz);
	}
}
