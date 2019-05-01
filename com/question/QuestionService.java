package com.question;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class QuestionService {
	private final QuestionRepository questionRepository;
	
	public QuestionService(QuestionRepository questionRepo) {
		questionRepository = questionRepo;
	}

	public List<Question> findAllByQuiz(String title) {
		List<Question> list = questionRepository.findAllByQuizTitle(title);
		return list;
	}

	public void addQuestoin(Question question) {
		questionRepository.save(question);
	}

	public Question getByStatement(String statement) {
		return questionRepository.findByStatement(statement);
	}
	
	public boolean validateQuestion(Question question) {
		String correctChoice;
		String[] choices;
		choices = question.getChoices();
		correctChoice = question.getCorrectChoice();
		
		return (correctChoice.equals(choices[0]) || correctChoice.equals(choices[1])
				|| correctChoice.equals(choices[2]) || correctChoice.equals(choices[3]));
	}
}
